package Leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀.
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。

 */
class Test2{
    //3ms
    //思路：使用str的substring方法进行字符串的截取
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        String result = strs[0];
        for(int i=1; i<strs.length; i++){
            char[] tmp = result.toCharArray();
            char[] tmp2 = strs[i].toCharArray();
            //要小的
            int k = tmp.length>tmp2.length ? tmp2.length:tmp.length;
            result = result.substring(0,k);
            for(int j=0; j<k; j++) {
                if (tmp[j]!=tmp2[j]){
                    result = result.substring(0,j);
                    break;
                }
            }
        }
        return result;
    }

    //1ms
    public String longestCommonPrefix2(String[] strs) {
        String result="";
        if(strs.length==0){
            return "";
        }
        int minlength=strs[0].length();
        for(int i=0;i<strs.length;i++){
            if(minlength>strs[i].length()){
                minlength=strs[i].length();
            }
        }
        for(int i=0;i<minlength;i++){
            char s=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=s){
                    return result;
                }
            }
            result=result+s;
        }
        return result;
    }
}

public class STR2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        String[] strs = {"flower","flow","flight"};
        System.out.println(test2.longestCommonPrefix2(strs));

    }
}
