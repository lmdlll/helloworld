package Nvk;

import test1.lmd.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 电话号码
 * 企鹅王国以8开头的11位电话号码
 * 企鹅国王的电话号码是11个8：:88888888888
 * 现在给出一串长度为n的字符串s，只包含数字
 * 每次操作，可以删除任意一个字符,给出一个字符串判断是否可以通过一次或n次变为国王的号码
 *
 * 输入：
 * t 表示测试用例的组数
 * 接下来2t行，每个测试用例包含两行
 * 第一行整数n，表示字符串长度
 * 第二行，字符串
 *
 * 输入：
 * 2
 * 11
 * 88888888888
 * 3
 * 000
 * 输出：
 * YES
 * NO
 */
public class PhoneNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            int n = in.nextInt();
            for (int i=0; i<n; i++){
                int len = in.nextInt();
                String data = in.next();
                Judge(data,len);
            }

        }

    }

    private static void Judge2(String data, int len) {
        if(len<11 || data.length()!=len){
            System.out.println("NO");
            return;
        }
        while (data.length()>=11){
            if(data.startsWith("8")){
                System.out.println("YES");
                return;
            }else {
                data = data.substring(1);
            }
        }
        System.out.println("NO");

    }

    private static void Judge(String data, int len) {
        if(len<11){
            System.out.println("NO");
            return;
        }
        int[] ndata = new int[len];
        for (int i=0; i<len; i++){
            ndata[i] = Integer.parseInt(String.valueOf(data.charAt(i)));
        }

        char[] tmp = data.toCharArray();
        Arrays.sort(tmp);

        while (ndata.length>=11){
            Arrays.sort(ndata);
            if(ndata[0]==8 && ndata[ndata.length-1]==8){
                System.out.println("YES");
                return;
            }else if(ndata[0]!=8) {
                int[] nn = new int[ndata.length-1];
                System.arraycopy(ndata,1,nn,0,nn.length);
                ndata = nn;
            }else if(ndata[ndata.length-1]!=8){
                int[] nn = new int[ndata.length-1];
                System.arraycopy(ndata,0,nn,0,nn.length);
                ndata = nn;
            }
        }
        System.out.println("NO");

    }

}
