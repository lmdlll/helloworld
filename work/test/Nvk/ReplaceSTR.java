package Nvk;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSTR {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world ");
        System.out.println(replaceSpace1(str));
        System.out.println(replaceSpace2(str));
        System.out.println(replaceSpace3(str));

    }
    //思路：使用自带的方法
    public static String replaceSpace1(StringBuffer str) {
        return str.toString().replaceAll(" ","%");
    }

    //思路：重新写一个变量，遇到空格加上%20，其他直接赋值
    public static String replaceSpace2(StringBuffer str) {
        String result = "";
        for (int i=0; i<str.length(); i++){
            if(str.charAt(i)==' '){
                result += "%20";
            }else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    //在原字符串上进行替换
    //思路：首先找到有几个空格，然后进行str的长度扩容，最后进行字符的替换/后移
    public static String replaceSpace3(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold = str.length()-1; //indexold为为替换前的str下标
        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
        int indexnew = newlength-1;//indexnew为为把空格替换为%20后的str下标

        //使str的长度扩大到转换成%20之后的长度,防止下标越界
        str.setLength(newlength);
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }
}
