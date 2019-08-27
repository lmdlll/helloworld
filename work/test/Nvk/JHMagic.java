package Nvk;

import java.util.Scanner;

/**
 * 有一个魔法阵的形状是由n个阵基组成的正n边形。
 * “真正强大的魔法都是返璞归真的！”一位大魔导师这样说。
 * 魔法学院的同学们开始改进魔法阵，他们从书上了解到，所有魔法阵的形状都是正K边形，K为大于等于三的正整数。
 * 一个魔法阵的威力等于构成魔法阵的阵基威力之和。
 * 因此他们可以通过去掉一些阵基，改变魔法阵使得法阵的威力更大，但是因为他们只是学生，并不能移动阵基。
 * 如现在的魔法阵是正六边形，阵基威力值分别为：1，5，2，-3，3，-3。
 * 显然，我们选择第1，3，5号阵基(1,2,3)构成正三角形法阵的威力变为6是最好的；
 * 我们不能选择1，2，5号阵基，因为这并不是一个正k边形。
 *
 * 现在给出你原来阵基的威力大小，请你求出魔法阵的最大的威力，如果去掉一部分阵基并不能增强法阵威力，也可以保持原样。
 *
 * 输入
 * 输入第一行仅包含一个正整数n，表示原有魔法阵阵基的数量。(3<=n<=20000)
 * 输入第二行包含n个整数，第i个整数表示第i个阵基的威力v_i。(-10000<=v_i<=10000)
 *
 * 输出
 *  输出仅包含一个整数，即魔法阵最大的威力。
 *
 *
 * 样例输入
 * 6
 * 1 5 2 -3 3 -3
 * 样例输出
 * 6
 *
 *
 * 输入样例2
 * 6
 * 1 5 2 3 3 3
 * 输出样例2
 * 17
 */
public class JHMagic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] data = new int[n];
            int sum = 0;
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
                sum += data[i];
            }
            if(n%2!=0 || n==4 ||n==3){
                System.out.println(sum);
                return;
            }
            int sum1 = 0;
            int sum2  =0;
            for (int i=0; i<n; i++){
                if(i%2==0){
                    sum1 += data[i];
                }else {
                    sum2 += data[i];
                }
            }
            System.out.println(Math.max(sum,Math.max(sum1,sum2)));

        }


    }


}
