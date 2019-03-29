package Nvk;

import java.util.Scanner;

/**
 * A1 = 能被5整除的数字中所有偶数的和
 * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即：n1-n2+n3-n4
 * A3 = 被5除后余2的数字的个数
 * A4 = 被5除后余3的数字的平均数，精确到小数点后1位
 * A5 = 被5除后余4的数字中最大数字
 *
 * 输入：
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 * 输出：
 * 30 11 2 9.7 9
 */
public class FiveNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            int[] data = new int[n];
            for(int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            Print(data);
        }

    }

    public static void Print(int[] data){
        int[] a1 = new int[data.length];
        int a11 = 0;
        int[] a2 = new int[data.length];
        int a22 = 0;
        int[] a3 = new int[data.length];
        int a33 = 0;
        int[] a4 = new int[data.length];
        int a44 = 0;
        int[] a5 = new int[data.length];
        int a55 = 0;
        for(int i=0; i<data.length; i++){
            switch (data[i]%5){
                case 0:
                    a1[a11++] = data[i];
                    break;
                case 1:
                    a2[a22++] = data[i];
                    break;
                case 2:
                    a3[a33++] = data[i];
                    break;
                case 3:
                    a4[a44++] = data[i];
                    break;
                case 4:
                    a5[a55++] = data[i];
                    break;
            }
        }
        A1(a1,a11);
        A2(a2,a22);
        A3(a33);
        A4(a4,a44);
        A5(a5,a55);

    }
    public static void A1(int[] data,int n){
        if(n==0){
            System.out.print("N"+" ");
            return;
        }
        int sum = 0;
        for(int i=0; i<n; i++){
            if(data[i]%2==0){
                sum += data[i];
            }
        }
        if(sum==0){
            System.out.print("N"+" ");
            return;
        }
        System.out.print(sum+" ");
    }
    public static void A2(int[] data,int n){
        if(n==0){
            System.out.print("N"+" ");
            return;
        }
        int flag = 1;
        int sum = 0;
        for(int i=0; i<n; i++){
            if(i%2==0){
                flag = 1;
            }else {
                flag = -1;
            }
            sum = sum + data[i]*flag;
        }
        System.out.print(sum+" ");
    }
    public static void A3(int n){

        System.out.print(n+" ");
    }
    public static void A4(int[] data,int n){
        if(n==0){
            System.out.print("N"+" ");
            return;
        }
        float sum = 0;
        for(int i=0; i<n; i++){
            sum+=data[i];
        }
        System.out.print(String.format("%.1f",sum/n)+" ");
    }
    public static void A5(int[] data, int n){
        if(n==0){
            System.out.print("N"+" ");
            return;
        }
        int max = data[0];
        for(int i=0; i<n; i++){
            max = Math.max(max,data[i]);
        }
        System.out.print(max);
    }
}
