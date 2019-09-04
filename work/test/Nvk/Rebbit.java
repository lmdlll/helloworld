package Nvk;

import java.util.Scanner;

/**
 * 养殖场新引进一只高级品种的兔子,这种兔子3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，
 * 第一个月从一只小兔子到N个月后，问兔子总数为多少？
 *
 * 输入
 * 输入数据包含1行
 *
 * 第一行正整数N(N>=30)
 *
 * 输出
 * 输出N个月后兔子总数
 *
 *
 * 样例输入
 * 30
 * 样例输出
 * 832040
 *
 */
public class Rebbit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int month = in.nextInt();
            System.out.println(Count(month));
        }
//        System.out.println(Count(3));
    }
    public static long Count(int n){
        if(n==1 || n==2){
            return 1;
        }
        if(n==0){
            return 0;
        }
        long r1 = 1;
        long r2 = 1;
        long result = 0;
        for (int i=2; i<n; i++){
            result = r1+r2;
            r1 = r2;
            r2 = result;

        }
        return result;
    }
}
