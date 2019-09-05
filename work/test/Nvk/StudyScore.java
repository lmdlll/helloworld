package Nvk;



import java.util.*;

/**
 * 5
 * 7 2 4 6 5
 *
 * 60
 */

public class StudyScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            long[] data = new long[n];
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
            }

            System.out.println(maxArray(data,n));
        }

    }

    public static long maxArray(long[] data, int n){
        if(n==1){
            return data[0]*data[0];
        }
        ArrayList<Long> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            long min = data[i];
            int sum = 0;
            for(int j=i; j<n; j++){
                if(min>data[j]){
                    min = data[j];
                }
                sum += data[j];
                list.add((sum*min));
            }
        }
        long result = Collections.max(list);
        return result;
    }

    public static int maxArray2(int[] data){
        if(data.length==1){
            return data[0]*data[0];
        }
        int now = data[0];
        int max = data[0];
        for (int i=1; i<data.length; i++){
            now += data[i];

            if(now<max){

            }

        }

        return -1;
    }

    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int now = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            now += nums[i];
            //判断，当加起来的集合都比当前数字小的时候，前面的就没有必要了
            if(now<nums[i]){
                now = nums[i];
            }
            if(max<now){
                max = now;
            }
        }
        return max;
    }
}
