package Leetcode.List;

//判断两个链表是否相交
public class XJnode {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(-2);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(0);
        ListNode n7 = new ListNode(5);

        n0.next = n3;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.println(xj(n1,n0));
    }
    //思路：看尾节点是否相等
    public static boolean xj(ListNode h1, ListNode h2){
        while (h1.next!=null){
            h1 = h1.next;
        }
        while (h2.next!=null){
            h2 = h2.next;
        }
        return h1==h2;
    }
}
