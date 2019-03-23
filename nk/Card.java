package Nvk;

import java.util.Scanner;

/**
 * 洗牌，共2n张牌，分两部分：1~n n+1~2n
 * eg：1 2 3 4 5 6    左：1 2 3  右：4 5 6
 * 洗一次：1 4 2 5 3 6
 * 输入格式：T n k 2n个数……
 * （T：数据组数，对于每组数据，第一行两个数n，k）
 * 3   3 1 1 2 3 4 5 6  3 2 1 2 3 4 5 6  2 2 1 1 1 1
 * 1 4 2 5 3 6  1 5 4 3 2 6  1 1 1 1
 */

public class Card {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            int T = in.nextInt();
            while (T>0){
                int n = in.nextInt();
                int k = in.nextInt();
                int[] data = new int[2*n];
                for(int i=0; i<2*n; i++){
                    data[i] = in.nextInt();
                }
                data = print(n,k,data);
                if(T==1){
                    for(int i=0; i<data.length; i++){
                        if(i==data.length-1){
                            System.out.print(data[i]);
                        }else {
                            System.out.print(data[i] + " ");
                        }
                    }

                }else {
                    for (int i = 0; i < data.length; i++) {
                        System.out.print(data[i] + " ");
                    }
                }
                T--;
            }

        }

    }

    public static int[] print(int n, int k, int[] data){
        while (k>0){
            int[] tmp1 = new int[n];
            for(int i=0; i<n; i++){
                tmp1[i] = data[i];
            }
            int[] tmp2 = new int[n];
            int tr = n;
            for(int i=0; i<n; i++){
                tmp2[i] = data[tr++];
            }
            int[] res = new int[2*n];
            int t1 = n-1;
            int t2 = n-1;
            for(int i=2*n-1; i>=0; i--){
                if(i%2==0){
                    res[i] = tmp1[t1--];
                }else {
                    res[i] = tmp2[t2--];
                }
            }
            data = res;
            k--;
        }
        return data;
    }


}
