package Nvk;

import java.util.Scanner;

/**
 * 与斐波那契数相减的最小数
 * 1 1 2 3 5 8 13 21 34 55 89 144
 */

public class Feb {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            System.out.println(sub(n));

        }
    }
    public static int sub(int n){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int tmp = feb(i);
            int ab =  Math.abs((tmp-n));
            if(ab<=min){
                min = ab;
            }else {
                return min;
            }

        }
        return 0;
    }
    public static int feb(int n){
        if(n<3){
            return 1;
        }
        return feb(n-1)+feb(n-2);
    }
}
