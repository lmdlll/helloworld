package Leetcode.List;



/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class HBNode {
    //2ms
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode result =res;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }
        if (l1!=null){
            res.next = l1;
        }
        if (l2!=null){
            res.next = l2;
        }
        return result.next;
    }

    //1ms
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            p.next = l1;
        }

        if(l2!=null){
            p.next = l2;
        }
        return head.next;
    }
}
