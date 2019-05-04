/** 六一儿童节
每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。
老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。

输入描述:
 第一行：n，表示h数组元素个数
 第二行：n个h数组元素
 第三行：m，表示w数组元素个数
 第四行：m个w数组元素
输出描述:
上台表演学生人数
eg：
输入
 3 
 2 2 3
 2
 3 1 
输出
1
*/


import java.util.Arrays;
import java.util.Scanner; public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// n个学生
        int[] h = new int[n];// 学生
        for (int i = 0; i < h.length; i++) {
            h[i] = sc.nextInt();
        }
        int m = sc.nextInt();// m个巧克力
        int[] w = new int[m];// 巧克力
        for (int i = 0; i < w.length; i++) {
            w[i] = sc.nextInt();
        }
 
        Arrays.sort(w);// 巧克力排序
        Arrays.sort(h);// 学生排序
 
        int stuStart = 0;
        int count = 0;
        for (int i = 0; i < w.length; i++) {
			// 如果最小的巧克力比最小的学生要的小,那么跳出去下一个巧克力
            if (w[i] < h[stuStart]) {
                continue;
            }
			// 如果最小的巧克力比最小的学生要的大
			else {
                count++;
                stuStart++;// 给他后,把最小的学生加一个
				// 如果最后一个学生都有糖了,就不找了,break掉
                if (stuStart == n) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}

