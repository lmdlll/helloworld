package Nvk;

import java.util.Scanner;

/** 2048小游戏
 *  表格中的所有数字都是2的次方，求出表格中所有数字左移后的结果
 *
 * eg：
 * 输入：
 * 4
 * 0 0 2 4
 * 0 2 2 2
 * 0 4 2 2
 * 8 8 2 2
 *
 * 输出：
 * 2 4 0 0
 * 4 2 0 0
 * 4 4 0 0
 * 16 4 0 0
 *
 */
//4
//0 0 2 4
//0 2 2 2
//0 4 2 2
//8 8 2 2

public class Game2048 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            int n = in.nextInt();
            int[][] bg = new int[n][n];
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    bg[i][j] = in.nextInt();
                }
            }


            int[][] data = new int[n][n];
            for (int i=0; i<n; i++){
                int k = 0;
                bg[i] = move(bg[i]);
                for (int j=0; j<n; j++){
                    int tmp = j+1<n ? (bg[i][j]+bg[i][j+1]) : bg[i][j];
                    if(tmp==0){
                        break;
                    }
                    if (judge(tmp)) {
                        data[i][k++] = tmp;
                        j++;
                    } else {
                        data[i][k++] = bg[i][j];
                    }

                }
            }

            for (int[] a : data){
                for (int i:a){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
        }


    }

    public static boolean judge(int n){
        if(n==0){
            return true;
        }
        while (n!=1){
            if(n%2==0){
                n /= 2;
            }else {
                return false;
            }
        }
        return true;
    }

    //将0向后移动
    public static int[] move(int[] data){
        int[] ndata = new int[data.length];
        int k=0;
        for (int i=0; i<data.length; i++){
            if(data[i]!=0){
                ndata[k++] = data[i];
            }
        }
        return ndata;
    }

}
