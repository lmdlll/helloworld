package edu.greatfree.p2p.message;

import java.io.*;

public class sendpicture {
//    public static void main(String[] args) throws IOException {
//        String respath = "C:"+File.separator+"Users"+File.separator+"acer"+File.separator+"Desktop"+File.separator+"yun.jpg";
//        String despath = "C:"+File.separator+"Users"+File.separator+"acer"+File.separator+"Desktop"+File.separator+"yun1.jpg";
//        System.out.println(copyFile(respath,despath));
//    }
    //绝对路径
    public static boolean copyFile(String soupath, String despath) throws IOException {
        //1.取得File对象
        File resfile = new File(soupath);
        File desfile = new File(despath);
        //2.取得输入输出流
        InputStream in = new FileInputStream(resfile);
        OutputStream out = new FileOutputStream(desfile);
        //数据的输入输出
        long start = System.currentTimeMillis();
        int len = 0;
        //引人缓存区
        byte[] data = new byte[1024];
        while ((len=in.read(data))!=-1){
            out.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
        return true;
    }

}
