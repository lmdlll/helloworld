package Array;

/**
 * 给定两个有序数组，求两个数组的中位数
 * eg:
 * num1={1,3} num2={2} ---> 2
 * num1={1,2} num2={3,4} ---> 2.5
 *
 * 1,2,3,4,5   3,4,5,6,7    ---> 4
 * 1,2,3,4,5   2,3 --->3
 */
public class FindMid {
    public static void main(String[] args) {
        findMedain(new int[]{1,2,3,4}, new int[]{3,4,5,6});

    }

    public static double findMedain(int[] num1, int[] num2){
        int mid = 0;
        int[] data = new int[num1.length+num2.length];
        int j=0;
        int k=0;
        for(int i=0; i<data.length; i++) {
            if (num1[i] <= num2[k]) {
                data[i] = num1[j];
                j++;
            } else {
                data[i] = num2[k];
                k++;
            }
        }


        return 0.0;
    }
}
