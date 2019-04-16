package Nvk;

import java.util.Scanner;

/**
 * 汽水瓶
 * 规定：3个空汽水瓶换1个汽水
 * 现在有10个空汽水瓶，最多可换多少汽水喝？ --5瓶
 * 9 --> 3   4
 * 3 --> 1   2
 * 借1个 3--> 1  1  还1个
 *
 * 输入：拥有n个空瓶
 * 输出：可喝多少瓶
 *
 */

public class Bottle {
    public static void main(String[] args) {
//        System.out.println(Count(81));
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            System.out.println(Count(n));
        }
    }
    //思路：递归
    public static int Count(int n){
        int could = n/3;
        int sy = n%3;
        if(could==0){
            if(sy==2){
                return 1;
            }else {
                return 0;
            }
        }
        return Count(could+sy)+could;
    }
}
