 //�����ֵܵ���
// �����Ŀ������һ��Ҫ�����
// �ֵܵ��ʵĺ���: �������ʲ�ͬ, ������ͬ, ���ǹ��ɵ���ĸ˳����ͬ
// ��������:
// �������ֵ��е��ʵĸ���n��������n��������Ϊ�ֵ䵥�ʡ�
// ������һ�����ʣ����������ֵ����ֵܵ��ʵĸ���m
// ����������k
// �������:
// �������룬������ҵ����ֵܵ��ʵĸ���m
// Ȼ��������ҵ����ֵܵ��ʵĵ�k�����ʡ�
// ע��!! һ��Ҫ��ע���շ��صĵ� k ���������������, ���ܸ��.
//�����˺ܾã�ͨ��50%����Ϊ������һ���ؼ��㣬�ֵ�Ԫ��һ��Ҫ����
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
int no = in.nextInt();//�ڼ���
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
// ���ĵıȽϺ���. keyChar �ڵ��õ�ʱ����Ѿ��ź�����.
private static int check(String key,String word,char[] keyChar){
// ���ǽ��������ʰ��ַ�������಻��ͬ������.
if(key.equals(word)||key.length()!=word.length())
return 0;
char[] wordChar = word.toCharArray();
Arrays.sort(wordChar);
return Arrays.equals(keyChar, wordChar)?1:0;
}
}
