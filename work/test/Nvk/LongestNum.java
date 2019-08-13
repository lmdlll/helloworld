package Nvk;

import java.util.Scanner;

/**字符串中找出连续最长的数字串
 * 输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
 输入：abcd12345ed125ss123456789
 输出：123456789,9

 8749r6k4nugdm04p5b1yhegi8hiq3937
 对应输出应该为: 87493937,4

 */

public class LongestNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            String str = in.nextLine();
            String result = "";
            String res= "";
            int max = 0;
            int count = 0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    res += String.valueOf(str.charAt(i));
                    count++;
                }else {
                    if(max<count){
                        max = count;
                        result = res;
                    }else if(max==count){
                        result += res;
                    }
                    res = "";
                    count = 0;
                }
            }
            if(max<count){
                result = res;
                max = count;
            }else if(max==count){
                result += res;
            }
            System.out.println(result+","+max);
        }
    }
}
