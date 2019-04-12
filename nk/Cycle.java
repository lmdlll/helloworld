package Node;

import java.util.HashSet;

/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 */


public class Cycle {

//    //思路：快慢指针
//    //1ms
//    public boolean hasCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        while (slow!=null && fast!=null){
//            slow = slow.next;
//            if(fast.next!=null) {
//                fast = fast.next.next;
//            }else{
//                return false;
//            }
//            if(slow==fast){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //思路：Set集 神奇啊
//    //14ms
//    public boolean hasCycle2(ListNode head) {
//        Set<ListNode> node = new HashSet<>();
//        while (head!=null){
//            if(((HashSet) node).contains(head)){
//                return true;
//            }else{
//                ((HashSet) node).add(head);
//            }
//            head = head.next;
//        }
//        return false;
//    }


}
