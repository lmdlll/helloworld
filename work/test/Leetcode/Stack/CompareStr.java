package Leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

/**比较含退格的字符
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 示例 1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例 2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例 3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 示例 4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 *
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 */

public class CompareStr {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));
    }
    //8ms 使用两个栈进行数据的存储
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> tt = new Stack<>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)!='#'){
                ss.add(S.charAt(i));
            }else {
                if(!ss.isEmpty()) {
                    ss.pop();
                }
            }
        }
        for(int i=0; i<T.length(); i++){
            if(T.charAt(i)!='#'){
                tt.add(T.charAt(i));
            }else {
                if (!tt.isEmpty()) {
                    tt.pop();
                }
            }
        }
        return ss.equals(tt);
    }

    //1ms 利用数组进行操作
    public static boolean backspaceCompare2(String S, String T) {
        char[] ss = S.toCharArray();
        char[] tt = T.toCharArray();
        int pos = 0;
        for (int i=0; i<ss.length; i++){
            char ch = ss[i];
            if (ch == '#') {
                pos--;
                pos = pos<0 ? 0:pos ;
            }else {
                ss[pos] = ch;
                pos++;
            }
        }

        int pos2 = 0;
        for (int i=0; i<tt.length; i++){
            char ch = tt[i];
            if (ch == '#') {
                pos2--;
                pos2 = pos2 < 0 ? 0 : pos2;
            }else {
                tt[pos2] = ch;
                pos2++;
            }
        }
        //如果长度不相等
        if(pos != pos2){
            return false;
        }
        for(int i = 0;i<pos;i++){
            if(ss[i] != tt[i]){
                return false;
            }
        }
        return true;
    }

}
