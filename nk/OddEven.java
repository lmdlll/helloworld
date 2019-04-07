package Nvk;

import java.util.Scanner;

/**
 * 奇偶校验
 * 输入一个字符串，让对每个字符进行奇校验，最后输出校验后的二进制数（3 --> 10110011）
 *
 * 输入：
 *  3
 *  3
 *  a
 * 输出：
 *  10110011
 *  10110011
 *  01100001
 *
 * 这一题里面将数字和字母统一看成是char类型的，所以数字3实际存储时为ASCII码中的‘3’，其十进制表示是51，
 * 转化为二进制表示就是0110011，取最高位为奇校验位，校验位为1，所以校验后的二进制数为10110011，字母同理。
 * 故本题只需将输入的字符减去‘\0’得到字符的十进制表示，再将其转化为七位二进制数加上一位校验位输出即可。
 *
 * 思想就是：转为2进制后1的个数为偶数最高位要补1
 */

public class OddEven {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String ch = in.next();
            change(ch.toCharArray());
        }

    }

    public static void change(char[] tmp){
        for(int j=0; j<tmp.length; j++) {
            char ch = tmp[j];
            Integer n = Integer.valueOf(ch);
            String m = n.toBinaryString(ch);
            String t = "";
            int count = 7 - m.length();
            while (count > 0) {
                t += "0";
                count--;
            }
            m = t + m;
            char[] data = m.substring(0,7).toCharArray();
            for (int i = 0; i < data.length; i++) {
                if (data[i] == '1') {
                    count++;
                }
            }
            if (count % 2 == 0) {
                System.out.print("1");
                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i]);
                }
            } else {
                System.out.print("0");
                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i]);
                }
            }
            System.out.println();
        }
    }
}
