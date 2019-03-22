package Nvk;

/**
 * 一个3*3的棋盘，机器走的为-1，玩家走的为1,0表示位置为空
 * 写一个算法，计算人是否赢得比赛
 */
public class board {
    public static void main(String[] args) {
        int[][] data = new int[][]{{1,0,-1},{0 ,1,-1},{1,-1,1}};
        System.out.println(checkWon(data));

    }

    //答案感觉不太靠谱。。。eg：{1,0,-1},{1 ,1,-1},{1,-1,0} --> 失败
    public static boolean checkWon(int[][] board) {
        //定义一个arr[] = {机器},{空},{玩家}
        //使用双重遍历，遇到机器，在arr[机器]++  空与玩家同
        //最后比较
        int[] arr = new int[3];
        //计算机出的
        int i0 = 0;
        //玩家出
        int i2 = 2;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                arr[board[i][j]+1]++;
            }
        }
        return arr[i2]>arr[i0]?true:false;
    }

}
