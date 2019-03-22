package Nvk;

/**
 * 要求：A[]={A[0],A[1],A[2]....A[n-1]}
 * B[i]=A[0]*A[1]*A[1]*...*A[i-1]*A[1+1]*...A[n-1]
 */

public class Arrayab {
    public static void main(String[] args) {
        int[] data = new int[]{1, 0, 3, 4};
        int[] res = multiply(data);
        for (int i : res) {
            System.out.println(i + " ");
        }

    }

    //不使用除法
    public static int[] multiply(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int tmp = 1;
            for (int j = 0; j < A.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    tmp *= A[j];
                }
            }
            result[i] = tmp;
        }

        return result;
    }

    //使用除法，但是当其中有0时，会造成错误，因此不推荐使用
    public static int[] multiplyi(int[] A) {
        int[] result = new int[A.length];
        int mul = 1;
        for(int i=0; i<A.length; i++){
            mul *= A[i];
        }
        for (int i=0; i<A.length; i++){
            for(int j=0; j<A.length; j++){
                if(j==i){
                    result[i] = mul/A[i];
                }
            }
        }
        return result;
    }
}
