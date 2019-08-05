package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** 杨辉三角
 * 输入: 5
 * 输出:
 * [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */

public class generater {
    public static void main(String[] args) {
        System.out.println(generate(5));

    }

    //1ms
    public static List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> res = new ArrayList<>();
        int[][] data = new int[numRows][numRows];
        for (int i=0; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<=i; j++){
                if(j==0 || j==i){
                    data[i][j] = 1;
                }else {
                    data[i][j] = data[i-1][j]+data[i-1][j-1];
                }
                list.add(data[i][j]);
            }
            res.add(list);
        }
        return res;
    }

    //0ms
    public List<List<Integer>> generate2(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                    continue;
                }
                List<Integer> preList = result.get(i - 1);
                int t = preList.get(j-1) + preList.get(j);
                list.add(t);
            }
            result.add(list);
        }
        return result;
    }
}
