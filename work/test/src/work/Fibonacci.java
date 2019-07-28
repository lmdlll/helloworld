package work;

import java.util.Vector;

public class Fibonacci {
    public static void main(String[] args) {
        int[] arr = new int[]{6,-3,-2,7,-15,1,2,2};
//        System.out.println(Maximum(arr));
        System.out.println(Feb2(8));

    }
    //斐波那契数列
    //递归 736ms
    public static int Feb(int n){
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        return Feb(n-1)+Feb(n-2);
    }

    //循环  19ms
    public static int Feb2(int n){
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int f1=1;
        int f2=1;
        int result = 0;
        for(int i=2; i<n; i++){
            result = f1+f2;
            f1=f2;
            f2=result;
        }
        return result;
    }


}
