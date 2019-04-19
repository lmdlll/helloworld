package Nvk;

import java.util.Scanner;

/** 二维数组操作
 * 有一个数据表格为二维数组，对该表格中数据的操作可以在单个单元内，也可以对一个整行或整列进行操作，
 * 操作包括交换两个单元中的数据；插入某行或列
 *
 * ps：
 * 1.插入操作时，对m*n表格，擦忽然行号允许0~m，插入列号只允许0~n
 * 2.只需记录初始表格中数据的变化轨迹，查询超过初始表格的数据返回错误
 * 3.查询数据要求返回一个链表，链表中节点的顺序即为该查询的数据在表格中位置变化顺序
 * 输入：
 * 1.表格的行列值
 * 2.要交换的两个单元格的行列值
 * 3.输入要插入的行的数值
 * 4.输入要插入的列的数值
 * 5.输入要获取运动轨迹的单元格的值
 * 输出：
 * 1.初始化表格是否成功，成功返回0，否则返回-1
 * 2.输出交换单元格是否成功
 * 3.输出插入行是否成功
 * 4.输出插入列是否成功
 * 5.输出要查询的运动轨迹的单元查询是否成功
 *
 * eg：
 * 输入：
 * 3 4
 * 1 1
 * 0 1
 * 2
 * 1
 * 2 2
 * 输出：
 * 0
 * 0
 * 0
 * 0
 * 0
 *
 */

public class ArrayExcute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int r = sc.nextInt();
            int c = sc.nextInt();

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int row = sc.nextInt();
            int col = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();

            if (r >= 0 && r <= 9 && c >= 0 && c <= 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            if (x1 >= 0 && x1 < r && y1 >= 0 && y1 < c && x2 >= 0 && x2 <r && y2 >= 0 && y2 <c) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            if (row >= 0 && row < r) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }


            if (col >= 0 && col <c) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }


            if (x3 >= 0 && x3 < r && y3 >= 0 && y3 < c) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }

}
