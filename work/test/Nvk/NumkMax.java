package Nvk;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 求数组中最大的k个数
 */

public class NumkMax {
    public static ArrayList<Integer> getKMax(int[] data,int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(k>data.length){
            return list;
        }
        Arrays.sort(data);
        for (int i=0; i<k; i++){
            list.add(data[i]);
        }
        return list;
    }



}
