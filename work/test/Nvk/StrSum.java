package Nvk;


import java.util.*;

/**
 * 题目描述：
 * 英语老师看你老是在英语课上和周围同学交头接耳，所以给你布置了一份额外的家庭作业来惩罚惩罚你：
 * 你有一个字符串s，请你在s的所有子串中，找到出现次数最多的子串，告诉老师它的出现次数。
 *
 * 输入
 * 共一行，一个字符串s，仅由英文小写字母组成，1≤|s|≤10000。
 *
 * 输出
 * 一个正整数，表示最大出现次数。
 *
 *
 * 样例输入
 * aba
 * 样例输出
 * 2
 *
 * 提示
 * aba的所有子串为a、b、a、ab、ba、aba，其中a的出现次数最多，出现了2次。
 */
public class StrSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            for (int i=0; i<str.length(); i++){
                if(!map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),1);
                }else {
                    int count = map.get(str.charAt(i))+1;
                    map.put(str.charAt(i),count);
                }
            }

            //出现最多的
            int max = Collections.max(map.values());
            //最终的所有结果：
            Set<Character> set = new HashSet<>();
            for (Map.Entry<Character,Integer> entry:map.entrySet()){
                if(entry.getValue()==max){
                    set.add(entry.getKey());
                }
            }
//            System.out.println("出现最多的字母为："+set+"最多次数："+max);
            System.out.println(max);

        }



    }
}
