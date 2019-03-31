package Array;
//最多且最大
//1，2，5，6，3，6，6，7，9，9，9

import java.util.Arrays;

//出现最多且最大的数字
public class MoreBig {
    public static void main(String[] args) {
        System.out.println(more(new int[]{1,2,5,6,3,6,6,7,9,9,9}));
    }


    public static int more(int[] data){
        Arrays.sort(data);
        int max = data[data.length-1];
        int count = 0;
        int[] res = new int[max+1];
        for(int i=0; i<data.length; i++){
            res[data[i]]++;
        }
        for(int i=res.length-1; i>=0; i--){
            if(count<res[i]){
                count = res[i];
                max = i;
            }
        }
        return max;
    }
}
