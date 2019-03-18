package Nvk;

/**
 * 一个X*Y的网格，一个机器人只能走格点且只能向右走或向下走，要从左上角走到右下角，请设计一个算法，计算机器人有多少走法
 * 输入：给定2个正整数x,y ，请返回机器人的走法数目，保证x+y小于12
 */
public class Rebort {
    public static void main(String[] args) {
        System.out.println(countWays(3,3));
    }

    //思路：机器人只能向下向右，向下：求x-1,y矩阵中机器人走法  向右： 求x，y-1矩阵中机器人走法
    public static int countWays(int x,int y){
        if(x==1 || y==1){
            return 1;
        }
        return countWays(x-1,y)+countWays(x,y-1);
    }

}
