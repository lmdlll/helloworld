package Nvk;

import java.util.Scanner;

/** 计算日期到天数转换
 * 根据输入的日期，计算这天是今年的第几天
 * int iCoverDateToDay(int year, int month, int day)
 * 输入三行，分别是年，月，日
 * 成功返回输出计算后的第几天，失败返回-1
 * 输入：
 * 2012
 * 12
 * 31
 * 输出：366
 *
 */

public class Date {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        while(sc.hasNext()){
            int year = sc.nextInt() ;
            int month = sc.nextInt() ;
            int day = sc.nextInt() ;
            int Day = iCoverDateToDay(year, month, day) ;
            System.out.println(Day);
        }
//        System.out.println(iCoverDateToDay(2019,12,31));
    }
    public static int iCoverDateToDay(int year, int month, int day){
        if(year<=0||month<=0||month>12||day>31||day<=0) {
            return -1;
        }
        int result = 0;
        int[] t1 = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //判断是否闰年
        if(runyear(year)){
            t1[1] = 29;
        }
        for(int i=0; i<month-1; i++) {
            result += t1[i];
        }
        return result+day;
    }

    private static int outDay(int year, int month, int day) {
        int [] Day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31} ;
        if(year <= 0 ||month <= 0 || month > 12 || day<= 0 || day > Day[month - 1])
            return -1;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            Day[1] = 29 ;
        }
        int sum = 0 ;
        for(int i = 0 ; i < month - 1 ; i ++){
            sum += Day[i] ;
        }
        return sum + day;
    }

    public static boolean runyear(int year){
        /**
         * 如果能被4整除，且不能被100整除，则为闰年
         * 如果能被100整除，且能被400整除，则为闰年
         * 如果能被100整除，但不能被400整除，则不是闰年
         */
        if((year%400==0)||(year%100!=0 && year%4==0)){
            return true;
        }
        return false;
    }

}




