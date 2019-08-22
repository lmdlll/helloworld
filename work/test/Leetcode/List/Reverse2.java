package Leetcode.List;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 输入：1->2->3->4->5->6->7->8->NULL, m = 3, n = 7
 * 输出：1->2->7->6->5->4->3->8->NULL
 *
 */

public class Reverse2 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        System.out.println(reverseBetween(n1,3,7));
    }

    //别人的思路，debug进入查看了一番，感觉自己有点难想到

    /**
     * 1  2  3  4  5  6  7  8
     * 1  2  4  3  5  6  7  8
     * 1  2  5  4  3  6  7  8
     * 1  2  6  5  4  3  7  8
     * 1  2  7  6  5  4  3  8
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        //找到m的前一个
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        //不断交换net与head.next的位置
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return res.next;
    }




}
