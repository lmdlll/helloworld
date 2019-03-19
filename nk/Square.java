package Nvk;

import java.util.Scanner;

/**
 * 输入：在一行中给出正方形边长n（3<=n<=20)和组成正方形边的某种字符c，间隔一个空格
 * 输出：输出的行数实际是列数的50%
 */
public class Square {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            int n = in.nextInt();
            String c = in.next();
            print(n,c);
        }


    }

    public static void print1(int n,String c){
        int width = n;
        int height = 0;
        if(n%2==0){
            height = n/2;
        }else {
            height = n/2+1;
        }
        String s = "";
        for(int i=0;i<width; i++) {
                s += c;
        }
        String l = "";
        for(int i=0; i<width; i++){
            if(i==0 || i==width-1){
                l += c;
            }else {
                l += " ";
            }
        }
        for(int i=0; i<width; i++){
            if(i==0 || i==width-1){
                System.out.println(s);
            }
            for(int j=0; j<height-2 && i!=0 && i!=width-1 ; j++){
                System.out.println(l);
            }
        }


    }

    public static void print(int n,String c){
        int width = n;
        int height = 0;
        if(n%2==0){
            height = n/2;
        }else {
            height = n/2+1;
        }

        for(int i=1 ;i<=height ;i++){
            if(i!=1&&i!=height){
                for(int j=1 ;j<=n;j++){
                    if(j==1){
                        System.out.print(c);
                    }
                    else if(j==n){
                        System.out.println(c);
                    }
                    else{
                        System.out.print(" ");
                    }
                }
            }else{
                for(int j=1 ;j<=n;j++){
                    if(j==n){
                        System.out.println(c);
                    }else{
                        System.out.print(c);
                    }
                }
            }
        }

    }

}
