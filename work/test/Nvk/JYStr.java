package Nvk;

import java.util.*;

/**
 * HG[3|B[2|CA]]F
 *
 * HGBCACABCACABCACAF
 * HGBCACABCACABCACAF
 * HGBCACABCACABCACAF
 * HGBCACABCACABCACABCACAF
 *
 */
public class JYStr {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            String str = in.nextLine();
//            compute(str);
//        }
        compute2("HG[3|B[2|CA]]F");
    }
    public static void compute(String str){
        char[] tmp = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int start = str.indexOf("[");
        int count = 1;
        int end = 0;
        for (int i=start+1; i<str.length(); i++){
            stack.push(tmp[i]);
            if (tmp[i]=='['){
                count++;
            }else if(tmp[i]==']' && count!=1){
                count--;
            }else if(tmp[i]==']' && count==1){
                end = i;
                break;
            }
        }
        StringBuilder ls = new StringBuilder();
        StringBuilder ss = new StringBuilder();
        while (!stack.empty()){
            if(String.valueOf(stack.peek()).equals("|")){
                stack.pop();
                String num = "";
                String aa = ss.reverse().append(ls).toString();
                while (stack.peek()!='['){
                    num+=stack.pop();
                    if(stack.empty()){
                        break;
                    }
                }
                if (!stack.empty()) {
                    stack.pop();
                }
                num = new StringBuilder(num).reverse().toString();
                for(int i=Integer.valueOf(num)-1; i>0; i--){
                    ss.append(aa);
                }
                ls = ss;
                ss = new StringBuilder();
            }else if(String.valueOf(stack.peek()).equals("]")){
                stack.pop();
                continue;
            } else {
                ss.append(stack.pop());
            }
        }
        String result = str.substring(0,start)+ls+str.substring(end+1,str.length());
        System.out.println(result);
    }

    public static void compute2(String str){
        char[] tmp = str.toCharArray();
        char[] stack = new char[str.length()];
        int start = str.indexOf("[");
        int count = 1;
        int end = 0;
        int j=0;
        for (int i=start+1; i<str.length(); i++){
            stack[j++]= tmp[i];
            if (tmp[i]=='['){
                count++;
            }else if(tmp[i]==']' && count!=1){
                count--;
            }else if(tmp[i]==']' && count==1){
                end = i;
                break;
            }
        }
        char[] aaa = new char[j];
        System.arraycopy(stack,0,aaa,0,j);
        stack = aaa;
        StringBuilder ls = new StringBuilder();
        StringBuilder ss = new StringBuilder();
        int len = stack.length-1;
        while (len!=0){
            if(String.valueOf(stack[len]).equals("|")){
                len--;
                String num = "";
                String aa = ss.reverse().append(ls).toString();
                while (stack[len]!='['){
                    num+=stack[len--];
                    if(len==0){
                        break;
                    }
                }
                if (len!=0) {
                    len--;
                }
                num = new StringBuilder(num).reverse().toString();
                for(int i=Integer.valueOf(num)-1; i>0; i--){
                    ss.append(aa);
                }
                ls = ss;
                ss = new StringBuilder();
            }else if(String.valueOf(stack[len]).equals("]")){
                len--;
                continue;
            } else {
                ss.append(stack[len--]);
            }
        }
        String result = str.substring(0,start)+ls+str.substring(end+1,str.length());
        System.out.println(result);
    }



    public static void compute2() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder t = new StringBuilder("");
        int num = 0;
        Deque<Integer> stackNum = new ArrayDeque<>();
        Deque<StringBuilder> stackStr = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = 10 * num + c - '0';
            }else if(c == '['){
                stackStr.push(t);
                t = new StringBuilder("");
            }else if(c == '|'){
                stackNum.push(num);
                num = 0;
            }else if(c == ']'){
                int n = stackNum.pop();
                StringBuilder sb = stackStr.pop();
                for(int j = 0; j < n; j++){
                    sb.append(t);
                }
                t = sb;
            }else{
                t.append(c);
            }
        }
        System.out.println( t.toString());
    }
}


