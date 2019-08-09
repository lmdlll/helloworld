package Leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class arrmax {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,4};
        System.out.println(maxSubArray(arr));
    }
    //1ms
    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int now = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            now += nums[i];
            //判断，当加起来的集合都比当前数字小的时候，前面的就没有必要了
            if(now<nums[i]){
                now = nums[i];
            }
            if(max<now){
                max = now;
            }
        }
        return max;
    }
}
