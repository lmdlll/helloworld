package Nvk;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * 找x
 * 输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标（0开始，不在则输出-1）
 *
 * eg：
 * 输入：
 *  2
 *  1 3
 *  0
 * 输出：
 * -1
 *
 *
 */

public class Findx {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            int[] data = new int[n];
            for(int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            int target = in.nextInt();
            System.out.println(search(data,target));
        }

    }
    public static int search(int[] data, int target){
        int result = -1;
        for(int i=0; i<data.length; i++){
            if(data[i]==target){
                result = i;
            }
        }
        return result;
    }
}
