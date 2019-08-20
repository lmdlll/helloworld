package Leetcode.List;

/**
 * 删除链表倒数第k个节点
 * 要求：只遍历一次
 *
 */
public class RemoveDsK {
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

        System.out.println(remove(n1,1));
    }

    //思路：设计两个指针，快的先走k步，当fast.next==null的时候，slow.next就是要删除的节点
    public static ListNode remove(ListNode head,int k){
        if(head==null || k==1&&head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (k!=0 && fast!=null){
            fast = fast.next;
            k--;
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
