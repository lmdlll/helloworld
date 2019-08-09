package Leetcode;

import java.util.Stack;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] data = new int[]{9,9};
        data = plusOne(data);
        for (int i:data) {
            System.out.println(i);
        }
    }

    //思路：为了避免999+1不断进位，首先将数组转为String，然后转为int+1，最后返回一个新的数组
    //error：如果测试数字过大，则会出现NumberFormatException数字格式异常
    public static int[] plusOne1(int[] digits) {
        String tmp = "";
        for(int i=0; i<digits.length; i++){
            tmp += digits[i];
        }
        //错在这一步上
        int res = Integer.parseInt(tmp)+1;
        tmp = String.valueOf(res);
        int[] data = new int[tmp.length()];
        for(int i=0 ;i<tmp.length(); i++){
            String ls = String.valueOf(tmp.charAt(i));
            data[i] = Integer.parseInt(ls);
        }
        return data;
    }

    //1ms  思路：只要是9，则进位
    public static int[] plusOne(int[] digits) {
        digits[digits.length -1] += 1;
        for (int i = digits.length-1; i >= 0; i--) {
            //如果小于10则直接返回
            if (digits[i] < 10) {
                return digits;
            } else {
                //这里我本来写的是digits[i]%=10，然后发现只是9+1=10，没有十几的其他可能性，索性直接让其=0
                digits[i] = 0;
                if (i != 0) {
                    digits[i-1] += 1;
                }

            }
        }
        //走到这一步，第一位肯定要进位，则数组扩容
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        System.arraycopy(digits, 0,res, 1, digits.length);
        return res;
    }


    //0ms 哦~，厉害啊
    public int[] plusOne2(int[] digits) {
        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i]==9) {
                digits[i] = 0;
            }else {
                digits[i] = digits[i]+1;
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

}
