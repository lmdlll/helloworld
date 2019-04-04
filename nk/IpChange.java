package Nvk;

import java.util.Scanner;

/**
 * 整数与ip地址的转换
 * 10.0.3.193 --> 00001010 00000000 00000011 11000001 （167773121）
 * 输入:输入ip地址  输入10进制的ip地址
 * 输出：装换成10进制的ip地址  转换后的ip地址
 *
 * eg：
 * 输入：
 * 10.0.3.193
 * 167969729
 *
 * 输出：
 * 167773121
 * 10.3.3.193
 *
 */

/**
 * 总结：要善用方法
 * Long：  toBinaryString(long i) 返回long参数的字符串表示形式为基数2中的无符号整数。
 * String： format(String format, Object... args)  使用指定的格式字符串和参数返回格式化的字符串。
 *          substring(int beginIndex) 返回一个字符串，该字符串是此字符串的子字符串。
 */
public class IpChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            // 判断输入是IP地址还是十进制数
            if (str.contains(".")) {
                String[] arr = str.split("\\.");
                long[] ip = new long[arr.length];
                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < arr.length; i++) {
                    ip[i] = Long.parseLong(arr[i]);
                    String a = Long.toBinaryString(ip[i]);
                    //转成8位二进制 利用String.format()控制格式
                    String temp = String.format("%08d", Long.parseLong(a));
                    sb.append(temp);
                }
                long output = Long.parseLong(sb.toString(), 2);
                System.out.println(output);
            } else {
                String binaryChuan = Long.toBinaryString(Long.parseLong(str));
                int len = binaryChuan.length();
                StringBuilder sb = new StringBuilder(binaryChuan);
                // 不足32位的前面补0
                for (int i = 0; i < 32 - len; i++) {
                    sb.insert(0, "0");
                }
                String fin = sb.toString();
                long a = Long.valueOf(fin.substring(0, 8), 2);
                long b = Long.valueOf(fin.substring(8, 16), 2);
                long c = Long.valueOf(fin.substring(16, 24), 2);
                long d = Long.valueOf(fin.substring(24, 32), 2);
                System.out.println(a + "." + b + "." + c + "." + d);
            }
        }

    }

    public static void change(String m, String n){
        ten(m);
        two(n);
    }
    //输入ip，转换为10进制
    public static void ten(String str){
        String[] data = str.split("\\.");
        String tmp = "";
        for(int i=0; i<data.length; i++){
            int shi = Integer.parseInt(data[i]);
            StringBuffer er = new StringBuffer("");
            //先转换为2进制
            while (shi!=0){
                er.append(shi%2);
                shi /= 2;
            }
            er = er.reverse();
            int len = 8-er.length();
            while (len!=0){
                tmp += "0";
                len--;
            }
            tmp += er;
        }
        int result = 0;
        //计算二进制
        for(int i=tmp.length()-1; i>=0; i--){
            int er = Integer.parseInt(String.valueOf(tmp.charAt(i)));
            result += er*ch2(31-i);
        }
        System.out.println(result);
    }
    public static int ch2(int n){
        int m = 1;
        for(int i=0; i<n; i++){
            m *= 2;
        }
        return m;
    }
    //输入10进制，转换为ip地址
    public static void two(String str){
        long shi = Long.parseLong(str);
        StringBuffer er = new StringBuffer("");
        String tmp = "";
        //先转换为2进制
        while (shi!=0){
            er.append(shi%2);
            shi /= 2;
        }
        int len = 32-er.length();
        while (len!=0){
            tmp += "0";
            len--;
        }
        er = er.reverse();
        tmp += er;
        long a = Long.valueOf(tmp.substring(0, 8), 2);
        long b = Long.valueOf(tmp.substring(8, 16), 2);
        long c = Long.valueOf(tmp.substring(16, 24), 2);
        long d = Long.valueOf(tmp.substring(24, 32), 2);
        System.out.println(a + "." + b + "." + c + "." + d);

    }

    private static void TentoIp(String p) {
        long temp=Long.parseLong(p);
        String ip=Long.toBinaryString(temp);

        StringBuilder sb=new StringBuilder();
        if(ip.length()<32){
            for(int i=0;i<(32-ip.length());i++){
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length()==32){
            sb.append(ip);
        }
        for(int i=0;i<sb.length()-8;i=i+8){
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }

        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));

    }

    private static long IptoTen(String ip) {
        String[] arr=ip.split("\\.");
        long n=Long.parseLong(arr[0]);

        for(int i=1;i<arr.length;i++){
            n=n<<8;
            n=n+Long.parseLong(arr[i]);
        }

        return n;
    }

}
