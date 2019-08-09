package Nvk;

import java.util.Scanner;

/** 两；个数相加为奇数，则交换，可以交换无数次，要求字典序最小
 * 问题：字典序是啥
 *
 * 输入：
 * 10
 * 53941 38641 31525 75864 29026 12199 83522 58200 64784 80987
 * 输出：
 * 12199 29026 31525 38641 53941 58200 64784 75864 80987 83522
 *
 * 相加是奇数可以交换，找最小字典序那题：如果全是偶数或全是奇数的话，就直接原样输出，因为没法交换。
 * 如果至少有一个奇数或者至少有一个偶数的话，那么就可以任意交换了（举个例子，只有一个奇数其他全是偶数，
 * 想交换两个偶数只需要这两个偶数和奇数交换三次就可以了）
 * 因为不限制操作次数所以一定可以找到字典序最小的排列，所以sort一下就好了
 *
 */
public class change {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++) {
                    if (i!=j && (data[i]+data[j])%2!=0){
                        data = exc(data,i,j);
                    }
                }
            }

            for (int i :data){
                System.out.print(i+" ");
            }
        }

    }

    public static int[] exc(int[] data,int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        return data;
    }
}
