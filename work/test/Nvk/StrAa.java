package Nvk;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述：
 * 众所周知，切换大小写有两种方式，一种是按下“caps locks”，也就是大写锁定键，这样一来，之后的输入模式都会被切换。
 * 另一种是同时按下shift和需要打印的字母，可以临时切换大小写(算作按下两个键)。
 *
 * 已知初始状态下，打字模式是小写，现在给出需要打印的字符串(区分大小写)，请你计算出最少需按键多少次才能打印出来。
 *
 * 输入
 * 输入第一行仅包含一个正整数n，表示字符串的长度(1<=n<=1000000)。
 * 输入第二行包含一个长度为n的字符串，仅包含大小写字母。
 *
 * 输出
 * 输出仅包含一个正整数，即最少的按键次数。
 *
 *
 * 样例输入
 * 6
 * AaAAAA
 * 样例输出
 * 8
 */
public class StrAa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            String str = in.next();
            char[] strc = str.toCharArray();
            int count = 0;
            String min = "";
            String max = "";
            for (int i=0; i<n; i++){
                if(strc[i]>='A' && strc[i]<='Z'){
                    if(min.length()!=0) {
                        count += min.length();
                        min = "";
                    }
                    max += strc[i];

                }else if(strc[i]>='a' && strc[i]<='z') {
                    if(max.length()>1){
                        count += max.length()+2;
                        max = "";
                    }else if(max.length()==1){
                        count += max.length()+1;
                        max = "";
                    }
                    min += strc[i];
                }
            }
            if(max.length()==0){
                count += min.length();
            }else {
                count +=max.length()+1;
            }

            System.out.println(count);


        }


    }

    public static void Fun1(int n, String str){
        char[] strc = str.toCharArray();
        int count = 0;
        String min = "";
        String max = "";
        for (int i=0; i<n; i++){
            if(strc[i]>='A' && strc[i]<='Z'){
                if(min.length()!=0) {
                    count += min.length();
                    min = "";
                }
                max += strc[i];

            }else {
                if(max.length()>1){
                    count += max.length()+2;
                    max = "";
                }else if(max.length()==1){
                    count += max.length()+1;
                    max = "";
                }
                min += strc[i];
            }
        }
        if(max.length()==0){
            count += min.length();
        }else {
            count +=max.length()+1;
        }

        System.out.println(count);
    }

    public static void Fun(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            String str = in.next();
            char[] strc = str.toCharArray();
            int count = 0;
            Stack<Character> stackA = new Stack<>();
            Stack<Character> stacka = new Stack<>();
            for (int i=0; i<n; i++){
                if(strc[i]>='A' && strc[i]<='Z'){
                    count += stacka.size();
                    stacka.clear();
                    //如果大写栈为空
                    stackA.push(strc[i]);

                }else {
                    count += stackA.size()+1;
                    stackA.clear();
                    stacka.push(strc[i]);

                }

            }
            if(stacka.empty()){
                count += stackA.size()+1;
            }else {
                count += stacka.size();
            }
            System.out.println(count);




        }
    }
}
