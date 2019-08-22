package Leetcode.List;

//判断两个链表是否相交,如果相交，相交的节点是哪一个
public class XJnode2 {
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

        System.out.println(center(n1,n0));
    }

    //思路：1.先判断，2.减去长的链表步数,同时向后进行遍历，遇到相同返回
    public static ListNode center(ListNode h1,ListNode h2){
        if(!XJnode.xj(h1,h2)){
            return null;
        }
        ListNode n1 = h1;
        ListNode n2 = h2;
        int count1 = 0;
        while (h1!=null){
            count1++;
            h1 = h1.next;
        }
        int count2 = 0;
        while (h2!=null){
            count2++;
            h2 = h2.next;
        }

        //
        if(count1>count2){
            int len = count1-count2;
            while (len>0){
                n1 = n1.next;
                len--;
            }
        }else {
            int len = count2-count1;
            while (len>0){
                n2 = n2.next;
                len--;
            }
        }
        while (n1!=null){
            if(n1.next==n2.next){
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return n2.next;
    }

}
