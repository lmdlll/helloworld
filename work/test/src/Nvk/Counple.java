package Nvk;

import java.util.Scanner;

/**
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 *
 * 但是牛牛记得老师告诉过他 x和y均不大于n , 并 且x除以y的余数大于等于k 。
 * (x<=n && y<=n) && (x%y>=k)
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 *
 * 输入描述: 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述: 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 *
 * 示例1
 * 输入 5 2
 * 输出 7
 * 说明 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 */
public class Counple {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Long count=0l;
        long n=scanner.nextInt();
        long k=scanner.nextInt();
        /* 暴力解决时间复杂度过高
         * for(int y=k; y<=n; y++){
            for(int x=k; x<=n; x++){
                if(x%y>=k)
                    count++;
            }
        }
        */
        if(k==0){
            //如果k为0，则所有只要小于等于n的都满足
            count=n*n;
        }else{
            //余数要大于k,除数一定是从k+1开始的。
            for(long y=k+1;y<=n;y++){
                //余数是从0到y-1循环的，
                //对于每个y值，x从1到n包含n/y个余数循环,
                //每个余数循环中只有y-k个符合条件的。
                count+=(n/y)*(y-k);
                //剩下一个不完整的余数循环，判断这部分最大的余数是否大于k
                if(n%y>=k)
                    count+=n%y-k+1;
            }


        }
        System.out.println(count);
    }
}
