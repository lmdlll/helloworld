package Nvk;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 6
 * 5 3 8 3 2 5
 *
 * 3 3 5 4 4 4
 */

public class Lou {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            compute(data);

        }

    }

    private static void compute(int[] data) {
        int[] res = new int[data.length];
        int[] tmp = data;
        Arrays.sort(tmp);
        int max = tmp[data.length-1];
        int pos = 0;
        for (int i=0; i<data.length; i++){
            if(data[i]==max){
                pos = i;
                break;
            }
        }
        int count = 0;
        for (int i=0; i<data.length; i++){
            int flag = data[i];
            for (int j=0; j<data.length; j++) {
                if(j!=0 && data[j]>data[j+1]){

                }
                if(data[j]<=flag){
                    count++;
                }
                if(j>pos && data[j]==max){
                    count++;
                }


            }

        }

    }
}
