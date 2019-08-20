package Leetcode.List;

/**
 * 链表逆置
 */
public class Reverse {
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

        System.out.println(reverse(n1));
    }
    //定义两个指针，一个始终指向头部
    public static ListNode reverse(ListNode head){
        ListNode tail = null;
        while (head!=null){
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }
        return tail;
    }



}
