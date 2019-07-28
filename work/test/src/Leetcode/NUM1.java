package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得a+b+c=0 找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */


public class NUM1 {
    public static void main(String[] args) {
        int[] num = new int[]{-0,0,0};
        System.out.println(threeSum2(num));
    }

    //思路：先排序，然后将 b+c=-a
    //超出时间限制…… 待改进
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int a;
        for (int i = 0; i < nums.length; i++) {
            a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (-a == nums[j] + nums[k]) {
                        List<Integer> l = Arrays.asList(a, nums[j], nums[k]);
                        if (!lists.contains(l)) {
                            lists.add(l);
                        }
                    }
                }
            }
        }
        return lists;
    }

    //54ms
    //借鉴一下思路，使用排序+双指针
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            //这里有问题，刚开始写成nums[i]!=nums[i+1] ，结果-4，-4，8出不来，后来改成以下就ok了
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int start = i+1;
                int end = nums.length-1;
                while (start<end){
                    if(-a==nums[start]+nums[end]){
                        lists.add(Arrays.asList(a,nums[start],nums[end]));
                        while (start<end && nums[start]==nums[start+1]){
                            start++;
                        }
                        while (start<end && nums[end]==nums[end-1]){
                            end--;
                        }
                        start++;
                        end--;
                    }else if(-a<nums[start]+nums[end]){
                        //去重
                        while (start<end && nums[end]==nums[end-1]){
                            end--;
                        }
                        end--;
                    }else {
                        //去重
                        while (start<end && nums[start]==nums[start+1]){
                            start++;
                        }
                        start++;
                    }

                }

            }


        }
        return lists;
    }


}
