package Nvk;

import java.util.*;
/**
 * 输入n，m，i，j
 * 将m的二进制插入到n的二进制的i到j位，并且保证n的i到j的二进制位为0，返回添加后的数字
 */
public class BinInsert {
    public static void main(String[] args) {
        int k =  binInsert(1024,19,2,6);
        System.out.println(k);

    }
    public static int binInsert(int n, int m, int j, int i) {
        // write code here
        int count = 0;
        int tmp = n;
        while (tmp!=0){
            tmp/=2;
            count++;
        }
        int[] data = new int[count];
        int a=0;
        while (n!=0){
            data[a++] = n%2;
            n/=2;
        }
        int[] res = new int[i-j+1];
        int k=0;
        while (m!=0){
            res[k++] = m%2;
            m /= 2;
        }
        k=0;
        for(int s=j; s<=i; s++){
            data[s] = res[k++];
        }

        int result = 0;
        int key = 1;
        for (int s=0; s<data.length; s++){
            result += (data[s]*key);
            key *= 2;
        }


        return result;
    }
}