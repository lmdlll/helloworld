package Leetcode.List;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class CycleNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(hasCycle(n1));
    }
    //链表带环判断
    //设计两个标志，一个快，一个慢，他们总会相遇，当相遇就是带环
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

    //思路2：使用Set，突发奇想
    public static boolean hasCycle2(ListNode node) {
        Set<ListNode> set = new TreeSet<>();
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
