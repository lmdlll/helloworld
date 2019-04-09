package Nvk;

import java.util.Scanner;

/** 霍格沃兹找零钱
 * 17银西可兑一个加隆
 * 29个纳特兑一个银西可
 * 给定应付的价钱P和实付的前A，计算应被找的零钱
 * 输入：加隆.银西可.纳特    加隆：[0,10^7] 银西可：[0,17) 纳特：[0,29)
 * 输出：加隆.银西可.纳特  如果钱没有带够，输出应该是负数
 * eg:
 * 输入：  10.16.27  14.1.28
 * 输出：  3.2.1
 */
public class HPFindMoney {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            String should = in.next();
            String pay = in.next();
            find(should,pay);
        }

    }
    //思路：先全部变为纳特，然后变为格式化
    public static void find(String should, String pay){
        String[] sh = should.split("\\.");
        String[] pa = pay.split("\\.");
        int shall = Integer.valueOf(sh[2])+Integer.valueOf(sh[1])*29+Integer.valueOf(sh[0])*29*17;
        int paall = Integer.valueOf(pa[2])+Integer.valueOf(pa[1])*29+Integer.valueOf(pa[0])*29*17;
        int result = paall-shall;
        int flag = 1;
        if(result<0){
            flag = -1;
            System.out.print("-");
            result *= flag;
        }
        int[] data = new int[3];
        data[0] = result/(29*17);
        data[1] = (result%(29*17))/29;
        data[2] = (result%(29*17)%29);
        System.out.println(data[0]+"."+data[1]+"."+data[2]);
    }


    private static final int[] W = {17*29,29,1};
    public static void m(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] p = in.next().split("\\.");
        String[] a = in.next().split("\\.");
        int[] P = {Integer.parseInt(p[0]),Integer.parseInt(p[1]),Integer.parseInt(p[2])};
        int[] A = {Integer.parseInt(a[0]),Integer.parseInt(a[1]),Integer.parseInt(a[2])};
        int ta = A[0]*W[0]+A[1]*W[1]+A[2]*W[2];
        int tp = P[0]*W[0]+P[1]*W[1]+P[2]*W[2];
        int t = ta-tp;
        if(ta<tp){
            System.out.print("-");
            t = -t;
        }
        System.out.println(t/W[0]+"."+t%W[0]/W[1]+"."+t%W[0]%W[1]/W[2]);
    }

}
