package Nvk;

import java.util.*;

/**
 * 题目描述:
 * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组
 * 例如, arr = [-8, -4, -3, 0, 1, 2, 4, 5, 8, 9], k = 10，打印结果为：
 * 1, 9
 * 2, 8
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * 输入描述:
 * 第一行有两个整数n, k
 * 接下来一行有n个整数表示数组内的元素
 * 输出描述:
 * 输出若干行，每行两个整数表示答案
 * 按二元组从小到大的顺序输出(二元组大小比较方式为每个依次比较二元组内每个数)
 * 示例1
 * 输入
 * 复制
 * 10 10
 * -8 -4 -3 0 1 2 4 5 8 9
 * 输出
 * 复制
 * 1 9
 * 2 8
 *
 *
 */
public class PrintArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            Search3(data,k);

        }

    }

    //思路：双重循环遍历
    //时间复杂度过大
    public static void Search(int[] data, int k){
        int[][] result = new int[data.length][2];
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i=0; i<data.length; i++){
            for (int j=0; j<data.length; j++){
                if(j==i){
                    continue;
                }
                if(data[i]+data[j]==k && !set.contains(data[i]) && !set.contains(data[j])){
                    result[count][0] = data[i];
                    result[count][1] = data[j];
                    set.add(data[i]);
                    set.add(data[j]);
                    count++;
                    break;
                }
            }
        }
        for (int i=0; i<count; i++){
            System.out.println(result[i][0]+" "+result[i][1]);

        }

    }
    //将数组变为HashMap
    //时间复杂度过大
    public static void Search2(int[] data, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (j == i) {
                    continue;
                }
                if (data[i] + data[j]==k && !map.containsKey(data[i]) && !map.containsValue(data[j]) && !map.containsKey(data[j]) &&  !map.containsValue(data[i])) {
                    map.put(data[i], data[j]);
                    break;
                }
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = (Map.Entry<Integer, String>) iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    //思路：双指针，一个头，一个尾，当相遇退出
    public static void Search3(int[] data, int k){
        if(data.length==0){
            return;
        }
        int left = 0;
        int right = data.length-1;
        while (left<right){
            if(data[left]+data[right]>k){
                right--;
            }else if(data[left]+data[right]<k){
                left++;
            }else {
                //
                if(left == 0 || data[left]!=data[left-1]) {
                    System.out.println(data[left] + " " + data[right]);
                }
                left++;
                right--;
            }

        }

//        5 -4
//                -4 -3 -1 0 2


    }
}
