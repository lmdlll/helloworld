package work;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 */
public class Frog {
    public static void main(String[] args) {
//        System.out.println(JumpFloorII2(2));
//        System.out.println(JumpFloorII2(3));
//        System.out.println(JumpFloorII(4));
//        System.out.println(JumpFloorII2(5));
//        System.out.println(JumpFloorII3(6));
        System.out.println(JumpFloorI(2));
        System.out.println(JumpFloorI(3));
        System.out.println(JumpFloorI(4));
        System.out.println(JumpFloorI(5));
    }

    /** 思路分析：
     * eg：有5级台阶，当青蛙在第4层的时候只有一种跳法 ，
     * 当在第3层时有一种方式跳到第4层（第三层到第四层有一种方法，要是直接跳到第五层，则与第四层到第五层的跳法重复了），
     * 在第2层时只有一种方法调到第3层……
     * 这就是一个等比数列
     * f5 = f4+f3+f2+f1+f0 = 2f4
     * f4=f3+f2+f1+f0  =2f3
     * f3=f2+f1+f0 =2f2
     * f2=f1+f0 =2f1
     * f1=1
     */
    //递归 13ms
    public static int JumpFloorII(int target) {
        if(target==1){
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }

    //循环 12ms
    public static int JumpFloorII2(int target){
        if(target<=0){
            return 0;
        }
        int result = 1;
        for(int i=1; i<target; i++){
            result *= 2;
        }
        return result;
    }

    //使用位移 15ms
    public static int JumpFloorII3(int target){
        if(target<=0){
            return 0;
        }
        return 1<<(target-1);
    }


    /**
     * 以上是一只变态青蛙，现在让它变成一个正常的青蛙，限制它一次只能跳1阶或者2阶
     * 思路：就是类斐波那契数列
     * f(i) = f(i-1)+f(i-2)
     * 4 3+2
     * 3 1+1+1=3
     * 2 1+1
     * 1 1
     */

    public static int JumpFloorI(int target){
        if(target<=0){
            return 0;
        }
        int result = 0;
        int f1 = 1;
        int f0 = 0;
        for(int i=0; i<target; i++){
            result = f0+f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }
}
