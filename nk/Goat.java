package Array;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
 * 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
 * 山羊拉丁文的规则如下：
 * 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
 *
 * 例如，单词"apple"变为"applema"。
 * 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词"goat"变为"oatgma"。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
 * 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
 * 返回将 S 转换为山羊拉丁文后的句子。
 *
 * 示例 1:
 * 输入: "I speak Goat Latin"
 * 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 * 示例 2:
 * 输入: "The quick brown fox jumped over the lazy dog"
 * 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * 说明:
 *
 * S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
 * 1 <= S.length <= 150。
 */

public class Goat {
    public static void main(String[] args) {
//        String str = "I speak Goat Latin";
 //       //Imaa peaksmaaa oatGmaaaa atinLmaaaaa
//        System.out.println(toGoatLatin(str));
//        String str = "The quick brown fox jumped over the lazy dog";
//        //Imaa peaksmaaa oatGmaaaa atinLmaaaaa
//        System.out.println(toGoatLatin(str));
        String str2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(str2));

    }
    public static String toGoatLatin(String S) {
        if(S.length()>150 || S.length()<0){
            return S;
        }
        String str = "a";
        String aei = "aeiouAEIOU";
        String result = "";
        String[] data = S.split(" ");
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<data.length; i++) {
            int tmp = 0;
            if (data[i].startsWith(String.valueOf('a')) ||
                    data[i].startsWith(String.valueOf((char)('a'-32))) ||
                    data[i].startsWith(String.valueOf('e')) ||
                    data[i].startsWith(String.valueOf((char)('e'-32))) ||
                    data[i].startsWith(String.valueOf('i')) ||
                    data[i].startsWith(String.valueOf((char)('i'-32))) ||
                    data[i].startsWith(String.valueOf('o')) ||
                    data[i].startsWith(String.valueOf((char)('o'-32))) ||
                    data[i].startsWith(String.valueOf('u')) ||
                    data[i].startsWith(String.valueOf((char)('u'-32)))){
                    result += data[i] + "ma";
                    result += str;
                    if (i != data.length - 1) {
                        result += " ";
                    }
                    //              result += str + " ";
                    str += "a";
                    break;
                }
                else {
                    for (int k = 0; k < data[i].length(); k++) {
                        queue.add(data[i].charAt(k));
                    }
                    char ch = queue.poll();
                    String ls = "";
                    while (!queue.isEmpty()) {
                        ls += String.valueOf(queue.poll());
                    }
                    result += ls + String.valueOf(ch) + "ma";
                    result += str;
                    if (i != data.length - 1) {
                        result += " ";
                    }
                    str += "a";
                    break;
                }
            }
        return result;
    }

    public static String toGoatLating(String S) {
        String vowelMap = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        char pre = '0';
        String taile = "maa";
        boolean isBegin = true;
        for(int i = 0;i<S.length();i++){
            if(S.charAt(i) == ' '){
                if(pre != '0')
                    sb.append(pre);
                sb.append(taile);
                sb.append(' ');
                taile += "a";
                pre = '0';
                isBegin = true;
            }
            else if(isBegin){
                isBegin = false;
                if(vowelMap.indexOf(S.charAt(i)) < 0){
                    pre = S.charAt(i);
                }
                else{
                    sb.append(S.charAt(i));
                }
            }
            else{
                sb.append(S.charAt(i));
            }
        }

        if(pre != '0')
            sb.append(pre);
        sb.append(taile);
        return sb.toString();
    }
}
