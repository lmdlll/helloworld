package Leetcode.List;

/**反转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 *
 */

public class Rotate {

    //2ms 思路：右移几位，就倒数第几个 k%head.size()
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null){
            return head;
        }
        ListNode res = head;
        int count = 1;
        while (head.next!=null){
            count++;
            head = head.next;
        }
        count = count - k%count;
        //这里定义一个尾节点
        ListNode tail = head;
        //将单链表改为循环链表 eg：1->2->3  => 1->2->3->1->2……
        tail.next = res;
        //这里循环 size-k%size
        for (int i=0; i<count; i++){
            tail = res;
            res = res.next;
        }
        //将循环链表再次改为单链表
        tail.next = null;
        return res;
    }

}
