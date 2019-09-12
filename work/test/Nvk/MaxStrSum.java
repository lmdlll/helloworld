package Nvk;

import java.util.*;

/**
 * 统计字符串中的重叠子串长度之和
 *
 * 输入：
 * aaabcccaddfffaa
 * 输出：
 * a:5
 * c:3
 * f:3
 * d:2
 *
 */

class R{
    Character s;
    int i;
}
public class MaxStrSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        statisticSubStr(input);

    }

    public static void statisticSubStr(String s){
        Map<Character,Integer> map = new HashMap<>();
        boolean flag = false;
        int k = 1;
        for (int i=0; i<s.length(); i++){
            while (i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                i++;
                k++;
                flag = true;
            }
            if(flag) {
                if (map.containsKey(s.charAt(i))) {
                    int len = map.get(s.charAt(i)) + k;
                    map.put(s.charAt(i), len);
                } else {
                    map.put(s.charAt(i), k);
                }
            }
            flag = false;
            k = 1;
        }

        List<R> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> set : map.entrySet()){
            R r = new R();
            r.i = set.getValue();
            r.s = set.getKey();
            list.add(r);
        }
        list.sort(new Comparator<R>() {
            @Override
            public int compare(R o1, R o2) {
                if(o1.i>o2.i){
                    return -1;
                }else if(o1.i<o2.i){
                    return 1;
                }
                return 0;
            }
        });
        for (int i=0; i<list.size(); i++){
            R r = new R();
            r = list.get(i);
            System.out.println(r.s+":"+r.i);
        }

    }
}
