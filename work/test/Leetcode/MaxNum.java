package Leetcode;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 *
 */
public class MaxNum {
    public static void main(String[] args) {
        System.out.println(largestNumber2(new int[]{3,30,34,5,9}));

    }
    //error 不用看了 理解题目出错T^T,以为要所有数字的组合最大数
    public static String largestNumber(int[] nums) {
        String result = "";
        for(int i=0; i<nums.length; i++){
            result += nums[i];
        }
        Integer[] data = new Integer[result.length()];
        for(int i=0; i<result.length(); i++){
            data[i] = Integer.parseInt(String.valueOf(result.charAt(i)));
        }
        result = "";
        Arrays.sort(data);
        for (int i=data.length-1; i>=0; i--){
            result += data[i];
        }
        return result;
    }

    //14ms
    public static String largestNumber2(int[] nums) {
        String[] data = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            data[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        String result = "";
        for (String i:data){
            result += i ;
        }
        //第一次没有考虑到，如果都是0的情况
        if(result.charAt(0)=='0'){
            return "0";
        }

        return result;
    }

    //太复杂了，好多不知道啥意思
    public static String largestNumber3(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .map(i -> i.toString(i))
                .sorted((s1, s2)->{
                    String sum1 = s1 + s2;
                    String sum2 = s2 + s1;

                    for(int i = 0; i < sum1.length(); i++){
                        if(sum1.charAt(i) != sum2.charAt(i)){
                            return sum2.charAt(i) - sum1.charAt(i);
                        }
                    }
                    return 0;
                })
                .reduce(String::concat)
                .filter(s->!s.startsWith("0"))
                .orElse("0");
    }
}
