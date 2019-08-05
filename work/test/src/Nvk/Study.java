package Nvk;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。
 * 你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，
 * 这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 *
 * 输入描述:
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * 输出描述:
 * 小易这堂课听到的知识点的最大兴趣值。
 *
 * 示例1
 * 输入
 * 6 3
 * 1 3 5 2 5 4
 * 1 1 0 1 0 0
 *
 * 输出
 * 16 = 1+3+5+2+5
 *
 */
public class Study {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] interset = new int[n];
        int[] isAwake = new int[n];
        int[] sumInterestOf0 = new int[n];

        for (int i = 0; i < n; i++) {
            interset[i] = sc.nextInt();
        }
        int sum0 = 0;
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            isAwake[i] = sc.nextInt();
            if (isAwake[i] == 1) {
                sum1 += interset[i];
            } else {
                //未清醒
                sum0 += interset[i];
            }
            //未清醒
            sumInterestOf0[i] = sum0;
        }

        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (isAwake[i] == 0) {
                //(i+k-1)清醒的范围在n-1内
                if ((i+k-1) > (n-1)) {
                    cur = sumInterestOf0[n - 1] - (i - 1 >= 0 ? sumInterestOf0[i - 1] : 0);
                } else {
                    cur = sumInterestOf0[i + k - 1] - (i - 1 >= 0 ? sumInterestOf0[i - 1] : 0);
                }
                max = cur > max ? cur : max;
            }
        }
        System.out.println(sum1 + max);

    }


    //10%通过率,哎，还是把题没看清，我预定的count=3只是他在清醒3分钟的情况下，他的清醒时间不确定啊
    public static void fun1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] imp = new int[n];
        int[] wake = new int[n];
        //知识点
        for(int i=0; i<n; i++){
            imp[i] = in.nextInt();
        }
        //清醒
        for(int i=0; i<n; i++){
            wake[i] = in.nextInt();
        }

        int result = 0;
        int now = 0;
        int max = 0;
        int falg = 0;
        for (int i=0; i<n; i++){
            int count = 0;
            now = 0;
            if(wake[i]==0){
                for(int j=i; j<n; j++){
                    if(count==3) {
                        break;
                    }else {
                        now += imp[j];
                        count++;
                    }
                }
                if(max<now){
                    max = now;
                    falg = i;
                }
            }
        }
        for (int i=0; i<n; i++){
            if (wake[i]==1 && i!=falg && i!=falg+1 && i!=falg+2){
                result += imp[i];
            }
        }
        result += max;
        System.out.println(result);

    }
}
