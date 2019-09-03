package Nvk;

import java.util.Scanner;

/**
 * 输入一个大于0的整数，求其二进制表示中1的个数。例如，输入3，它的二进制表示为11，其中1的个数为2，输出2。
 *
 * 输入
 * 输入一个大于0的整数
 *
 * 输出
 * 二进制中1的个数
 *
 *
 * 样例输入
 * 3
 * 样例输出
 * 2
 */
public class BinaryOneNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int result = 0;
            String str = Integer.toBinaryString(n);
            for (int i=0; i<str.length(); i++){
                if(str.charAt(i)=='1'){
                    result++;
                }
            }
            System.out.println(result);



//            while (n!=0){
//                n = (n-1)&n;
//                result++;
//            }
//            System.out.println(result);



        }

    }
}
