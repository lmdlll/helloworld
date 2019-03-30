package Nvk;

import java.util.Scanner;

/**
 * 给定数字0-9若干，任意排列数字，必须全部使用，目标：最后得到的数尽可能小
 * 输入：10个测试用例，10个数字的总和不超过50，且至少拥有1个非0的数字
 */

//TODO:
public class MinNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] data = new int[10];
        int i=0;
        while (i<10) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            data[i++] = in.nextInt();
        }
        Find(data);
    }

    public static void Find(int[] data){
        int[] arr = new int[10];
        for(int i=0; i<data.length; i++){
            int tmp = data[i];
            arr[tmp]++;
        }

        for(int i=1; i<arr.length; i++){
            while(arr[i]!=0){
                System.out.print(i);
                while (arr[0]!=0){
                    System.out.print(0);
                    arr[0]--;
                }
                arr[i]--;
            }

        }

    }

}
