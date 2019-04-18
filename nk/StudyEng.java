package Nvk;

import java.util.Scanner;

/** 学英语
 *  22->twenty two
 *  123-> one hundred and twenty three
 *  and, billion, million, thousand, hundred
 */

public class StudyEng {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        if(in.hasNext()){
//            long n = in.nextLong();
//            change(n);
//        }
//        change(1234);

    }
//    public static String change(long n){
//        String[] num = new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};
//        String[] num2 = new String[]{"eleven","twelve","thirteen","fourteen","fifteen","seventeen","eighteen","ninetee"};
//        String[] num3 = new String[]{"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
//        String[] tmp = new String[]{"and","billion","million","thousand","hundred"};
//
//
//
//    }

    public static String[] bit_num = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static String[] ten_num = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

    public static String[] twenty_more = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};


    public static String parse(long num){
        if(num < 0) return "error";
        StringBuffer sb = new StringBuffer();
        long billion = num / 1000000000;
        if(billion != 0){
            sb.append(trans(billion) + " billion ");
        }

        num %= 1000000000;
        long million = num / 1000000;
        if(million != 0){
            sb.append(trans(million) + " million ");
        }

        num %= 1000000;
        long thousand = num / 1000;
        if(thousand != 0){
            sb.append(trans(thousand) + " thousand ");
        }

        num %= 1000;
        long hundred = num;
        if(hundred != 0){
            sb.append(trans(hundred));
        }
        return sb.toString().trim();
    }
    public static String trans(long num){
        StringBuffer sb = new StringBuffer();
        int h = (int)(num / 100);
        if(h != 0){
            sb.append(bit_num[h] + " hundred");
        }

        num %= 100;
        int t = (int)(num / 10);
        if(t != 0){
            if(h != 0){
                sb.append(" and ");
            }
            if(t == 1){
                sb.append(ten_num[(int)(num%10)]);
            }
            else{
                sb.append(twenty_more[(int)(t - 2)] + " ");
                if(num % 10 != 0){
                    sb.append(bit_num[(int)(num%10)]);
                }
            }
        }
        else if(num % 10 != 0){
            if(h != 0){
                sb.append(" and ");
            }
            sb.append(bit_num[(int)(num%10)]);
        }
        return sb.toString().trim();
    }
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            long num = in.nextLong();
//            System.out.println(parse(num));
//        }
//        in.close();
//    }


}
