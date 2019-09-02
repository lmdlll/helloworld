package Nvk;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 给定一个字符串，求去掉空格的出现次数最多的字符的次数
 */

public class StrMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            //去除空格
            str = str.replace(" ","");
            str.toLowerCase();
            HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0; i<str.length(); i++){
                char tmp = str.charAt(i);
                if(map.containsKey(tmp)){
                    int len = map.get(tmp)+1;
                    map.put(tmp,len);
                }else {
                    map.put(tmp,1);
                }
            }
            System.out.println(Collections.max(map.values()));
        }

    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] end = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();//保证end中的值都在要查的K个数之内
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();//删除end中不大于num[i]的值，因为肯定不会用到
            }
            deque.offerLast(i);
            if((i + 1) >= k) {
                end[i + 1 - k] = nums[deque.peek()];
            }
        }
        return end;
    }
}

