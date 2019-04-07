package Nvk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 给定一个字符串，找出长度最长且不含有重复字符的子串，计算子串长度
 *
 * 输入：pwwkew
 * 输出：3
 */
public class LongNorep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            String str = in.next();
            System.out.println(Length(str));
        }
    }

    public static int Length(String str){
        int count = 0;
        int max = 0;
        HashSet set = new HashSet();
        for(int i=0; i<str.length(); i++){
            if(set.contains(str.charAt(i))){
                count = set.size();
                max = Math.max(count,max);
                set.clear();
                set.add(str.charAt(i));
            }else {
                set.add(str.charAt(i));
            }
        }
        max = Math.max(max,set.size());
        return max;
    }
}
