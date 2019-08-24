package Nvk;

import java.util.Scanner;

/**
 * 题目描述：
 * 合唱队的N名学生站成一排且从左到右编号为1到N，其中编号为i的学生身高为Hi。
 * 现在将这些学生分成若干组（同一组的学生编号连续），并让每组学生从左到右按身高从低到高进行排列，
 * 使得最后所有学生同样满足从左到右身高从低到高（中间位置可以等高），那么最多能将这些学生分成多少组？
 *
 * 输入
 * 第一行包含一个整数N，1≤N≤105。
 * 第二行包含N个空格隔开的整数H1到HN，1≤Hi≤109。
 *
 * 输出
 * 输出能分成的最多组数。
 *
 *
 * 样例输入
 * 4
 * 2 1 3 2
 * 样例输出
 * 2
 *
 * 提示
 * 补充样例
 * 输入样例2
 * 10
 * 69079936 236011312 77957850 653604087 443890802 277126428 755625552 768751840 993860213 882053548
 * 输出样例2
 * 6
 *
 * 此时分组为：
 * 【6907 9936】【2 3601 1312  7795 7850】【6536 04087  4 4389 0802  2 7712 6428】 【7 5562 5552】 【7 6875 1840】
 * 【 9 9386 0213  8 8205 3548】调整顺序后即可满足条件
 *
 *
 *
 */
public class Student {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            int m = in.nextInt();
            int[] data = new int[m];
            for (int i = 0; i < m; i++) {
                data[i] = in.nextInt();
            }

            int count = 1;
            int max = data[0];
            for (int i = 1; i < m; i++) {
                for (int j = i; j < m; j++) {
                    if (max > data[j]) {
                        i = j;
                        break;
                    }
                }
                if (max <= data[i]) {
                    max = data[i];
                    count++;
                }
            }
            System.out.println(count);
        }
//        System.out.println(Integer.MAX_VALUE);
    }


}


