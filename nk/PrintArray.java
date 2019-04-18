package Nvk;

/** 二维数组打印
 * 有一个二维数组（n*n），写程序实现从右上角到左下角言主对角先方向打印
 * eg：
 * 输入：[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
 * 输出：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 */

public class PrintArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
arrayPrint(arr,4);
    }

    public static int[] arrayPrint(int[][] arr, int n) {
        int[] tmp = new int[n*n];
        int index = 0;
        int startX = 0;
        int startY = n-1;
        while(startX<n) {
            int x = startX;
            int y = startY;
            while (x < n && y < n) {
                tmp[index++] = arr[x++][y++];
            }
            //设置坐标值
            if (startY > 0) {
                startY--;
            } else {
                startX++;
            }
        }

        return tmp;
    }
}
