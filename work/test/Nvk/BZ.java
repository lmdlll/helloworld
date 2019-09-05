package Nvk;

import java.util.Scanner;

public class BZ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] key = new int[m];
            for (int i=0; i<m; i++){
                key[i] = in.nextInt();
            }
            int[] box = new int[n];
            for (int i=0; i<n; i++){
                box[i] = in.nextInt();
            }
            int result = 0;
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    if((box[i]+key[j])%2==1){
                        result++;
                        key[j] = Integer.MIN_VALUE;
                        break;
                    }
                }
            }
            System.out.println(result);

        }




    }
}
