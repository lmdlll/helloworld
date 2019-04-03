package Nvk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * 重排序列
 *
 * 输入：
 * 第一行：数组的大小，操作的次数
 * 第二行：数组
 * 后面是操作，0代表升序，1代表降序
 * 
 */


public class Sorting {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = bf.readLine().split(" ");
        int m = Integer.parseInt(str1[0]);  //数组的大小
        int n = Integer.parseInt(str1[1]);  //操作的次数
        String[] str2 = bf.readLine().split(" ");
        int[] arr = new int[m];
        for (int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(str2[i]);
        }
        int count = 0;  //操作次数
        while (count < n){
            String[] str = bf.readLine().split(" ");
            int x = Integer.parseInt(str[1]);
            int[] tmp = Arrays.copyOfRange(arr,0,x);
            if (str[0].equals("1")){
                //降序
                Arrays.sort(tmp);
                //进行降序排列
                for (int i = 0; i < x; i++){
                    arr[i] = tmp[x-1-i];
                }
            }else {
                Arrays.sort(tmp);
                //进行升序排列
                for (int i = 0; i < x; i++){
                    arr[i] = tmp[i];
                }
            }
            count++;
        }

        for (int i = 0; i < m; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
