package Nvk;


import java.util.Scanner;

/**
 * 2004-03-01
 * 61
 *
 * 2019-01-09
 * 9
 *
 */
public class DayConf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            String[] data = str.split("-");

            int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
            //先判断年份
            if(Judeg(Integer.parseInt(data[0]))){
                months[1] = 29;
            }
            int result = 0;
            int month = Integer.parseInt(data[1]);
            int day = Integer.parseInt(data[2]);
            for (int i=1; i<month; i++){
                result += months[i-1];
            }
            result += day;
            System.out.println(result);

        }


    }

    //判断闰年
    public static boolean Judeg(int year){
        if(year%4==0 && year%100!=0 || year%400==0){
            return true;
        }
        return false;
    }
}
