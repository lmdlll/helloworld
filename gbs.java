package Nvk;

import java.util.Scanner;

//求最小公倍数
public class gbs {
    public static void code1() {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b= 0;
        if(in.hasNextLine()){
            a = in.nextInt();
            b = in.nextInt();
        }
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a % b == 0) {
            System.out.println(a);
            return;
        }
        for (int i = a + 1; i <= a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(a * b);
    }
    public static void code2(){
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b= 0;
        if(in.hasNextLine()){
            a = in.nextInt();
            b = in.nextInt();
        }

        for(int i=1; ;i++){
            if((i*a)%b==0){
                System.out.println(i*a);
                return;
            }

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(gcb(a,b));
    }
/**
 * 求最小公倍数：公式法
 * 两个数a，b的最小公倍数是a*b/gcb(a,b)
 * 由于两个数的乘积等于这两个数的最大公约数与最小公倍数的积，即（a,b）*[a,b]=a*b
 * 所以，求两个数的最小公倍数，就可以先求出他们的最大公倍数，然后用上述公式求出他们的最小公倍数
 */

    /**
     * 辗转相除法
     *   1.  a/b ，令r为所得余数(0<=r<b) 若r==0，算法结束，a即答案
     *   2.  互换：置a+b ，b+r ，并返回第一步
     *   …………我还是用最蠢的方法吧T^T
     *
     */
    public static int gcb(int a, int b){
        if(b==0)return a;
        return gcb(b,(a%b));
    }
}
