package Nvk;

import java.util.Scanner;

/**
 * 对于给定的正整数n。
 * 计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和
 *
 * 输入：每行输入数据包括一个正整数n （0<n<40000）
 * 输出：计算数字之和，以及其平方值的数字之和
 *
 * 输入：
 *  4
 *  12
 *  97
 *  39999
 * 输出：
 *  4 7
 *  3 9
 *  16 22
 *  39 36
 */


public class Sqrtn {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            Compute(n);
        }
    }
    public static void Compute(int n){
        System.out.print(add(n)+" ");
        //计算平方和
        System.out.println(add(n*n));

    }
    public static int add(int n){
        int sum1 = 0;
        //计算十位数字之和
        int count = 0;
        int m = n;
        while (m != 0){
            m /= 10;
            count++;
        }
        for(int i=0; i<count; i++){
            sum1 += n%10;
            n /= 10;
        }
        return sum1;
    }
}
