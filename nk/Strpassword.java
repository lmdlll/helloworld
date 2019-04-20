package Nvk;

import java.util.Scanner;

/** 字符串加密解密
 * 1.对输入的字符串进行加解密，输出
 * 2.加密方法：当是英文字母时，用该字母后一个字母替换，大写变小写，小写变大写
 * eg：a->B Z->a  0->1  1->2 9->0
 * 当是数字是，数字加1
 * 3.解密为加密逆序
 *
 */

public class Strpassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str1 = in.next();
            String str2 = in.next();
            char[] tmp1 = str1.toCharArray();
            char[] tmp2 = str2.toCharArray();
            Encrypt(tmp1);
            unEncrypt(tmp2);
        }
//        Encrypt(new char[]{'a','b','c','z','1','0','9'});
//        unEncrypt(new char[]{'B','C','D','A','2','1','0'});
    }
    //加密
    public static void Encrypt(char[] str){
        char[] result = new char[str.length];
        int j=0;
        for(int i=0; i<str.length; i++){
            if(str[i]>='a' && str[i]<='z'){
                if(str[i]=='z'){
                    result[j++] = 'A';
                }else {
                    result[j++] = (char) (str[i]+1-32);
                }

            }else if (str[i]>='A' && str[i]<='Z'){
                if(str[i]=='Z'){
                    result[j++] = 'a';
                }else {
                    result[j++] = (char) (str[i]+1+32);
                }
            }else if(str[i]>='0' && str[i]<='9') {
                if (str[i] == '9') {
                    result[j++] = '0';
                } else {
                    result[j++] = (char) (str[i] + 1);
                }
            }

        }
        String res = "";
        for(int i=0; i<result.length; i++){
            res += result[i];
        }
        System.out.println(res);
    }
    //解密
    public static void unEncrypt(char[] str){
        char[] result = new char[str.length];
        int j=0;
        for(int i=0; i<str.length; i++){
            if(str[i]>='a' && str[i]<='z'){
                if(str[i]=='a'){
                    result[j++] = 'Z';
                }else {
                    result[j++] = (char) (str[i]-1-32);
                }

            }else if (str[i]>='A' && str[i]<='Z'){
                if(str[i]=='A'){
                    result[j++] = 'z';
                }else {
                    result[j++] = (char) (str[i]-1+32);
                }
            }else if(str[i]>='0' && str[i]<='9') {
                if (str[i] == '0') {
                    result[j++] = '9';
                } else {
                    result[j++] = (char) (str[i] - 1);
                }
            }
        }
        String res = "";
        for(int i=0; i<result.length; i++){
            res += result[i];
        }
        System.out.println(res);
    }

    public static char encryption(char c){
        if(c >= 'a' && c < 'z')
            return (char)(c + 1 - 32);
        else if(c == 'z')
            return 'A';
        else if(c >= 'A' && c < 'Z')
            return (char)(c + 1 + 32);
        else if(c == 'Z')
            return 'a';
        else if(c >= '0' && c < '9')
            return (char)(c + 1);
        else if(c == '9')
            return '0';
        else
            return c;
    }

    public static char decryption(char c){
        if(c > 'a' && c <= 'z')
            return (char)(c - 1 - 32);
        else if(c == 'a')
            return 'Z';
        else if(c > 'A' && c <= 'Z')
            return (char)(c - 1 + 32);
        else if(c == 'A')
            return 'z';
        else if(c > '0' && c <= '9')
            return (char)(c - 1);
        else if(c == '0')
            return '9';
        else
            return c;
    }

    public static String enCryption(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(encryption(cs[i]));
        }
        return sb.toString();
    }

    public static String deCryption(String s){
        char[] cs = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i++){
            sb.append(decryption(cs[i]));
        }
        return sb.toString();
    }

}
