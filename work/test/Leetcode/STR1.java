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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 2.如何判断链表带环
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

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

    //链表带环判断
    //设计两个标志，一个快，一个慢，他们总会相遇，当相遇就是带环
    public boolean hasCycle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast != null && slow != null) {
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    //思路2：使用Set，突发奇想
    public boolean hasCycle2(ListNode node) {
        Set<ListNode> set = new HashSet<>();
        ListNode n = node;
        while (n!=null){
            if(set.contains(n)){
                return true;
            }
            set.add(n);
            n = n.next;
        }
        return false;
    }
}

public class STR1 {
    public static void main(String[] args) {
        Test test = new Test();
//        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(test.lengthOfLongestSubstring("bbbbbb"));
//        System.out.println(test.lengthOfLongestSubstring("pwwkew"));

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(test.hasCycle(n1));

    }
}
