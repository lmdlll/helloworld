package Nvk;

import java.util.Scanner;

/**
 * 2
 * 1 1
 * 2 2
 *
 * 3
 *
 * 3
 * 1 3
 * 1 1
 * 4 1
 *
 * 6
 *
 */


public class Tea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
//            int[][] data = new int[n][2];
//            for (int i=0; i<n; i++){
//                data[i][0] = in.nextInt();
//                data[i][1] = in.nextInt();
//            }

            int[] ai = new int[n];
            int[] bi = new int[n];

            int[][] ij = new int[n+1][n+1];
            for(int i=0; i<k+1; i++){
                for(int j=0; j<k+1; j++){
                    ij[i][j] = -1;
                }
            }


            int min = -1;
            int flag = 0;
            for(int i=1; i<k+1; i++){
                for(int j=1; j<k+1; j++){
                    int count = ai[i]*(j-1) + bi[i]*(k-j);
                    if(min == -1){
                        min = count;
                        flag = j;
                    }else {
                        if(count<min){

                        }
                    }

                }
            }


        }


    }

    public static void fun(int[][] data,int n){
        int[][] arr = new int[n][n];
        for (int i=0; i<n; i++){
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j=0; j<n; j++){
                int tmp = j*data[i][0]+(n-1-j)*data[i][1];


            }

        }

    }

}
