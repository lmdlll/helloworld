package Nvk;

import java.util.Scanner;

/**
 * 题目描述：
 * 某公司雇有N名员工，每名员工可以负责多个项目，但一个项目只能交由一名员工负责。现在该公司接到M个项目，
 * 令Ai,j表示第i名员工负责第j个项目所带来的收益，那么如果项目分配得当，总收益最大是多少？
 *
 * 输入
 * 第一行包含两个整数N和M，1≤N，M≤1000。
 *
 * 接下来N行，每行包含M个整数，第i行的第j个整数表示Ai,j，1≤Ai,j≤1000。
 *
 * 输出
 * 输出总收益的最大值。
 *
 *
 * 样例输入
 * 3 3
 * 1 3 3
 * 2 2 2
 * 3 2 1
 * 样例输出
 * 9
 *
 */
public class PerWork {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] data = new int[n][m];
            for (int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    data[i][j] = in.nextInt();
                }
            }

            int sum = 0;
            //任务
            for (int i=0; i<m; i++){
                int max = 0;
                //员工
                for (int j=0; j<n; j++){
                    //收益
                    if(data[j][i]>max){
                        max = data[j][i];
                    }
                }
                sum += max;
            }
            System.out.println(sum);

        }


    }
}
