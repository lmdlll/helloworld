package Nvk;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 大整数排序
 * 对N个长度科大1000的数进行排序
 * 输入：
 * 第一行：n (1<=n<=100)
 * 接下来n行每行有一个数，数的长度范围为1<=len<=1000
 * 输出：对于没组数据，将给出的n个数从小到大进行排序，输出排序后的结果，每个数占一行
 *
 * eg：
 * 输入：
 *  3
 *  11111111111111111111111111111
 *  2222222222222222222222222222222222
 *  33333333
 * 输出：
 *  33333333
 *  11111111111111111111111111111
 *  2222222222222222222222222222222222
 */

/**
 * 总结：第一次写，想着Long够大了吧，结果不够
 * 网上查找发现有BigInteger这个类
 *
 * 大数据处理：
 * 在Java中有两个类BigInteger和BigDecimal分别表示大整数类和大浮点数类，
 * 至于两个类的对象能表示最大范围不清楚，理论上能够表示无线大的数，只要计算机内存足够大。
 * 这两个类都在java.math.*包中，因此每次必须在开头处引用该包。
 *
 *
 * Ⅰ基本函数：
 * 1.valueOf(parament); 将参数转换为制定的类型
 * 2.add(); 大整数相加
 * 3.subtract(); 相减
 * 4.multiply(); 相乘
 * 5.divide(); 相除取整
 * 6.remainder(); 取余
 * 7.pow(); a.pow(b)=a^b
 * 8.gcd(); 最大公约数
 * 9.abs(); 绝对值
 * 10.boolean equals(); 是否相等
 *
 * Ⅱ.基本常量：
 * A=BigInteger.ONE 1
 * B=BigInteger.TEN 10
 * C=BigInteger.ZERO 0
 *
 * Ⅲ.基本操作
 *
 * 1. 读入：
 *
 * 用Scanner类定义对象进行控制台读入,Scanner类在java.util.*包中
 * Scanner in=new Scanner(System.in);
 * while(in.hasNext())  {
 *      BigInteger m;
 *      m=cin.BigInteger();//读入一个BigInteger;
 * }
 *
 *
 * if( a.compareTo(b) == 0 ) System.out.println("a == b"); //大整数a==b
 * else if( a.compareTo(b) > 0 ) System.out.println("a > b"); //大整数a>b
 * else if( a.compareTo(b) < 0 ) System.out.println("a < b"); //大整数a<b
 *
 * //大整数绝对值
 * System.out.println(a.abs()); //大整数a的绝对值
 */
public class BigIntSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
//            Long[] data = new Long[n];
//            for(int i=0; i<n; i++){
//                data[i] = Long.valueOf(in.next());
//            }
            BigInteger[] data = new BigInteger[n];
            for(int i=0; i<n; i++){
                data[i] = in.nextBigInteger();
            }
            Sort(data);
        }
    }

    //失败，因为11111111111111111111111111111 太大
    public static void Sort1(Long[] data){
        Arrays.sort(data);
        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }

    public static void Sort(BigInteger[] data){
        Arrays.sort(data);
        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
    }
}

