package Nvk;

import java.util.Scanner;

/**
 * 10
 * 53941 38641 31525 75864 29026 12199 83522 58200 64784 80987
 *
 * 12199 29026 31525 38641 53941 58200 64784 75864 80987 83522
 *
 *
 * 29026 31525 12199 83522 58200 53941 64784 80987 75864 38641
 *   38641
 *
 */
public class change {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++) {
                    if (i!=j && (data[i]+data[j])%2!=0){
                        data = exc(data,i,j);
                    }
                }
            }

            for (int i :data){
                System.out.print(i+" ");
            }
        }

    }

    public static int[] exc(int[] data,int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        return data;
    }
}
