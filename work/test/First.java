/** 矩形覆盖：
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 思路：
 * 自己画图找
 * //      1 2 3 5 8
 * //（2*） 1 2 3 4 5
 *
 */

public class First {
    public static void main(String[] args) {
        System.out.println("hello");

        System.out.println(RectCover(5));

    }

    //运行不通过，原因：如果是0，或者1，有错误
//    public static int RectCover(int target) {
//        //1 2 3 5 8
//        //1 2 3 4 5
//        if(target<=1){
//            return 1;
//        }
//        return RectCover(target-1)+RectCover(target-2);
//    }
    public static int RectCover(int target) {
        if (target < 1) {
            return 0;
        } else if (target == 1 || target == 2) {
            return target;
        } else {
            return RectCover(target-1) + RectCover(target-2);
        }
    }
}
