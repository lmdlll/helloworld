package Nvk;

import java.util.Scanner;

//¼ì²éÓ¢ÎÄµ¥´Ê
//helllo --> hello
//aabb ---> aab
public class removeDouble {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 0 ;
        if (in.hasNext()) {
            num = in.nextInt();
        }
        while (num>0) {
            String str = in.nextLine();
            System.out.println(check(str));
            num--;
        }
    }

    public static String check(String str){


        if(str.length()<=1 || str==null){
            return str;
        }
        int a=0;
        while (a<str.length()) {
            for (int i = 0; i < str.length(); i++) {
                if ((i + 2 < str.length()) && str.charAt(i) == str.charAt(i + 1)) {
                    if (i + 3 < str.length() && str.charAt(i + 2) == str.charAt(i + 3)) {
                        char tmp = str.charAt(i + 2);
                        str = str.substring(0, i + 2) + str.substring(i + 3);
                        break;
                    }
                }

            }
            a++;
        }
        a=0;
        while (a<str.length()) {
            for (int i = 0; i < str.length(); i++) {
                if ((i + 2 < str.length()) && str.charAt(i) == str.charAt(i + 1)) {
                    if (str.charAt(i + 1) == str.charAt(i + 2)) {
                        char tmp = str.charAt(i + 1);
                        StringBuilder s = new StringBuilder("");
                        String l = s.append(tmp).append(tmp).toString();
                        String h = s.append(tmp).toString();
                        str = str.replaceAll(h, l);
                        break;
                    }
                }

            }
            a++;
        }

        return str;
    }
}
