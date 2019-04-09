package Nvk;

import java.util.Scanner;

/**
 * 一只兔子，出生后第三个月生一只兔子，小兔子长到第三个月又生，
 * 假设兔子不死，问每个月兔子总数为多少？
 * 1   1
 * 2   1
 * 3   2
 * 4   3
 * 5   5
 * 6   8
 * 7   13
 * 8   21
 * 9   34
 * …………
 * 本质上是斐波那契数
 */

public class rabbit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int monthCount = in.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
        in.close();
    }



    public static int getTotalCount(int month){
        if(month<3){
            return 1;
        }
        return getTotalCount(month-1)+getTotalCount(month-2);
    }



    public static int getTotalCount1(int mounth){
        if(mounth == 1 || mounth == 2){
            return 1;
        }
        int tempold = 1;
        int tempyoung = 1;
        int mounth1 = 1;
        int mounth2 = 0;
        for(int j = 4; j <= mounth; j++){
            //第一步，第二个月的变成了有生育能力的兔子
            tempold += mounth2;
            //第二步，一个月大的兔子变成了两个月大的兔子
            mounth2 = mounth1;
            //第三步，有生育能力的兔子生出了一个月大的小兔子
            mounth1 = tempold;
            //当月小兔子的个数
            tempyoung = mounth1 + mounth2;

        }
        return tempold + tempyoung;
    }


}
