/**
 * 实现一个多项式的类（a+b*x+c*x^2+d*x^3+...+），
 * 要求输入该多项式的系数和x的值后打印出这个多项式的值。
 */

import java.util.*;
public class FX {

    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        //输入的样例的数量
        int k=reader.nextInt();
        StringBuffer result=new StringBuffer();
        while(k>0)
        {
            int n=reader.nextInt();
            int number[]=new int[n+1];
            for(int i=0;i<=n;i++)
            {
                number[i]=reader.nextInt();
            }
            int x=reader.nextInt();
            int sum=0;
            for(int i=0;i<=n;i++)
            {
                sum+=number[i]*Math.pow(x, i);
            }
            System.out.println(sum);
            k--;
        }
    }

}
