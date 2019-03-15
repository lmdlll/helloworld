package Nvk;

import java.util.Scanner;

public class TreeNode {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        int a = 0;
        int b= 0;
        if(in.hasNext()){
            str = in.nextLine();
        }
        String[] tmp = str.split(",");
        a = Integer.parseInt(tmp[0]);
        b = Integer.parseInt(tmp[1]);
        int res = getLCA(a,b);
        System.out.println(res);
    }

    public static int getLCA(int a, int b) {
        // write code here
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        int r1 = a/2;
        int r2 = b;
        while (r1!=r2){
            r1 = r1/2;
            if(r1==1){
                return 1;
            }
        }
        return r1;
    }

}
