package Nvk;

import java.util.Scanner;

/**
 * 根据无人机传输回来的信息进行解析，并最终得到整个小岛的地图
 *
 * 输入：
 * N M (N<=50  M<=50)
 * G R F F -
 * F G R F G
 * R F G F F
 * G R G F R
 * G G G R G
 * G R - R G
 * R - - R R
 * R R R - R
 * R F R - R
 * R F R - G
 * G F R - F
 * F F G - -
 *
 *
 * 输出：
 * R G F R G R
 * G F R G G G
 * F F F F R R
 * F G R R R R
 *
 */
public class LandMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            int len = (n/2)*m;
            int[][] map = new int[n][m];




        }


    }
}
