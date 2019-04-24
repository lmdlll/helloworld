 //查找兄弟单词
// 这个题目的题意一定要搞清楚
// 兄弟单词的含义: 两个单词不同, 长度相同, 但是构成的字母顺序不相同
// 输入描述:
// 先输入字典中单词的个数n，再输入n个单词作为字典单词。
// 再输入一个单词，查找其在字典中兄弟单词的个数m
// 再输入数字k
// 输出描述:
// 根据输入，输出查找到的兄弟单词的个数m
// 然后输出查找到的兄弟单词的第k个单词。
// 注意!! 一定要关注最终返回的第 k 个单词这样的序号, 不能搞错.
//调试了很久，通过50%，因为忽视了一个关键点，字典元素一定要排序
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
public static void main(String[] args) {
Scanner in = new Scanner(System.in);
while(in.hasNext()){
int num = in.nextInt();
String[] s = new String[num];
int count = 0;
for(int i = 0;i<num;i++){
s[i] = in.next();
}
String key = in.next();
char[] keyChar = key.toCharArray();
Arrays.sort(keyChar);
int no = in.nextInt();//第几个
ArrayList<String> list = new ArrayList<String>();
for(int i = 0;i<num;i++){
int c = check(key,s[i],keyChar);
count += c;
if(c==1)
list.add(s[i]);
}
System.out.println(count);
Collections.sort(list);
if(count>=no)
System.out.println(list.get(no-1));
}
}
// 核心的比较函数. keyChar 在调用的时候就已经排好序了.
private static int check(String key,String word,char[] keyChar){
// 就是将两个单词按字符排序后看相不相同就行了.
if(key.equals(word)||key.length()!=word.length())
return 0;
char[] wordChar = word.toCharArray();
Arrays.sort(wordChar);
return Arrays.equals(keyChar, wordChar)?1:0;
}
}
