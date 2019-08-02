package Leetcode;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    //思路1：先转换，后加减 ,  不做了，发现只有Integer.toBinaryString，没有二进制转十进制
    public static String addBinary1(String a, String b) {
        String result = "";
        int aa = Integer.parseInt(a);
        result = Integer.toBinaryString(aa);
        return result;
    }


    public static String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;  // 进位
        while(i >= 0 || j >= 0) {
            //-‘0’的目的：使之变为一个数字而非字符
            if(i >= 0) c += a.charAt(i --) - '0';
            if(j >= 0) c += b.charAt(j --) - '0';
            stb.append(c % 2);
            c >>= 1;
        }
        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }
}