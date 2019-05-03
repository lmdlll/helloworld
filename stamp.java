/** 邮票
有8角邮票5张，1元的邮票4张，1.8元的邮票6张，
用这些邮票中的一张或若干张可以得到多少中不同的邮资？

*/
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
		//8角
         int[] a = {0,8,16,24,32,40}; 
		 //10角
         int[] b = {0,10,20,30,40};
		 //18角
         int[] c = {0,18,36,54,72,90,108};
         HashSet set = new HashSet();
         for(int i = 0;i < a.length; i++)
         {
             for(int j = 0; j < b.length; j++)
             {
                 for(int k = 0; k < c.length; k++)
                 {
                     int sum = a[i] + b[j] + c[k];
                     set.add(sum);
                 }
             }
         }
         //去掉全0
         System.out.println(set.size() - 1);
    }

}