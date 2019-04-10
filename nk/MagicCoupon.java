package Nvk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 每张优惠券上都印有一个整数N，这意味着当你把这张优惠券和一件产品一起使用时，你可以得到该产品价值的N倍！
 * 此外，商店还免费提供一些额外的产品。然而，如果你将一张正面为“否”的优惠券应用于该奖励产品，你将支付给商店该奖励产品价值的“否”倍...
 * 但是,他们有一些N为负数的优惠券！例如，一组优惠券{1 2 4 -1}，一组产品值{7 6 -2 -3}，其中负值对应于奖励产品。
 * 可将优惠券3(N为4)应用于产品1(价值为7百万美元)，获得28百万美元的退款；产品2的优惠券2，可获得12元的退款；以及产品4的优惠券4，以取回m3。
 * 另一方面，如果你将优惠券3应用于产品4，你将不得不向商店支付12元。每张优惠券和每种产品最多只能选择一次。你的任务是收回尽可能多的钱。
 *
 *
 * 输入：第一行优惠券数，后面是一行数控优惠券整数。
 *     下一行产品数NP，接着是一行包含产品值NP。  这里1<=数控，NP <= 105，并且保证所有数字不会超过230。
 *
 * 输出：对于每一个测试用例，只需在一行中打印出你能收回的最大金额。
 *
 * eg：
 * 输入
 *  4
 *  1 2 4 -1
 *  4
 *  7 6 -2 -3
 *  输出
 *  43
 *
 */

public class MagicCoupon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            long[] yh = new long[n];
            for(int i=0; i<n; i++){
                yh[i] = in.nextLong();
            }
            int m =  in.nextInt();
            long[] cp = new long[m];
            for(int i=0; i<m; i++){
                cp[i] = in.nextLong();
            }

            Compute(yh,cp);
        }


//        Scanner in=new Scanner(System.in);
//        int az,bz;
//        int m=in.nextInt();
//        long a[]=new long[m];
//        for(int i=0;i<m;i++){
//            a[i]=in.nextLong();
//        }
//        int n=in.nextInt();
//        long b[]=new long[n];
//        for(int i=0;i<n;i++){
//            b[i]=in.nextLong();
//        }
//
//        Arrays.sort(a);
//        Arrays.sort(b);
//        for(int i=0;;i++){
//            if(a[i]>0){
//                az=i;break;
//            }
//        }
//        for(int i=0;;i++){
//            if(b[i]>0){
//                bz=i;break;
//            }
//        }
//        long sum=0;
//        for(int i=0;i<az&&i<bz;i++){
//            sum+=a[i]*b[i];
//        }
//        for(int i=m-1,j=n-1;i>=az&&j>=bz;i--,j--){
//            sum+=a[i]*b[j];
//        }
//        System.out.println(sum);


    }

//测试数字过大
    public static void Compute(long[] yh, long[] cp){
        Arrays.sort(yh);
        Arrays.sort(cp);
        long result = 0;
        int ai = 0, bi = 0;
        for(int i=0; i<yh.length; i++){
            if(yh[i]>0){
                ai = i;
                break;
            }
        }
        for(int i=0; i<cp.length; i++){
            if(cp[i]>0){
                bi = i;
                break;
            }
        }
        //负负得正
        for(int i=0;i<ai&&i<bi;i++){
            result+=yh[i]*cp[i];
        }
        //正正最大
        for(int i=yh.length-1,j=cp.length-1; i>=ai&&j>=bi; i--,j--) {
            result += yh[i] * cp[j];
        }
        System.out.println(result);
    }
}
