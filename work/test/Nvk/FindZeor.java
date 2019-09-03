package Nvk;

import test1.lmd.Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定一个整数的数组，找出其中的pair(a, b)，使得a+b=0，并返回这样的pair数目。（a,  b）和(b,  a)是同一组。
 *
 * 输入
 *  整数数组
 *
 * 输出
 * 找到的pair数目
 *
 *
 * 样例输入
 * -1,  2,   4,  5,  -2
 * 样例输出
 * 1
 */
public class FindZeor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            str = str.replace(" ","");
            String[] data = str.split(",");
            int[] num = new int[data.length];
            for (int i=0; i<data.length; i++){
                num[i] = Integer.parseInt(data[i]);
            }

            //先排序
            Arrays.sort(num);
            int start = 0;
            int end = num.length-1;
            int count = 0;
            while (start<end){
                if(num[start]+num[end]==0){
                    count++;
                    if (start<end) {
                        start++;
                    }
                    if(start<end) {
                        end--;
                    }
                }else if (num[start]+num[end]>0){
                    end--;
                }else {
                    start++;
                }
            }
            System.out.println(count);

        }

    }
}
