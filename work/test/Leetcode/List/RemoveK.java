package Leetcode.List;

/**
 * 删除链表中指定的值
 *
 */

public class RemoveK {
    //1.先判断除了第一个
    public static ListNode remove1(ListNode head, int k){
        if(head==null){
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur!=null){
            if(cur.val==k){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        if (head.val==k){
            return head.next;
        }
        return head;
    }



    //2.创建一个新链表，将与之不相同的节点放到新建的链表中
    public static ListNode remove2(ListNode head, int k){
        if (head==null){
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode result = res;
        while (head!=null){
            if(head.val!=k){
                res.next = new ListNode(head.val);
                res = res.next;
            }
            head = head.next;
        }
        return result.next;
    }

    //3.创建一个新链表
    public static ListNode remove3(ListNode head, int k){
        if (head==null){
            return head;
        }

        return head;
    }

}
