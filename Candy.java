package Nvk;

import java.util.Scanner;

public class Candy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[4];
        if(scanner.hasNextInt()){
            for(int i=0; i<4; i++) {
                data[i] = scanner.nextInt();
            }
            int a,b,c;
            a = (data[0]+data[2])/2;
            b = (data[1]+data[3])/2;
            c = (data[3]-data[1])/2;
            if((a-b==data[0]) && (b-c==data[1]) && (a+b==data[2]) &&(b+c==data[3])){
                System.out.println(a+" "+b+" "+c);
            }else{
                System.out.println("No");
            }
        }

    }

}
