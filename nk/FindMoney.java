package Nvk;

import java.util.Scanner;

//1   4   16   64
public class FindMoney {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        if(in.hasNext()){
            n = in.nextInt();
        }
        System.out.println(find(n));

    }

    public static int find(int n){
        int sum = 1024-n;
        int min = 1024;
        int tmp = 0;
        //64
        for(int i=0; i*64<=sum; i++){
            //16
            for(int j=0; (j*16+i*64)<=sum; j++){
                //4
                for(int k=0; (j*16+i*64+k*4)<=sum; k++){
                    //1
                    for(int h=0; (j*16+i*64+k*4+h)<=sum; h++){
                        if((j*16+i*64+k*4+h)==sum) {
                            tmp = h + j + i + k;
                            if (min > tmp) {
                                min = tmp;
//                                System.out.println(i + " " + j + " " + k + " " + h);
                            }
                        }
                    }


                }

            }

        }

        return min;
    }

}
