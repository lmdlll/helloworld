package Leetcode;

import java.util.*;


/**
 * 1.给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */


/**
 * 2.如何判断链表带环
 */


class Test {
    //思路：使用Set进行增删查操作
    public int lengthOfLongestSubstring(String s) {
        s = s.toLowerCase();
        HashSet<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(chars[i])) {
                if (max < set.size()) {
                    max = set.size();
                }
                set.clear();
                set.add(chars[i]);
            } else {
                set.add(chars[i]);
            }

        }

        return max < set.size() ? set.size() : max;
    }


}

public class STR1 {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));


    }
}
