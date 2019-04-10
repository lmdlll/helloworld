package Nvk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 说反话
 * 给定一句英语，将句中所有的单词顺序颠倒输出
 *
 * 输入：Hello World Here I Come
 * 输出：Come I Here World Hello
 */

public class opposite {
    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            String str = br.readLine();
//            Opp(str);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            String s = in.nextLine();
            Opp(s);
        }

    }
    public static void Opp(String str){
        str = str.trim();
        String[] data = str.split(" ");
        String result = "";
        for(int i=data.length-1; i>=0; i--){
            result += data[i]+" ";
        }
        result = result.trim();
        System.out.println(result);
    }
}
