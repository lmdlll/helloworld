package Nvk;


import java.util.Scanner;

//求两个字符串的公共字符串长度
//asdfas werasdfaswer
public class CommonStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            String str1 = in.next();
            String str2 = in.next();
            System.out.println(common(str1,str2));
        }
    }

    public static int common(String str1,String str2){
        if(str1==null || str2==null){
            return 0;
        }
        int count = 0;
        int max = 0;
        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                char tmp = str1.charAt(i);
                int k = i;
                while (j<str2.length() && tmp==str2.charAt(j)){
                    count++;
                    if(k+1<str1.length()){
                        j++;
                        k++;
                        tmp = str1.charAt(k);
                    }else {
                        break;
                    }
                }
                if(tmp!=str2.charAt(j) && count!=0){
                    j--;
                }
                max = Math.max(max,count);
                count=0;
            }

        }

        return max;
    }
}
