package Nvk;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * 数字和为sum的方法数
 * 给定一个有n个正整数的数组A和一个整数sum，求选择数组A中部分数字和为sum的方案数
 * 当两者选取放啊有一个数字下标不一样，就任务是不同的组成方案
 * 输入：
 * 第一行两个正整数 n(1<=n<=1000),sum(1<=sum<=1000)
 * 第二行n个正整数A[i]
 *
 * eg：
 * 输入：5 15  5 5 10 2 3
 * 输出：4
 */

public class addSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] data = new int[n];
            for(int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            System.out.println(bag(data,m));
        }
    }

    //没思路，别人的代码，机智啊，
    public static long bag(int []data,int sum){
        long dp[]=new long[sum+1];
        dp[0]=1;
        int i,j;
        for(i=0;i<data.length;i++){
            for(j=sum;j>=data[i];j--){
                dp[j]=dp[j-data[i]]+dp[j];
            }
        }
        return dp[sum];
    }

}
