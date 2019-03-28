package Nvk;


/**
 * 以给定值x为基准将链表分隔为两部分，所有小于x的结点排在大于或等于x的结点之前
 * 给定一个链表的头指针ListNode * pHead ，请返回重新拍了后的吧、链表的头指针
 *
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Listfg {

    //思路：两个链表，一个放小于，一个放大于等于
    public static ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode min = new ListNode(0);
        ListNode min1 = min;
        ListNode max = new ListNode(0);
        ListNode max1 = max;
        while (pHead!=null){
            if(pHead.val<x){
                min.next = new ListNode(pHead.val);
                min = min.next;
            }else {
                max.next = new ListNode(pHead.val);
                max = max.next;
            }
            pHead = pHead.next;
        }

        min.next = max1.next;
        return min1.next;

    }




    public ListNode partitioni(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null)
        {
            return pHead;
        }
        ListNode cur = pHead;
        ListNode Shead = new ListNode(-1);
        ListNode Bhead = new ListNode(-1);
        ListNode Stmp = Shead;
        ListNode Btmp = Bhead;
        while(cur != null){
            if(cur.val < x){
                Stmp.next = new ListNode(cur.val);
                Stmp = Stmp.next;
            }else{
                Btmp.next = new ListNode(cur.val);
                Btmp = Btmp.next;
            }
            cur = cur.next;
        }
        cur = Shead;
        while(cur.next != null && cur.next.val != -1){
            cur = cur.next;
        }
        cur.next = Bhead.next;
        return Shead.next;
    }



}
