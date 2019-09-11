package Nvk;

import java.util.Scanner;

/**
 * 求数字
 * 我们都算过从1加到100的总和为5050，现要求编写一个程序：
 * 100以内数字相加（即1+2+3.....+100），求解出最后一个加到总和为n的数字是哪个。
 *
 * 输入
 * 测试用例可能有多组，每组一行数据，为数字n
 * 输出
 * 对于每组数字，输出一行，要求输出最后一个加到总和为n的数字，如果不存在，则输出No。
 *
 *
 * 样例输入
 * 1035
 * 1111
 * 样例输出
 * 45
 * No
 */
public class FindNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            System.out.println(compute(num));

        }

    }


    public static String compute(int n){
        int res = 0;
        for (int i=1; i<=100; i++){
            res += i;
            if(res==n){
                return String.valueOf(i);
            }else if(res>n){
                return "No";
            }
        }
        return null;
    }

}
