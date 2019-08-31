package Nvk;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出两个在m进制下含有n位的数字，你可以分别将这两个数各位上的数字重新排列，然后将两个数按位对应相加并分别对m取模，
 * 这样显然可以得到一个新的m进制下的n位数(可能存在前导0)，但是这个结果是不唯一的，
 * 问题来了，按照这样的操作，能够得到的最大的m进制下的数字是多少呢。
 *
 * 输入
 * 输入第一行包含两个正整数n,m分别表示数字含有n位，和在m进制下
 * 输入第二行和第三行分别包含n个整数，中间用空格隔开，每个整数都在0到m-1之间。每行第i个数表示的是当前数第i位上的数字。
 *
 * 输出
 * 输出包含n个数字，中间用空格隔开，表示得到的最大的数字，从高位到低位输出，如6在2进制下输出3位的结果是1 1 0。
 *
 *
 * 样例输入
 * 5 5
 * 4 4 1 1 1
 * 4 3 0 1 2
 * 样例输出
 * 4 4 3 3 2
 *
 * 提示
 * 4 4 1 1 1 →1 4 1 4 1
 * 4 3 0 1 2 →3 0 2 4 1（重排序列不唯一，数位相加后的数字为 4 4 3 8 2，对5取模即可 ）
 */
public class ModNum {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int[] data1 = new int[n];
//            for (int i=0; i<n; i++){
//                data1[i] = in.nextInt();
//            }
//            int[] data2 = new int[n];
//            for (int i=0; i<n; i++){
//                data2[i] = in.nextInt();
//            }
//
//            compute(data1,data2,n,m);
//
//        }

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            String data1 = "";
            for (int i=0; i<n; i++){
                data1 += in.next();
            }
            String data2 = "";
            for (int i=0; i<n; i++){
                data2 += in.next();
            }



        }
        compute2("44110","30241",5,5);

        compute(new int[]{4,4,1,1,0},new int[]{3,0,2,4,1},5,5);

    }

    private static void compute2(String data1, String data2, int n, int m) {
        int[] ndata1 = new int[n];
        int[] ndata2 = new int[n];
        int pos = 0;
        //第一个数
        for (int i=n-1; i>=0; i--){
            //第二个数
            for (int k=n-1; k>=0; k--) {
//                int tmp = data2[k];
//                //首位
//                if (tmp + data1[i] < m && data1[i] != 0 && data2[k] != 0) {
//                    ndata1[pos] = data1[i];
//                    ndata2[pos] = data2[k];
//                    pos++;
//                    break;
//                }

            }
        }

        int tmp=0;

    }


    private static void compute(int[] data1, int[] data2, int n, int m) {
        Arrays.sort(data1);
        Arrays.sort(data2);
        int[] result = new int[n];
        int max = data1[n-1]>data2[n-1]? data1[n-1]: data2[n-1];
        int pos = 0;
        //第一个数
        for (int i=n-1; i>=0; i--){
            //第二个数
            for (int k=n-1; k>=0; k--) {
                //首位
                if ((data2[k] + data1[i])%m >= max) {
                    result[pos] = (data2[k] + data1[i])%m;

                    pos++;
                }

            }
        }
        System.out.println(result);
//        //次位
//        if (tmp + data1[i] < m && pos!=0) {
//            ndata1[pos] = data1[i];
//            ndata2[pos] = data1[k];
//            pos++;
//
//        }
        int tmp=0;


    }
}
