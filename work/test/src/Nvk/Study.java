package Nvk;

import java.util.Scanner;

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
        Scanner s = new Scanner(System.in);
        int n;
        int k;
        while (s.hasNext()) {
            n = s.nextInt();
            k = s.nextInt();
            int[] a = new int[n];
            int[] t = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            int now = 0;
            for (int i = 0; i < n; i++) {
                t[i] = s.nextInt();
                now += t[i] * a[i];
            }

            int result = now;
            for (int i = 0; i < n; i++) {
                if (t[i] == 0) {
                    now += 1 * a[i];
                }
                if (i >= k) {
                    result = Math.max(result, now);
                    if (i-k<n&&i-k>=0) {
                        if (t[i-k] == 0) {
                            now -= 1 * a[i-k];
                        }
                    }
                }

            }
            System.out.println(result);

        }

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
