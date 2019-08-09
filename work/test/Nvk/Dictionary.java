package Nvk;

import java.util.*;

/**
 * 题目描述
 * 小易在学校中学习了关于字符串的理论, 于是他基于此完成了一个字典的项目。
 * 小易的这个字典很奇特, 字典内的每个单词都包含n个'a'和m个'z', 并且所有单词按照字典序排列。
 * 小易现在希望你能帮他找出第k个单词是什么。
 *
 * 输入描述: 输入包括一行三个整数n, m, k(1 <= n, m <= 100, 1 <= k <= 109), 以空格分割。
 * 输出描述: 输出第k个字典中的字符串，如果无解，输出-1。
 * 示例1
 * 输入 2 2 6
 * 输出 zzaa
 * 说明 字典中的字符串依次为aazz azaz azza zaaz zaza zzaa
 */

/**TODO:别人的思路，借鉴一下，还没看完
 * 排列组合，n个'a'和m个'z'，只能组成$C_{n+m}^n$，记为count(n+m,n) 个单词。
 *
 * 思路：
 * 假设第一个字符为a，则剩下n-1个'a'和m个'z'组成的子序列只能构成count(n-1+m,n-1)个单词，且是字典中前count(n-1+m,n-1)个单词。
 * 比较k和count(n-1+m,n-1)，若k小，说明k是前count(n-1+m,n-1)个单词，则第一个字符必为'a'。
 * 子问题化为在子序列(n-1个'a'和m个'z')找到第k个单词
 * 若k大，则说明第一个字符必为'z',单词是以'z'开头的单词中的第k-count(n-1+m,n-1)个。
 * 子问题化为在子序列(n个'a'和m-1个'z')找到第k-count(n+m-1,m-1)个单词。
 *
 * eg:n=2,m=2,k=5
 * 假设第一个字符为a,则剩下1个a,2个z只能构成3个单词，且是字典中前3个单词(aamm,amam,amma)
 * k>3，则第一个字符必为z。原问题化为在n=2,m=1,k=2，即在剩下2个a，1个z中找到第2个单词
 */
public class Dictionary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();//a的个数
        int n = scan.nextInt();//z的个数
        long target = scan.nextInt();//目标第几个
        long k =0;
        ArrayList<String> list = new ArrayList<String>();
        while(m>0&&n>0) {//当a和z均存在时执行
            k = pz(m-1,n,target);//假设a确定，出去a之后剩余a和z的排列组合个数
            if(k>=target) {//如果确定a之后，剩余的排列组合数大于目标，则说明a已确定
                list.add("a");
                m--;//a的个数减1
            }else {//如果确定a之后，剩余的排列组合数小于目标，则说明不是a。
                list.add("z");
                n--;//z的个数减1
                target -= k;//目标减掉排列组合数。因为如果a开头可以有k中情况，
                //减掉k之后即为确定z开头之后，接下来找第target个即可。
            }
        }
        if(target != 1) {//存在经过计算之后必为1
            System.out.println("-1");
            return;
        }else {
            while(m>0) {//如果z的个数为0，则将a追加到最后即可
                list.add("a");
                m--;
            }
            while(n>0) {//如果a的个数为0，则将z追加到最后即可
                list.add("z");
                n--;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
    public static long pz(int m,int n,long target) {//计算假设a确定之后，a之后的部分排列组合数
        if(m==0||n==0)
            return 1;
        long sum = m+n;
        long k = 1;
        n = Math.min(m, n);//C(m+n) n=C(m+n) m  取最小即可
        for (int i = 0; i < n ; i++) {
            k *= sum-i;
            k /= (i+1);
            if(k>target)//防止大数。如果k>target 则只进行list.add("a")和m--//a的个数减1。
                //没有target -= k;因此不影响
                break;
        }
        return k;
    }



}
