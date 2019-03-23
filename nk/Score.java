package Nvk;

import java.util.Scanner;

/**
 * 读入N名同学的成绩，将获得某一个给定分数的学生人数输出
 * 输入格式：
 *      第一行：N
 *      第二行：N名学生的成绩，相邻数字用空格分离
 *      第三行：给定分数
 *      ……
 *      当读取到N=0时，输入结束，其中N不超过1000，成绩分数0~100
 */

public class Score {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            if(num==0){
                break;
            }
            int[] data = new int[100];
            for (int i=0; i<num; i++){
                data[i] = in.nextInt();
            }
            int target = in.nextInt();
            stuScore(num,data,target);
        }



    }

    public static void stuScore(int num,int[] data, int target){
        int count = 0;
        for(int i=0; i<num; i++){
            if(data[i]==target){
                count++;
            }
        }
        System.out.println(count);
    }
}
