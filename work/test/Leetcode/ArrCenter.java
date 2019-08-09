package Leetcode;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 * 示例 1:
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2:
 *
 * 输入:
 * nums = [1, 2, 3]
 * 输出: -1
 * 解释:数组中不存在满足此条件的中心索引。
 *
 * 说明:
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 *
 */
public class ArrCenter {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, -1, -1, -1, -1};
        System.out.println(pivotIndex2(arr));
    }

    //思路1：定义两个标志，一个start，一个end 写到一半，直接错误，发现思路有问题，如果是前2个与后5个相加相等呢，这个思路有问题
    public static int pivotIndex1(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int flag = 0;
        int result1 = 0;
        int result2 = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length && j > 0 && i < j; i++, j--) {
            result1 += nums[i];
            if (result1 == result2 && j - i == 1) {
                flag = i + 1;
                return flag;
            }
            result2 += nums[j];
            if (result1 == result2 && j - i == 1) {
                flag = i + 1;
                return flag;
            }
        }
        return -1;
    }

    //思路2：相等就将现在的数字用总和减去，相等就说明是这一位
    // 6ms
    public static int pivotIndex2(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int ls = 0;
        for (int i=0; i<nums.length; i++){
            if(ls*2==sum-nums[i]){
                return i;
            }
            ls += nums[i];
        }

        return -1;
    }
}