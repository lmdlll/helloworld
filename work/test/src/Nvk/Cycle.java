package Nvk;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 网易判断是否成环
 * 输入：
 * 输入测试用例
 * 输入
 * 1
 * 5
 * 17 6 17 11 17
 *
 *
 *
 * 判断成环那题：将数组排序然后首尾相接后，只有最大的那个数有可能出问题，因为对于其他每个数来说右边的数都大于等于它，
 * 而且题目说数都是大于0的，那么它一定小于左边+右边。对于最大的数，可以考虑将它和第二大的数换位置，
 * 如果符合条件的话就一定能成环，否则就不能。
 *
 */
public class Cycle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for (int i=0; i<t; i++){
                int n = in.nextInt();
                int[] data = new int[n];
                for (int j=0; j<n; j++){
                    data[j] = in.nextInt();
                }
                //判断
                //直接实验1 3 5 7 ，我理解题意有误，哭泣
                judge(data);
                judge2(data);

            }

    }
    public static void judge2(int[] data) {
        Arrays.sort(data);
        //交换第一大和第二大
        int tmp = data[data.length-1];
        data[data.length-1] = data[data.length-2];
        data[data.length-2] = tmp;
        if(data[data.length-1]<data[0]+data[data.length-2]){
            System.out.println("YES");
            return;
        }
        System.out.println("NO");

    }

        public static void judge(int[] data){
        for(int i=0; i<data.length; i++){
            int tmp = data[i];
            int j=0;
            if(i==0){
                j = data[i+1]+data[data.length-1];
            }else if(i==data.length-1){
                j = data[0]+data[i-1];
            }else {
                j = data[i+1]+data[i-1];
            }
            if(tmp>j){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
