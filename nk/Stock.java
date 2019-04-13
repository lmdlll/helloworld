package Nvk;


/**
 * 风口的猪-中国牛市
 *
 * 已知一只股票连续n天价格走势，以长度n的整数数组表示，数组中dii个元素代表第i天的股价。
 * 假设一开始无股票，DNA有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
 * 若两次校验机会都放弃，收益为0，设计算法计算获得的最大收益，输入值范围：2<=n<=100 0<=prices[i]<=100
 *
 * 输入：3,8,5,1,7,8
 * 输出：12  (-3+8-1+8)
 */

public class Stock {
    //思路：分为两个数组，分别计算其中最大的差值
    public static int getmax(int[] prices, int start, int end) {
        int max = 0;
        int min = prices[start];
        for (int i = start + 1; i <= end; i++) {
            if (prices[i] - min > max)
                max = prices[i] - min;
            if (prices[i] < min)
                min = prices[i];
        }
        return max;
    }


    public static int calculateMax(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = getmax(prices, 0, i) + getmax(prices, i, prices.length - 1);
            if (temp > sum)
                sum = temp;
        }
        return sum;
    }
}