package Nvk;

import java.util.Scanner;

/**
 * 递归实现二分法算法
 * 下标从1开始
 * 11,13,15,17,19,21
 * 5
 *
 */

public class BinaryNum {
    public static void main(String[] args) {
        int[] data = new int[]{11,13,15,17,19,21};
        System.out.println(findK(data,19,data.length-1));

    }
    public static int findK(int[] data, int k,int pos){
        if((pos<=0 && data[0]!=pos) || pos>data.length-1){
            return -1;
        }
        if(data[pos]==k){
            return pos+1;
        }else if(data[pos]<k){
            return findK(data,k,pos+pos/2);
        }
        return findK(data,k,pos/2);
    }
}
