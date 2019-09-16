package Nvk;


import java.util.Scanner;

/**
 * n个点，编号为0,1,2,3，……n-1，从编号为0点开始计数，每数到5摘除该点，然后重新计数，纸质只剩一点，求改点编号
 *
 * 输入：66
 * 输出：40
 *
 *
 */
public class Find3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            if(n<=0){
                System.out.println("error");
                return;
            }
            if(n==1){
                System.out.println(0);
                return;
            }


            int[] exit = new int[n];
            for (int i=0; i<n; i++){
                exit[i] = 1;
            }
            int key = 5;
            int count = n;
            int i=0;
            while (count!=1){
                if (key==1){
                    if(exit[i]==1) {
                        exit[i] = 0;
                    }else{
                        while (exit[i]!=1){
                            if(i==n-1){
                                i=0;
                            }else {
                                i++;
                            }
                        }
                        exit[i] = 0;
                    }
                    count--;
                    key = 5;
                    if(i==n-1){
                        i=0;
                    }else {
                        i++;
                    }

                } else {
                    if(i==n-1){
                        i=0;
                    }
                    if(exit[i]!=0){
                        key--;
                        i++;
                    }else {
                        i++;
                    }
                }
            }

            for (int j=0; j<n; j++){
                if(exit[j]==1){
                    System.out.println(j);
                }
            }


        }


    }
}
