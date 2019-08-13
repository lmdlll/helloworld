package Nvk;


import java.util.*;

/**
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 *
 * 输入描述:
 * 输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 * 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 * 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 * 输出描述: 输出一个整数,表示最大的总预计消费金额
 * 输入:
 * 3 5
 * 2 4 2
 * 1 3
 * 3 5
 * 3 7
 * 5 9
 * 1 10
 * 输出: 20
 */

public class TableMax {
    /**
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] maxP = new int[n];
            for (int i=0; i<n; i++){
                maxP[i] = in.nextInt();
            }
//            int[][] pc = new int[m][2];
//            for (int i=0; i<m; i++){
//                pc[i][0] = in.nextInt();
//                pc[i][1] = in.nextInt();
//            }
//            test(n,m,maxP,pc);



        }

    }
    */

    //时间复杂度过大
    private static void test(int n, int m, int[] maxP, int[][] pc) {
        int result = 0;
        int max = 0;
        int pos = 0;
        Arrays.sort(maxP);
        //桌子数量
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(pc[j][0]<=maxP[i]){
                    if(pc[j][1]>max){
                        max = pc[j][1];
                        pos = j;
                    }
                }
            }
            result += max;
            max = 0;
            pc[pos][0] = 0;
            pc[pos][1] = 0;
        }
        System.out.println(result);
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int []a = new int[n];
        int [][] bc = new int[m][2];
        for (int i = 0;i < n;i ++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0;i < m;i ++) {
            bc[i][0] = scanner.nextInt();
            bc[i][1] = scanner.nextInt();
        }
        System.out.println(max(a, bc));
    }

    //贪心
    public static long max(int []a, int [][] bc) {
        Comparator comparator = new Comparator<int []>() {
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        };
        Arrays.sort(bc, comparator);
        Arrays.sort(a);
        int i = 0,j = 0;
        long sum = 0;
        int []used = new int[a.length];

        //如果客人都坐好了，则结束循环
        while (i < a.length && j < bc.length) {
            if (a[i] >= bc[j][0] && used[i] == 0) {
                sum += bc[j][1];
                used[i] = 1;
                j ++;
                i = 0;
            }else if (a[i] < bc[j][0] || used[i] != 0){
                i ++;
            }
            //如果还没坐满，那么再次去匹配
            if (i == a.length && !usedup(used)) {
                i = 0;
                j ++;
            }
        }
        return sum;
    }

    public static boolean usedup(int []used) {
        for (int i = 0;i < used.length;i ++) {
            if (used[i] == 0) {
                return false;
            }
        }
        return true;
    }

}
