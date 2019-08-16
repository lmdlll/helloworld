package Nvk;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 输入：爱讯飞789swr1wwen34ifly65tek
 * 输出：13456789
 */

public class NumStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String str = in.nextLine();
            compute(str);
        }
        compute("爱讯飞789swr1wwen34ifly65tek");
    }
    public static void compute(String str){
        if(str==null){
            System.out.println(-1);
            return;
        }
        int[] res = new int[str.length()];
        int count = 0;
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='-' && (str.charAt(i+1) >= '0' && str.charAt(i+1) <= '9') ){
                flag = -1;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int tmp = Integer.parseInt(String.valueOf(str.charAt(i)));
                res[count++] = tmp*flag;
                flag = 1;
            }
        }
        if(count==0){
            System.out.println(-1);
            return;
        }
        int[] result = Arrays.copyOf(res, count);
        Arrays.sort(result);
        for (int i : result) {
            System.out.print(i);
        }
    }
    public static void comupte2(String str){
        if(str==null){
            System.out.println(-1);
            return;
        }
        String res = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                res += str.charAt(i);
            }
        }
        if(res.length()==0){
            System.out.println(-1);
            return;
        }
        int[] result = new int[res.length()];
        for (int i=0; i<res.length(); i++){
            result[i] = Integer.parseInt(String.valueOf(res.charAt(i)));
        }
        Arrays.sort(result);
        for (int i : result) {
            System.out.print(i);
        }
    }
}
