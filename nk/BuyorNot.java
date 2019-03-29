package Nvk;

import Node.List;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * [0-9] [a-z] [A-Z] 表示颜色
 * 例如：YrR8RrY是小红想做的珠串，ppRYYGrrYBR2258可以买 ppRYYGrrYB225不能买
 * 输出：如果可以买，在第一行输出“yes” 以及有多少多余的珠子；
 *      如果不能买，则在一行输出“No”以及缺了多少珠子
 *
 * eg：
 * 输入：
 * ppRYYGrrYBR2258
 * YrR8RrY
 * 输出：
 * Yes 8
 *
 */

public class BuyorNot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            String h = in.next();
            String w = in.next();
            contain(w,h);

        }

//        contain("YrR8RrY","ppRYYGrrYBR2258");

    }

    public static void contain(String w,String h){
        //1.使用LinkedList进行h珠串的存储
        LinkedList<Character> list = new LinkedList<>();
        for(int i=0; i<h.length(); i++){
            list.add(h.charAt(i));
        }
        //遍历想要的w字符串，一旦list中拥有，删除list的特定字符
        int count = 0;
        for(int i=0; i<w.length(); i++){
            for(int j=0; j<list.size(); j++) {
                if (w.charAt(i)==list.get(j)) {
                    list.remove(j);
                    count++;
                    break;
                }
            }
        }
        if(count==w.length()){
            System.out.println("Yes "+list.size());
        }else {
            System.out.println("No "+(w.length()-count));
        }

    }


    public static void code(){
        Scanner sc = new Scanner(System.in);
        String oldStr = sc.nextLine();
        String needStr = sc.nextLine();

        Map<Character,Integer> map = new HashMap<>();
        char[] chars = oldStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                int count = map.get(chars[i]);
                map.put(chars[i],count+1);
            }else {
                map.put(chars[i],1);
            }
        }

        char[] needChars = needStr.toCharArray();
        int lastCount = 0;
        for (int i = 0; i < needChars.length; i++) {
            if (map.containsKey(needChars[i])){
                if (map.get(needChars[i])>0){
                    int count = map.get(needChars[i]);
                    map.put(needChars[i],count-1);
                }else {
                    lastCount++;
                }
            }else {
                lastCount++;
            }
        }

        if (lastCount==0){
            System.out.println("Yes "+(oldStr.length()-needStr.length()));
        }else {
            System.out.println("No "+lastCount);
        }

    }
}
