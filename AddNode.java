package Node;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class AddNode {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
// //理解错误，重新来
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        while (l1==null){
//            return l2;
//        }
//        while (l2==null){
//            return l1;
//        }
//        ListNode result = new ListNode(0);
//        ListNode res = result;
//        while(l1!=null && l2!=null) {
//            int tmp = l1.val+l2.val;
//            if(tmp>10){
//                result.next = new ListNode(tmp/10);
//                tmp /= 10;
//
//            }
//            result.next = new ListNode(tmp);
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        if(l1!=null){
//            result.next = l1;
//            l1 = l1.next;
//            result = result.next;
//        }
//        result = res.next;
//        return result;
//    }
////继续。。。
//    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
//        while (l1==null){
//            return l2;
//        }
//        while (l2==null){
//            return l1;
//        }
//        ListNode result = new ListNode(0);
//        ListNode res = result;
//        int flag = 0;
//        while(l1!=null && l2!=null) {
//            int tmp = l1.val+l2.val;
//            if(tmp>=10){
//                result.next = new ListNode(tmp%10+flag);
//                result = result.next;
//                l1 = l1.next;
//                l2 = l2.next;
//                flag=1;
//                continue;
//            }
//            result.next = new ListNode(tmp+flag);
//            l1 = l1.next;
//            l2 = l2.next;
//            result = result.next;
//            flag = 0;
//        }
//        if(l1!=null){
//            result.next = l1;
//            l1 = l1.next;
//            result = result.next;
//        }
//        if(l2!=null){
//            result.next = l2;
//            l2 = l2.next;
//            result = result.next;
//        }
//        result = res.next;
//        return result;
//    }
//
////成功，但耗时久  54ms
//    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
//        while (l1==null){
//            return l2;
//        }
//        while (l2==null){
//            return l1;
//        }
//        ListNode result = new ListNode(0);
//        ListNode res = result;
//        int flag = 0;
//        while(l1!=null || l2!=null) {
//            int x = (l1!=null) ? l1.val : 0;
//            int y = (l2!=null) ? l2.val : 0;
//            int tmp = x+y+flag;
//            result.next = new ListNode(tmp%10);
//            flag = tmp/10;
//            if(l1!=null) {
//                l1 = l1.next;
//            }
//            if (l2!=null) {
//                l2 = l2.next;
//            }
//            result = result.next;
//        }
//        if (flag!=0){
//            result.next = new ListNode(flag);
//            result = result.next;
//        }
//        return res.next;
//    }
//
////27ms
//    public ListNode addTwoNumbersi(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(0);
//        ListNode p = l1, q = l2, curr = dummyHead;
//        int carry = 0;
//        while (p !=null || q !=null) {
//            int x = (p != null ? p.val : 0);
//            int y = (q != null ? q.val : 0);
//            int sum = carry + x + y;
//            carry = sum / 10;
//            curr.next = new ListNode(sum % 10);
//            curr = curr.next;
//            if (p != null) p = p.next;
//            if (q != null) q = q.next;
//        }
//        if (carry > 0) {
//            curr.next = new ListNode(carry);
//        }
//        return dummyHead.next;
//    }
}
