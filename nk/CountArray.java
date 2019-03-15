package Nvk;

import java.util.Scanner;

/**
 * 要求：输入：11031  输出：0:1 <br> 1:3 <br> 3:1
 */

public class CountArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = "";
        while (sc.hasNext()){
            n = sc.next();
            count(n);
        }

    }
    public static void count(String data){
        if(data.charAt(0)==0){
            return;
        }
        int[] tmp = new int[10];
        for (int i=0; i<data.length(); i++){
            int sl = Integer.parseInt(String.valueOf(data.charAt(i)));
            tmp[sl]++;
        }

        for (int i=0; i<tmp.length; i++){
            if(tmp[i]!=0){
                System.out.println(i+":"+tmp[i]);
            }

        }

    }
//未通过所有测试案例
    public static void counti(int data){
        int[] tmp = new int[10];
        int count = 0;
        int k = data;
        while (k != 0){
            k/=10;
            count++;
        }
        String str = String.valueOf(data);
        for (int i=0; i<count; i++){
            int sl = Integer.parseInt(String.valueOf(str.charAt(i)));
            tmp[sl]++;
        }

        for (int i=0; i<tmp.length; i++){
            if(tmp[i]!=0){
                System.out.println(i+":"+tmp[i]);
            }

        }

    }


}
