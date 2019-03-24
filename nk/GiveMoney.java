package Nvk;

/**
 * per1 -> per2 每天100000
 * per2 -> per1 第一天0.01 第二天 0.02  第三天 0.04 …………
 * 以此类推，求30天后两人各交出多少钱
 *
 * 输出要求：富翁交出的钱以万元为单位，陌生人交出的钱以分为单位
 *
 * 思路：递归的调用
 */

/**
 * 对应输出应该为:
 *
 * 300 1073741823
 *
 * 你的输出为:
 *
 * 30000 107
 */
public class GiveMoney {
    public static void main(String[] args) {
        //陌生人交出的钱
        int per2 = exchage1(30);
        System.out.print(per2+" ");
        //富人交出的钱
        int per1 = exchage2(30);
        System.out.println(per1);
    }

    public static int exchage1(int n){
        if(n==1){
            return 10;
        }
        return exchage1(n-1)+10;
    }

    public static int exchage2(int n) {
        int sum = 1;
        int res = 0;
        for(int i=0; i<n; i++){
            res += sum;
            sum = sum*2;
        }
        return res;
    }

}
