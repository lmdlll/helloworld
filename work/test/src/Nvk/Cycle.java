package Nvk;

import java.util.Scanner;

/**
 * 1
 * 5
 * 17 6 17 11 17
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
                judge(data);
            }

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
