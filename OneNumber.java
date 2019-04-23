package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */


class Solution {
    public int singleNumber(int[] nums) {
        HashSet hashSet = new HashSet();
        for(int i=0; i<nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            } else {
                hashSet.add(nums[i]);
            }
        }
        Object[] res = hashSet.toArray();
        int result = (int)res[0];
        return result;
    }

}

public class OneNumber {
    public static void main(String[] args) {
        int[] data = new int[]{1,2,4,2,1};
        System.out.println(new Solution().singleNumber(data));
    }
}
