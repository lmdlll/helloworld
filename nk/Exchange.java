package com.lmd.Buy;

import java.util.Scanner;

public class Exchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        int n = scanner2.nextInt();
        String res = change(str,n);
        System.out.println(res);
    }
    //1,500
    public static String change(String str,int n){
        if(str==null || n>500 || n<1){
            return str;
        }
        String res = "";

        String[] str1 = str.split(" ");
        for(int i=str1.length-1; i>=0; i--){
            if(n==0){
                res += str1[i];
            }else {
                res += str1[i] + " ";
            }
        }
        for(int i=0; i<n; i++){
            char tmp = res.charAt(i);
            if(tmp>='a' && tmp<='z'){
                res = res.replace(tmp,(char) (tmp-32));
            }
            if(tmp>='A' && tmp<='Z'){
                res = res.replace(tmp,(char) (tmp+32));
            }
        }
        return res;
    }


}
