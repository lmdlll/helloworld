package work;

import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;

/**
 * 反转整数
 * 123 -> 321
 * -123 -> -321
 * 120 -> 21
 *
 */

//字符串反转
class WayToRevStr{
    //使用StringBuffer的reverse()
    public static String Reverse1(String str){
        StringBuffer tmp = new StringBuffer(str);
        return tmp.reverse().toString();
    }
    //使用StringBuffer的reverse()
    public static String Reverse2(String str) {
        StringBuilder tmp = new StringBuilder(str);
        return tmp.reverse().toString();
    }
    //使用循环
    public static String Reverse3(String str){
        String tmp = "";
        char[] s = str.toCharArray();
        for(int i=s.length-1; i>0; i--){
            tmp += s[i];
        }
        return tmp;
    }
    //使用栈
    public static String Reverse4(String str) {
        Stack stack = new Stack();
        String res = null;
        char[] s = str.toCharArray();
        for(int i=0; i<s.length; i++){
            stack.push(s[i]);
        }
        while (!stack.empty()){
            res += stack.peek();
            stack.pop();
        }
        return res;
    }

}

public class ReverseNum {
    public static void main(String[] args) {
        System.out.println(reverse(-120));
    }
    public static int reverse(int num){
        int flag = -1;
        if(num*flag!=num){//是负数
            flag=-1;
            num *= flag;
        }
        StringBuffer temp = new StringBuffer(String.valueOf(num));
        StringBuffer res = temp.reverse();
        char[] ls = res.toString().toCharArray();
        int result;
        if(ls[0]=='0'){
            result = Integer.parseInt(res.toString().substring(1,res.length()));
        }else {
            result = Integer.parseInt(res.toString());
        }
        return result*flag;
    }

}
