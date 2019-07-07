package ins.platform.web.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @Description: 下载图片
 * @author: 
 * @date: 2018年1月5日 上午11:31:05
 * @version V1.0
 * @Copyright: 2018 www.newtouch.cn . All rights reserved.
 *
 */
public class PictureDownLoadUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PictureDownLoadUtil.class);
    private static final int PROTECTED_LENGTH = 1024 * 1024;// 输入流保护 1M

    public static String downLoad(String strUrl, Boolean isProxy, String host, String port) {
        if (isProxy) {
            setProxy(host, port);
        }
        URL url = null;
        try {
            url = new URL(strUrl);
        } catch (MalformedURLException e2) {
            LOGGER.error("下载图片异常，新建URL失败");
            return "";
        }
        InputStream is = null;
        try {
            is = url.openStream();
            return readInfoStreamToBytes(is);
        } catch (IOException e1) {
            LOGGER.error("下载图片异常");
            return "";
        }
    }

    public static void setProxy(String host, String port) {
        System.setProperty("proxySet", "true");
        System.setProperty("proxyHost", host);
        System.setProperty("proxyPort", port);
    }

    public static void main(String[] args) {
        String str = "http://www.5068.com/tupian/dmtp/421457_2.html";
        String picStr = PictureDownLoadUtil.downLoad(str, true, "", "");
        GenerateImage(picStr);
        System.out.print(picStr);

    }

    public static boolean GenerateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            String imgFilePath = "d://qq.jpg";// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String readInfoStreamToBytes(InputStream is) {
        if (is == null) {
            LOGGER.error("输入流为null");
            return null;
        }

        // 字节数组
        byte[] bCache = new byte[2048];
        int readSize = 0;// 每次读取的字节长度
        int totalSize = 0;// 总字节长度
        ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
        try {
            // 一次性读取2048字节
            while ((readSize = is.read(bCache)) > 0) {
                totalSize += readSize;
                if (totalSize > PROTECTED_LENGTH) {
                    LOGGER.error("输入流超出1M大小限制");
                    return null;
                }
                // 将bcache中读取的input数据写入infoStream
                infoStream.write(bCache, 0, readSize);
            }
        } catch (IOException e1) {
            LOGGER.error("输入流读取异常");
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                LOGGER.error("输入流关闭异常");
            }
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(infoStream.toByteArray());
    }

}