package Nvk;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小非零元素
 * 重复操作k轮：
 * 1.发现最小的非零元素x
 * 2.打印x
 * 3.将序列中所以非零元素减x
 *
 * 输入：
 * n k  (1<=n, k<=10^5)
 * n个正整数ai
 * 输出：
 * 输出k行，即每轮中最小的非零整数（如果到某轮所有元素都为0，打印0即可
 *
 * 输入：
 * 7 5
 * 5 8 10 3 6 10 8
 * 输出：
 * 3
 * 2
 * 1
 * 2
 * 2
 *
 *
 */
public class MinNotZero {
    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
            }


            for (int i=0; i<k; i++){
                Arrays.sort(data);
                if(data[0]==0 && data[n-1]==0){
                    System.out.println(0);
                }else {
                    int key = 0;
                    int min = data[key];
                    while (data[key] == 0) {
                        key++;
                    }
                    min = data[key];
                    System.out.println(min);
                    for (int j = 0; j < n; j++) {
                        if (data[j] != 0) {
                            data[j] = data[j] - min;
                        }
                    }
                }
            }


        }


    }
}
