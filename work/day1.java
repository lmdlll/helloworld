package work;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.从用户输入的字符串中找到重复次数最多的字符，并输出字符与重复的次数
 * 2.查找输入的字符串中指定的字符串，并输出首字符的位置
 * 3.将多个字符串拼接，每两个字符串间以：间隔
 *
 */
class Test1 {
    //题一：  思路1：HashMap
    public void cf(String str) {
        Map<Character, Integer> map = new HashMap();
        //保证出现最多的是字符而非字符串
        str = str.replace(" ", "");
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                int tmp = map.get(chars[i]) + 1;
                map.put(chars[i], tmp);
            } else {
                map.put(chars[i], 1);
            }
        }
        int max = 0;
        char res = chars[0];
        for (int i = 0; i < chars.length; i++) {
            if (max < map.get(chars[i])) {
                res = chars[i];
                max = map.get(res);
            }
        }
        System.out.println("出现次数最多的字符：" + res);
        System.out.println("出现次数：" + max);
    }

    //题一：  思路2：使用排除法
    public void cf2(String str) {
        int count = 0, len = 0, max = 0;
        str = str.replace(" ", "");
        char s = str.toCharArray()[0];
        while (true) {
            char name[] = str.toCharArray();
            len = name.length;
            count = 0;
            //跳出循环
            if (len == 0) {
                break;
            }
            for (int j = 0; j < len; j++) {
                if (name[0] == name[j]) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                s = name[0];
            }
            str = str.replace(String.valueOf(name[0]), "");
        }
        System.out.println("出现次数最多的字符：" + s);
        System.out.println("出现次数：" + max);
    }

    //题二：  思路：
    public void szf(String str, String s) {
        if (!str.contains(s)) {
            System.out.println(str + "不包含字符串" + s);
            return;
        }
        int flag = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int tmp = i;
            if(flag!=0){
                System.out.println(flag);
                break;
            }
            for(int j=0; j<s.length(); j++){
                if(chars[tmp]==s.charAt(j)){
                    tmp++;
                    flag = i;
                }else {
                    flag = 0;
                    break;
                }
            }
        }

    }

    //题三：  方法1：String
    public void pj(String[] tmp) {
        int count = 0;
        String result = "";
        for (int i = 0; i < tmp.length; i++) {
            if (count == 2) {
                count = 1;
                result += ":" + tmp[i];
            } else {
                result += tmp[i];
                count++;
            }
        }
        System.out.println(result);
    }

}

public class day1 {
    public static void main(String[] args) {
        String str = "th aaaaaaa";
        Test1 test1 = new Test1();
        test1.cf(str);
        test1.cf2(str);
        test1.szf("abcsdabcds","abcd");
        test1.pj(new String[]{"asdf","adfsdfb","asfv","sfgns","asdvg"});

    }
}
