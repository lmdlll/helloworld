package Nvk;

import java.util.*;

/**
 * 找出以d或e结尾的单词出现的次数，以字典格式打印，其中不以d或e结尾的单词，不在结果统计中出现
 * 输入：
 * abc,head,tail,middle,head,today,tail,rain,end,cup,apple,abc,head,tail,middle,head,today,tail,rain,end,cup,apple,abc,head,tail,middle,head,today,tail,rain,end,cup,apple,abc,head,tail,middle,head,today,tail,rain,end,cup,apple,abc,head,tail,middle,head,today,tail,rain,end,cup,apple,hard,abc,head,tail,middle,head,today,tail,rain,end,cup,apple
 *
 * {head=12, apple=6, middle=6, end=6, hard=1}
 *
 */
public class FindStrEndCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ss = scanner.next();
            String[] data = ss.split(",");
            count(data);
        }
    }

    public static void count(String[] data){
        Map<String,Integer> map = new HashMap<>();
        for (int i=0; i<data.length; i++){
            int l = i== 1 ? 1:data[i].length()-1;
            if(data[i].charAt(l)=='e' ||data[i].charAt(l)=='d') {
                if (map.containsKey(data[i])) {
                    int len = map.get(data[i])+1;
                    map.put(data[i], len);
                }else {
                    map.put(data[i],1);
                }
            }
        }
        System.out.print("{");
        int l = map.size();
        for (Map.Entry<String, Integer> set : map.entrySet()){
            System.out.print(set.getKey()+"="+set.getValue());
            if(l!=1){
                System.out.print(", ");
            }
            l--;
        }
        System.out.println("}");
    }
}
