package Nvk;

/** 数组中的逆序对
 * 一组数，对于其中任意两个数字，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
 * 设计一个算法，计算给定数组中的逆序对个数
 *
 * eg：
 * 输入：[1,2,3,4,5,6,7,0] 8
 * 输出：7
 */

public class ReverseDouble {
    public static void main(String[] args) {
        System.out.println(count(new int[]{1,2,3,4,5,6,7,0}));
    }

    public static int count(int[] data){
        int result = 0;
        for(int i=0; i<data.length; i++){
            int tmp = data[i];
            for(int j=i; j<data.length; j++){
                if(tmp>data[j]){
                    result++;
                }
            }
        }
        return result;
    }
}
