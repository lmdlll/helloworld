package Nvk;

/**
 * 定义一个函数，实现两个数的加法操作，不使用 ‘+’ 或其他运算符
 */

/**
 * 2 010  3 011
 * 010^011 = 011
 * 010<<1 = 100
 * 011^100 = 111
 */
public class Add {
    public static void main(String[] args) {

        System.out.println(addAB(2,3));

    }

    //实现计算进位
    public static int addAB(int A, int B) {
        while (B!=0){
            int sum = A^B;
            int tmp = (A&B)<<1;
            A = sum;
            B = tmp;
        }
        return A;
    }

    //首先考虑的就是异或，错了……，eg：2^3=1
    public static int addAB1(int A, int B) {
        return A^B;
    }
}
