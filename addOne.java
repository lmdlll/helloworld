package Array;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 */

public class addOne {
    public static void main(String[] args) {
        int[] data = new int[]{9, 9, 9};
        int[] tmp = plusOnei(data);
        for (int i : tmp) {
            System.out.print(i + " ");
        }

    }

    //理解错误。。。
    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return new int[]{1};
        }
        int end = digits.length - 1;
        int tmp[] = new int[digits.length + 1];
        if (digits[end] + 1 < 10) {
            digits[end] += 1;
        } else {
            for (int i = 0; i < end; i++) {
                tmp[i] = digits[i];
            }
            tmp[end] = 0;
            tmp[end + 1] = 1;
            return tmp;
        }
        return digits;
    }

    public static int[] plusOnei(int[] digits) {
        if (digits == null) {
            return new int[]{1};
        }
        int len = digits.length - 1;
        if ((digits[len] + 1) < 10) {
            digits[len] = digits[len] + 1;
            return digits;
        }

//        int flag = 1;
//        int[] res = new int[digits.length+1];
//        for (int i = len; i >= 0; i--) {
//            if (digits[i]+flag >= 10) {
//                digits[i] = (digits[i] + flag) % 10;
//                flag = 1;
//            }else {
//                digits[i] = digits[i]+1;
//                flag = 0;
//            }
//        }

        return digits;
    }
}