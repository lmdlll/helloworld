package Nvk;

import java.util.Scanner;
import java.util.Stack;

public class reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        if(in.hasNext()){
            str = in.nextLine();
        }
        System.out.println(rever(str));


    }
    public static String rever(String str){
        if(str.length()<=1){
            return str;
        }
        Stack<Character> stack = new Stack<>();
        String res = "";
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }
        while (!stack.empty()){
            res += stack.pop();
        }
        return res;
    }
}
