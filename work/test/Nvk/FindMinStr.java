package Nvk;

import java.util.*;

/**
 * 题目描述：
 * 小美和小团在玩一个游戏，小美任意给出一个大字符串str1以及一个独立的小字符串str2，
 * 小团需要从这个大字符串str1里找到包含独立小字符串str2中所有字符的最小子字符串str3；
 *
 * 例如，小美给出一个大字符串"meituan2019"和一个子字符串"i2t"，那么小团给出的答案就应该是"ituan2"；
 *
 * 需要注意：
 * 1、str1中有可能没有完整包含str2所有字符的情况，此时返回""；
 * 2、str1不会为空，但str2有可能为空，此时返回整个str1；
 * 3、str2可能存在重复的字符，此时str3需要包含相等数量该字符；
 *
 * 输入
 * 第一行，一个大字符串
 * 第二次，一个子字符串
 * 字符串长度不超过106
 *
 * 输出
 * 输出结果
 *
 * 样例输入
 * meituan2019
 * i2t
 * 样例输出
 * ​ituan2
 */
public class FindMinStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.nextLine();
            String str2 = in.nextLine();

            String result = "";
            if(str2==null){
                System.out.println(str1);
                return;
            }
            char[] stmp = str2.toCharArray();
            Arrays.sort(stmp);

            String s = str1;
            for (int i=0; i<stmp.length; i++){
                int l = str1.indexOf(stmp[i]);
                if(l==-1){
                    System.out.println();
                    return;
                }
                s = l+1<s.length()?s.substring(0,l)+s.substring(l+1,s.length()-1):"";
            }


            List<Integer> list = new ArrayList<>();
            for (int i=0; i<stmp.length; i++){
                int l = str1.indexOf(stmp[i]);
                list.add(l);
            }


            int max = Collections.max(list);
            int min = Collections.min(list);
            for (int i=min; i<=max; i++){
                result += str1.charAt(i);
            }
            System.out.println(result);


        }

    }
}
