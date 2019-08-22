package Leetcode.List;

import java.util.*;

//链表带环判断
public class CycleNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(0);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(hasCycle2(n1));

    }
    // 1ms 设计两个标志，一个快，一个慢，他们总会相遇，当相遇就是带环
    public static boolean hasCycle(ListNode node) {
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

    // 14ms 思路2：使用Set，突发奇想
    public static boolean hasCycle2(ListNode node) {
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
