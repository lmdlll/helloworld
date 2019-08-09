package work;

import java.util.Set;

/**
 * 给定字符串s和单词字典dict，确定s是否可以被分割成一个或多个字典单词的间隔序列。
 * 例如，给定 s ="leetcode "、 dict =[“leet”，“code”]。 返回true，因为“leetcode”可以分割为“leet code”。
 * 理解有些问题，需要仔细查明……
 */
public class split {
    public static void main(String[] args) {

    }

    //网上看别人的思路，就是指
    // f(i) 表示s[0,i]是否可以分词
    // f(i) = f(j) && f(j+1,i); 0 <= j < i;
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] arrays = new boolean[dict.size()+1];
        arrays[0] = true;
        for (int i=1; i<s.length(); i++){
            for(int j=0; j<i; j++){
                //表示可以从第j个位置开始截取了，s.sustring(j,i)为从j截取到i-1
                if(arrays[j] && dict.contains(s.substring(j,i))){
                    arrays[i] = true;
                    break;
                }

            }

        }
        return arrays[s.length()];
    }

}
