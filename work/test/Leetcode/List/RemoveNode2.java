package Leetcode.List;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 */
public class RemoveNode2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;


        ListNode res = deleteDuplicates2(l1);
    }

    //2ms 思路：定义两个指针，一个指向当前节点，一个指向结果链表的下一个节点
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = head;
        ListNode last = res;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                last.next = cur;
            } else{
                last = cur;
                cur = cur.next;
            }
        }
        return res.next;
    }

    //1ms  递归
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head==null || head.next==null){
            return head;
        }
        if (head.val == head.next.val) {
            ListNode start = head;
            while(start.val==head.val) {
                head = head.next;
                if (head==null) return null;
            }
            return deleteDuplicates2(head);
        }
        head.next = deleteDuplicates2(head.next);
        return head;
    }

}
