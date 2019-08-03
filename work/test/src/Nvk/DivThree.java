package Nvk;

import java.util.Scanner;

/**
 * 题目描述
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 *
 * 输入描述:输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 * 输出描述:输出一个整数, 表示区间内能被3整除的数字个数。
 *
 * 示例1
 * 输入
 * 2 5
 * 输出
 * 3
 * 说明
 * 12, 123, 1234, 12345...
 * 其中12, 123, 12345能被3整除。
 */
public class DivThree {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int l = in.nextInt();
//        int r = in.nextInt();
//        String[] data = new String[r];
//        data[0] = "1";
//        for (int i=1; i<r; i++){
//            data[i] = data[i-1]+(i+1);
//        }
//        System.out.println(DivThr2(data,l,r));


        Scanner input = new Scanner(System.in);
        while(input.hasNext()) {
            int l = input.nextInt();
            int r = input.nextInt();
            long sum = 0;
            for (int i = 1; i < l; i++) {
                sum += i;
            }
            int count = 0;
            for (int i = l; i <= r; i++) {
                sum += i;
                if (sum % 3 == 0)
                    count++;
            }
            System.out.println(count);
        }

    }

    //思路1：先转换为int型，然后进行运算
    //会出现数组越界访问异常
    public static int DivThr(String[] data,int l, int r){
        int count = 0;
        for (int i=l-1; i<r; i++){
            //问题在这里，有的数字太大了
            int tmp = Integer.parseInt(data[i]);
            if(tmp % 3 == 0){
                count++;
            }
        }
        return count;
    }

    //思路2：能被3整除的数字，各位数的数字相加可被3整除
    //很好，掌握精髓了，然后选择变通，将代码变的更为简单
    public static int DivThr2(String[] data, int l, int r){
        int count = 0;
        for (int i=l-1; i<r; i++){
            char[] tmp = data[i].toCharArray();
            int num = 0;
            for (int j=0; j<tmp.length; j++){
                num += Integer.parseInt(String.valueOf(tmp[j]));
            }
            if(num%3==0){
                count++;
            }
        }

        return count;
    }

    //别人的思路，没看懂  i%3%2==0 这里是真没懂
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int count = 0;
//        for(int i=n;i<=m;i++){
//            if(i%3%2==0){
//                count++;
//            }
//        }
//        System.out.println(count);
//    }
}
