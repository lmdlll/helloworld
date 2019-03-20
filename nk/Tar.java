package Nvk;

import java.util.Scanner;

/**压缩：
 * google -> g1o2g1l1e1
 * bbbbccd -> b4c2d1
 */

public class Tar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            System.out.println(tar(str));
        }
    }

    public static String tar(String str){
        char[] tmp = str.toCharArray();
        String result = "";
        for(int i=0; i<tmp.length; i++){
            int count = 1;
            char s = tmp[i];
            while (i+1<tmp.length && tmp[i]==tmp[i+1]){
                count++;
                i++;
            }
            result += String.valueOf(s)+count;
        }
        return result;
    }

}
