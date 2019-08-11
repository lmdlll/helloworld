package Leetcode.List;

import java.util.*;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 */
public class RemoveNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(-5);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(-1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode res = deleteDuplicates3(l1);




    }
    //2ms 思路：创建一个新链表来保存数据
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode res = new ListNode(head.val);
        ListNode result = res;
        while (head!=null){
            if(head.val != res.val){
                res.next = new ListNode(head.val);
                res = res.next;
            }
            head = head.next;
        }
        return result.next;
    }

    //1ms 思路：使用原来是链表进行处理
    public ListNode deleteDuplicates1(ListNode head){
        ListNode temp = head;
        while (temp != null){
            if (temp.next == null){
                break;
            }
            if (temp.next.val == temp.val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }

        }
        return head;
    }

    //脑洞想法：使用Set集合 使用了TreeSet进行数据的有序存储，
    // 但是好像有问题，每次到负数和-1都是-1在前，剩下的负数在后面
    //TODO:
    public static ListNode deleteDuplicates3(ListNode head){
        if(head==null){
            return head;
        }
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        Set<Integer> set = new HashSet<>();
        while (head!=null){
            int x = head.val;
            set.add(x);
            head = head.next;
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            tmp.next = new ListNode(iterator.next());
            tmp = tmp.next;
        }
        return res.next;
    }
}
