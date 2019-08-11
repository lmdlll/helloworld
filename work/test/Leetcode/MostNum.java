package Leetcode;

import java.util.*;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 */
public class MostNum {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,-2,0,-3,0,5};
        System.out.println(majorityElement3(nums));

    }

    //思路：先排序，然后设计一个数组，大小为原数组的最大值
    //出错了，因为负数不可以
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int[] data = new int[nums[nums.length-1]+1];
        for (int i=0; i<nums.length; i++){
            data[nums[i]]++;
        }
        int result = nums[0];
        int len = nums.length/2+nums.length%2;
        for (int i=0; i<data.length; i++){
            if(data[i]>=len){
                result = i;
                break;
            }
        }
        return result;
    }

    //41ms  思路：使用hashmap保存数据
    public static int majorityElement2(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                int count = map.get(nums[i]);
                map.put(nums[i],count+1);
            }
        }
        int result = nums[0];
        int len = nums.length/2 + nums.length%2;
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> ms = iterator.next();
            int key = ms.getKey();
            int value = ms.getValue();
            if(value>=len){
                result = key;
                break;
            }
        }
        return result;
    }

    //3ms 出现次数大于等于数组的一半，即出现次数足够多
    // 妙啊
    public static int majorityElement3(int[] nums) {
        int maxValue = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                maxValue = nums[i];
                sum = 1;
            } else if (maxValue == nums[i]) {
                sum++;
            } else if (maxValue != nums[i]) {
                sum--;
            }
        }
        return maxValue;
    }
}
