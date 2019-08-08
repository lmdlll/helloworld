package Leetcode.List;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 *
 */
public class CycleNode2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;


        ListNode res = detectCycle(l1);
    }

    //17ms 思路1：使用Set进行判断与标记
    public static ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    //1ms 思路2：使用快慢指针进行判断 是环的话查找开始节点，从头开始遍历，最终一定是slow==head
    public static ListNode detectCycle2(ListNode head){
        if(head==null || head.next==null){
            return null;
        }
        // 步骤一：使用快慢指针判断链表是否有环
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        // 步骤二：若有环，找到入环开始的节点
        if (flag) {
            ListNode q = head;
            while (slow != q) {
                slow = slow.next;
                q = q.next;
            }
            return q;
        }
        return null;

    }


}
