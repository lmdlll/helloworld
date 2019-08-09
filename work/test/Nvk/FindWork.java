package Nvk;

import java.util.*;

/**
 * 题目描述
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
 * 牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 *
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量 N(N<=100000) 和 小伙伴的数量 M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度 Di(Di<=1000000000) 和 报酬 Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 *
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 * 示例1
 * 输入
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 * 输出
 * 100
 * 1000
 * 1001
 */
public class FindWork {

/**
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   //工作数量
        int m = in.nextInt();   //同学数量
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0; i<n; i++){
            int d = in.nextInt();
            int p = in.nextInt();
            map.put(d,p);
        }
        int[] abli = new int[m];
        for (int i=0; i<m; i++){
            abli[i] = in.nextInt();
        }
        choise(map,abli);

    }
 */
    //通过率30%，运行超时
    public static void choise(HashMap<Integer,Integer> map,int[] abli){
        int[] result = new int[abli.length];
        for(int i=0; i<abli.length; i++){
            int nl = abli[i];
            int max = 0;
            Set<Map.Entry<Integer,Integer>> set = map.entrySet();
            Iterator iterator =  set.iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer,Integer> mapentry = (Map.Entry<Integer, Integer>) iterator.next();
                if(mapentry.getKey()<=nl){
                    if(max<mapentry.getValue()){
                        max = mapentry.getValue();
                    }
                }
            }
            result[i] = max;
        }

        for (int i:result){
            System.out.println(i);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();   //工作数量
        int m = in.nextInt();   //同学数量
        int[][] work = new int[n][2];
        for (int i=0; i<n; i++){
            work[i][0] = in.nextInt();
            work[i][1] = in.nextInt();
        }
        int[] abli = new int[m];
        for (int i=0; i<m; i++){
            abli[i] = in.nextInt();
        }
        choise2(work,abli);
    }
    //40%通过率 ，运行超时
    public static void choise2(int[][] work, int[] abli){
        int[] result = new int[abli.length];
        for (int i=0; i<abli.length; i++){
            int max = 0;
            for (int j=0; j<abli.length; j++){
                if(work[j][0]<=abli[i]){
                    if(max<work[j][1]){
                        max = work[j][1];
                    }
                }
            }
            result[i] = max;
        }
        for (int i:result){
            System.out.println(i);
        }
    }

}
