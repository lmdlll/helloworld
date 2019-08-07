package Leetcode.List;



/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 */
public class AddTwoNode {


    //9ms
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        if (l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode res = new ListNode(0);
        ListNode result = res;
        int falg = 0;
        while (l1!=null || l2!=null){
            int x = (l1!=null ? l1.val:0);
            int y = (l2!=null ? l2.val:0);
            int tmp = x+y+falg;
            res.next = new ListNode(tmp%10);
            falg = tmp/10;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
            res = res.next;
        }
        if(falg!=0){
            res.next = new ListNode(falg);
            res = res.next;
        }
        return result.next;
    }
}

