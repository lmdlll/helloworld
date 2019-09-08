package Nvk;

import java.util.*;

/**
 * 'A' - 1
 * 'B' - 2
 * ……
 * 'Z' - 26
 *
 * 输入：只包含数字的非空字符串
 * 输出：  （当输出有多个结果时，按字母的大小顺序输出)
 *
 * eg：
 * 输入：12
 * 输出：
 * AB
 * L
 *
 *
 * 1221
 * ABBA
 * ABU
 * AVA
 * LBA
 * LU
 *
 */
public class RequestCode {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String n = in.next();
            char[] data = n.toCharArray();

            for (int i=0;i<data.length; i++) {
                String str = "";
                str += one(data,0,i);
                str += two(data,i,(data.length));
                set.add(str);
            }

            for (int i=0;i<data.length; i++) {
                String str = "";
                str += two(data,0,i);
                str += one(data,i,data.length);
                set.add(str);
            }

            //排序
            List<String> list = new ArrayList<>();
            for (String s:set){
                list.add(s);
            }

            for (String s:list) {
                System.out.println(s);
            }


        }

    }

    public static String one(char[] data, int left, int right) {
        //每个数字单独拆分
        String str = "";
        for (int i=left; i<right; i++) {
            str += change(Integer.parseInt(String.valueOf(data[i])));
        }
        return str;
    }

    public static String two(char[] data,int left, int right){
        String str = "";
        for (int i=left; i<right; i++){
            int b = Integer.parseInt(String.valueOf(data[i]))*10;
            if((i+1)>=right){
                return String.valueOf(change(b/10));
            }else {
                int a = Integer.parseInt(String.valueOf(data[i + 1]));
                if (a + b <= 26) {
                    str += change(a + b);
                    int tmp = i + 2;
                    if (tmp == (right - 1)) {
                        str += change(Integer.parseInt(String.valueOf(data[tmp])));
                        return str;
                    }
                    if (tmp < (right - 1)) {
                        i++;
                    } else {
                        return str;
                    }
                } else {
                    str += change(b / 10);
                }
            }
        }
        return str;
    }


    public static char change(int num){
        return (char)(num+65-1);
    }
}
