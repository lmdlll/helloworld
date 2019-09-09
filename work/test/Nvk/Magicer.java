package Nvk;

import java.util.Scanner;

/**
 * 法师住在喜马拉雅上脚下的一个村庄，突然一天，发生大雪崩，很快村庄就要被掩埋，所有人将会遇难。
 * 法师的跑步的速度为13m/s,以这样的速度，是无法逃离雪崩的。
 * 但是，法师有闪跳技能，可在1s内移动50m,每次使用技能后，会消耗10点魔法值。魔法值的恢复速度为4点/s,只有在原地休息状态时才能够恢复。
 *
 * 现已知法师初始值为M,所在位置与安全区域的距离为S,雪崩到达村庄的时间为T。
 * 编写一个程序，计算法师如何在最短的时间内到达安全区域，如不能够逃脱，输出法师在时间内走的最远距离。
 *
 * 输入
 * 输入一行，包括空格隔开的三个非负整数M，S，T。
 *
 * 输出
 * 输出两行:
 *
 * 第1行为字符串"Yes"或"No" (区分大小写)，即守望者是否能逃离荒岛。
 * 第2行包含一个整数，第一行为"Yes" (区分大小写）时表示守望着逃离荒岛的最短时间
 *
 * 第一行为"No" (区分大小写) 时表示守望者能走的最远距离。
 *
 *
 * 样例输入
 * 36 255 10
 * 样例输出
 * Yes 10
 */
public class Magicer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int m = in.nextInt();
            int s = in.nextInt();
            int t = in.nextInt();
            Test(m,s,t);
        }


    }
    public static void Test(int m, int s, int t){
        //跑步速度13
        int run = 13;
        //闪跳技能
        int skill = 0;
        for (int i=0; i<t; i++){
            //如果大于10，可以闪跳
            if(m>=10){
                m -= 10;
                skill += 50;
            }else {
                //否则，体能回复
                m += 4;
            }
            run = Math.max(run,skill);
            if(run>=s){
                System.out.println("Yes");
                System.out.println(i+1);
                return;
            }
            run += 13;
        }
        System.out.println("No");
        System.out.println(run);
    }
}
