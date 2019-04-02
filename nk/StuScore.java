package Nvk;

import java.util.Scanner;

/**
 * 实际成绩  绩点
 * 90-100  4.0
 * 85-89   3.7
 * 82-84   3.3
 * 78-81   3.0
 * 75-77   2.7
 * 72-74   2.3
 * 68-71   2.0
 * 64-67   1.5
 * 60-63   1.0
 * 60 以下0.1
 * 学分绩点 = 该课绩点*该课学分
 * 总评绩点 = 所有学科绩点之和 / 所有课程学分之和
 *
 *
 * 输入描述：
 * 总课程数n
 * 相应课程学分
 * 对应课程实际得分
 *
 * 输出：
 * 总评绩点，精确到小数点后2位
 *
 * eg:
 * 输入：
 *  5
 *  4 3 4 2 3
 *  91 88 72 69 56
 * 输出：
 *  2.52
 *
 * （4*4 + 3*3.7 + 4*2.3 + 2*2.0 + 3*0.1 ）/（4+3+4+3+2）
 *
 */


public class StuScore {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            int[] data1 = new int[n];
            int[] data2 = new int[n];
            for(int i=0; i<n; i++){
                data1[i] = in.nextInt();
            }
            for(int i=0; i<n; i++){
                data2[i] = in.nextInt();
            }
            Result(data1,data2);
        }


    }

    public static void Result(int[] data1, int[] data2){
        double jd = 0;
        double scojd = 0;
        double sum = 0;
        for(int i=0; i<data1.length; i++){
            int tmp = data2[i];
            if((tmp >= 90) && (tmp <= 100)){
                jd = 4.0;
            }else if((tmp >= 85) && (tmp <= 89)){
                jd = 3.7;
            }else if((tmp >= 82) && (tmp <= 84)){
                jd = 3.3;
            }else if((tmp >= 78) && (tmp <= 81)){
                jd = 3.0;
            }else if((tmp >= 75) && (tmp <= 77)){
                jd = 2.7;
            }else if((tmp >= 72) && (tmp <= 74)){
                jd = 2.3;
            }else if((tmp >= 68) && (tmp <= 71)){
                jd = 2.0;
            }else if((tmp >= 64) && (tmp <= 67)){
                jd = 1.5;
            }else if((tmp >= 60) && (tmp <= 63)){
                jd = 1.0;
            }else if((tmp >= 0) && (tmp <= 59)){
                jd = 0.1;
            }
            scojd = jd*data1[i];
            sum += scojd;
        }
        double result = sum / xuefen(data1);
        System.out.println(String.format("%.2f",result));
    }

    //总学分之和
    public static int xuefen(int[] data){
        int result = 0;
        for(int i=0; i<data.length; i++){
            result += data[i];
        }
        return result;
    }


}
