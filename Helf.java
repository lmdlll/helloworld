package Nvk;

import java.util.Scanner;
import java.util.Stack;

//输入n个整数，输出出现数大于等于数组长度一半的数
public class Helf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] data = str.split(" ");
        int[] res = new int[data.length];
        for(int i=0; i<data.length; i++){
            res[i] = Integer.parseInt(data[i]);
        }
        int len = res.length/2;
        int[] add = new int[100];
        for(int i=0; i<res.length; i++){
            int tmp = res[i]%100;
            add[tmp] +=1;
        }
        int result = -1;
        for(int i=0; i<add.length; i++){
            if(add[i]>=len){
                result = i;
                break;
            }
        }

        System.out.println(result);


    }
}
