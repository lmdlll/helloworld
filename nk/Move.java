package Nvk;

import java.util.Scanner;

/** 坐标移动
 * A->左  D->右  W->上  S->下
 * 从0,0开始移动，从输入字符串读取坐标，输出结果
 * A10;S20;W10;D30;X;A1A;B10A11;;A10
 * 0,0 +A10 -> -10,0 +S20 ->-10,-20 +W10->-10,-10+D30->20,-10
 * X无效 +A1A ->无效 +B10A11->无效 +A10->10，-10
 *
 */

public class Move {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            String str = in.nextLine();
            String[] tmp = str.split(";");
            int x = 0;
            int y = 0;
            for(int i=0; i<tmp.length; i++){
                /**
                 * public boolean matches(String regex)告诉这个字符串是否匹配给定的regular expression 。
                 * 这种形式为str .matches( regex )方法的)产生与表达式完全相同的结果
                 * Pattern. matches(regex, str)
                 * 参数  regex - 要匹配此字符串的正则表达式
                 * 结果  true 如果，并且只有这个字符串与给定的正则表达式匹配
                 */
                //开始不会判断数字的包含，网上查找知道正则表达式
                if(tmp[i].charAt(0)=='A' && tmp[i].substring(1).matches("[0-9]+")){
                    x -= Integer.valueOf(tmp[i].substring(1));
                }
                if(tmp[i].charAt(0)=='D' && tmp[i].substring(1).matches("[0-9]+")){
                    x += Integer.valueOf(tmp[i].substring(1));
                }
                if(tmp[i].charAt(0)=='W' && tmp[i].substring(1).matches("[0-9]+")){
                    y += Integer.valueOf(tmp[i].substring(1));
                }
                if(tmp[i].charAt(0)=='S' && tmp[i].substring(1).matches("[0-9]+")){
                    y -= Integer.valueOf(tmp[i].substring(1));
                }

            }
            System.out.println(x+","+y);
        }



    }
}
