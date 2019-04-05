package Nvk;

import java.util.Scanner;

/**
 * 密码验证合格程序
 * 密码要求：
 * 1.长度超过8位
 * 2.包括大小写字母、数字、其他符号，以上四种至少三种
 * 3.不能有相同长度超过2的子串重复
 *
 * 输入要求：一组或多组长度超过2的字符串
 * 输出要求：OK，否则输出NG
 *
 * eg：
 * 输入：
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出：
 * OK
 * NG
 * NG
 * OK
 *
 */

public class Password {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            System.out.println(passwd(str));
        }

    }

    public static String passwd(String str){
        //长度大于8
        if(str.length()<=8 || str==null){
            return "NG";
        }
        //包括三种以上
        int num = 0, big = 0, small = 0, other = 0;
        char[] ch = str.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(ch[i]>='a' && ch[i]<='z'){
                small = 1;
            }else if(ch[i]>='A' && ch[i]<='Z'){
                big = 1;
            }else if(ch[i]>='0' && ch[i]<='9'){
                num = 1;
            }else {
                other = 1;
            }

        }
        if(num+big+small+other<3){
            return "NG";

        }
        //不能有长度相同超过2的子串
        for(int i=0; i<ch.length-2; i++){
            String tmp = str.substring(i,i+3);
            if(str.substring(i+1).contains(tmp)){
                return "NG";
            }
        }
        return "OK";

    }

}

/**
 *  NG OK OK NG OK OK OK NG NG OK OK OK OK OK OK OK OK OK OK OK NG OK OK
 * NG OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK OK NG NG OK OK OK OK


 OK
 OK
 OK
 NG
 OK
 OK
 OK

 */