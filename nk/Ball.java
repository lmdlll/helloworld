package Nvk;

import java.util.Scanner;

/**
 * 球的半径和体积
 * 输入球的中心点和球上某点的坐标，计算球的半径和体积
 * 输入：球的中心点和某点坐标，x0 y0 z0 x1 y1 z1
 * 输出：对于每组输出，输出球的半径和体积，并且结果保留三位小数
 *
 * eg：
 * 输入： 0 0 0 1 1 1
 * 输出：1.732  21.766
 *      体积：v = 4/3πr^3
 */

public class Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            double x0=in.nextFloat();
            double y0=in.nextFloat();
            double z0=in.nextFloat();
            double x1=in.nextFloat();
            double y1=in.nextFloat();
            double z1=in.nextFloat();
            Compute(x0,y0,z0,x1,y1,z1);

        }



    }

    public static void Compute(double x0, double y0,double z0, double x1,double y1, double z1){
        //球半径
        double r = Math.sqrt(((x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0)));
        System.out.print(String.format("%.3f",r)+" ");
        //球体积  π->Math.acos(-1)
        double t = Math.acos(-1)*r*r*r*4/3;
        System.out.println(String.format("%.3f",t));


    }
}
