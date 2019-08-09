package Leetcode;

import java.util.ArrayList;
import java.util.List;

/** 杨辉三角2
 * 输入: 3
 * 输出:
 * [1,3,3,1]
 *
 * 5
 * 1 5 10 10 5 1
 * cur =  1   1*5/1=5    5*4/2=10    10*3/3=10    10*2/4=5     5*1/5=1
 */

public class generater2 {
    public static void main(String[] args) {
        System.out.println(getRow(5));
    }

    //3ms
    public static List<Integer> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] data = new int[numRows+1][numRows+1];
        for (int i=0; i<numRows+1; i++){
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
        return res.get(numRows);
    }

    //1ms  cur = cur * (rowIndex-i)/(i+1)公式是怎么得出来的？，这里不知道
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

}
