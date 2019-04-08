package Nvk;


/**
 * 两个链表，编写函数对这两个整数求和，并以链表形式返回结果
 * eg：
 * {1,2,3} {3,2,1}
 * 返回{4,4,4}
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

//TODO: 思路，再想想……
public class ListAdd {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(9);
        ListNode list2 = new ListNode(9);
        ListNode res = addTwoNumbers(list1,list2);
    }
    //未通过
    public static ListNode plusAB(ListNode a, ListNode b) {
        a = Reverse(a);
        b = Reverse(b);
        ListNode a1 = a;
        ListNode b1 = b;
        ListNode pre = null;
        ListNode node = null;
        int flag = 0;
        int a2 = 0;
        int b2 = 0;
        while (a1!=null || b1!=null){
            a2 = a1!=null ? a1.val:0;
            b2 = b1!=null ? b1.val:0;
            int tmp = a2+b2+flag;
            pre = node;
            node = new ListNode(tmp%10);
            node.next = pre;
            flag = tmp/10;
            a1 = a1!=null? a1.next:null;
            b1 = b1!=null? b1.next:null;
        }
        if(flag==1){
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        Reverse(a);
        Reverse(b);
        return node;
    }

    //设置一个反转链表方法
    public static ListNode Reverse(ListNode head){
        ListNode pre = null;
        ListNode fast = null;
        while (head!=null){
            fast = head.next;
            head.next = pre;
            pre = head;
            head = fast;
        }
        return pre;
    }


    //通过
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode  Node= new ListNode(0);
        ListNode p = Node;
        //设置一个标记位
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            sum = sum / 10;
            p = p.next;
        }
        return Node.next;
    }



}
