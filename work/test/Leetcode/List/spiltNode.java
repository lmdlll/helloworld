package Leetcode.List;

/** 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 *
 */
public class spiltNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(0);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;


        ListNode res = partition1(l1,3);
    }

    // 2ms  思路：创建两个链表，一个保存小于，一个保存大于等于，最后合并
    public static ListNode partition1(ListNode head, int x) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode b = big;
        ListNode s = small;
        while (head!=null){
            if(head.val<x){
                small.next = head;
                head = head.next;
                small = small.next;
                small.next = null;
            }else {
                big.next = head;
                head = head.next;
                big = big.next;
                big.next = null;
            }
        }
        small.next = b.next;
        return s.next;

    }

    //1ms
    public static ListNode partition2(ListNode head, int x) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode curr1 = head;
        ListNode prev1 = dummy1;
        ListNode prev2 = dummy2;
        while(curr1 != null){
            if(curr1.val < x) {
                prev1.next = curr1;
                prev1 = curr1;
                curr1 = curr1.next;
            }else {
                prev2.next = curr1;
                prev2 = curr1;
                curr1 = curr1.next;
            }
        }
        prev1.next = dummy2.next;
        prev2.next = null;
        return dummy1.next;
    }


}
