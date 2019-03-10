package Array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *

 */

public class RemoveDup2 {
    public static void main(String[] args) {
        int[] data = new int[]{0,0,1,1,1,2};
        System.out.println(removeDuplicates(data));
    }
//14ms
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length ==1 ){
            return 1;
        }
        int j=0;
        int flag = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                if(flag<1) {
                    flag++;
                    nums[j] = nums[i - 1];
                    j++;
                }else {
                    continue;
                }
            }else {
                nums[j] = nums[i-1];
                j++;
                flag=0;
            }

        }
        nums[j++] = nums[nums.length-1];
        return j;
    }
//15ms
    public static int removeDuplicatesi(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        if(nums.length ==1 ){
            return 1;
        }
        int k =0;
        for(int i=0; i<nums.length; i++){
            if(k<2 || nums[i]!=nums[k-2] ){
                nums[k++] = nums[i];
            }
        }
        return k ;
    }

}
