package Str;

import java.util.Stack;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */

public class Palindomstr {
    public static void main(String[] args) {
        String str = "0P";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        if(s==null || s.length()==1){
            return true;
        }

        char[] str = s.toLowerCase().toCharArray();
        int j=0;
        for(int i=0; i<str.length; i++){
            if(str[i]>='a' && str[i]<='z' || str[i]>=0 && str[i]<=9){
                str[j++] = str[i];
            }
        }
        char[] tmp = new char[j];
        for(int k=0; k<j; k++){
            tmp[k] = str[k];
        }
        str = tmp;
        if(str.length==1 || str==null || str.length==0){
            return true;
        }
        int mid = str.length/2;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<mid; i++){
            stack.push(str[i]);
        }
        if (str.length%2!=0){
            mid++;
        }
        while (mid<str.length && !stack.empty()){
            if(stack.peek()!=str[mid]){
                return false;
            }
            stack.pop();
            mid++;
        }

        return true;
    }

    //精妙啊~   14ms
    public boolean isPalindrome2(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }



}
