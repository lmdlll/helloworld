package Nvk;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 在m个节点的分布式计算系统中，有一批任务需要执行，每个任务需要的时间是array[i]，每个节点同一时间只能执行一个任务，
 * 每个节点只能执行连续的任务，例如i,i+1,i+2,但是不能执行i,i+2。请问任务完成的最短时间
 *
 * 输入
 * 输入数据包含两行
 * 第一行，空格分隔的两个整数m和n，分别表示节点个数和任务个数(m>0,n>=0)
 * 第二行，空格分隔的正整数序列，表示每个任务需要的时间
 *
 * 输出
 * 一个整数，表示最短完成时间
 *
 *
 * 样例输入
 * 3 5
 * 1 5 3 4 2
 * 样例输出
 * 6
 *
 * 提示
 * 第一个节点执行：任务1和任务2，耗时=1+5=6
 * 第二个节点执行：任务3，耗时=3
 * 第三个节点执行：任务4和任务5，耗时=4+2=6
 * 所以，总最短耗时=6
 */
public class ScheduleTime {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(res);
    }

    public static int schedule(int m,int[] array) {
        int sum = 0;
        int[] time = new int[m];
        for (int i=0; i<array.length; i++){
            sum+=array[i];
        }
        int result = sum/m;
        int tmp = 0;
        int k=0;
        int[] bb = array;
        Arrays.sort(bb);
        int small = bb[0];
        int big = bb[bb.length-1];
        int pj = small+big;
        int count = 0;
        for (int i=0; i<array.length && count<=m; i++){
            if(tmp+array[i]<pj && tmp+array[i]>=result){
                time[count++] = tmp+array[i];
                tmp = 0;
            }else if(tmp+array[i]>pj){
                tmp += array[i];
            }
        }

        Arrays.sort(time);
        return time[time.length-1];
    }


}
