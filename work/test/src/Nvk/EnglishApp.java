package Nvk;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 3
 * 100 98 87
 *
 * 3
 * 1
 * 2
 * 3
 *
 *
 * 66.666667
 * 33.333333
 * 0.000000
 *
 * 保留6位小数
 */

public class EnglishApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            //班级人数
            int n = in.nextInt();
            //成绩
            int[] sco = new int[n];
            for (int i=0; i<n; i++){
                sco[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] ques = new int[m];
            for (int i=0; i<m; i++){
                ques[i] = in.nextInt();
            }

            //
            float[] result = new float[n];
            for (int i=0; i<n; i++){
                int count = 0;
                int num = sco[i];
                for(int j=0; j<n; j++) {
                    if (sco[j]<=num){
                        count++;
                    }
                }
                result[i] = (float) ((count-1)*(100.0)/n);
            }

            for(int i=0; i<m; i++){
                System.out.println(new DecimalFormat("#0.000000").format(result[ques[i]-1]));
            }

        }

    }
}
