package work;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * 就是 arr[i][j]  只能走 arr[i+1][j]或arr[i+1][j+1] ，也只能从arr[i-1][j] 或arr[i-1][j-1]来
 */
public class ShortsetRoad {
// 给定一个三角形，找出从顶到底的最小路径和，每一步可以从上一行移动到下一行相邻的数字
//    [
//         [2],                 [2],
//        [3,4],              [3, 4],            [2],
//       [6,5,7],      ==>   [7, 6, 10]     ==>  [9, 10]   ==>     [11]
//      [4,1,8,3]
//    ]
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).
                        set(j , triangle.get(i).get(j)+
                                  Math.min(triangle.get(i+1).get(j) , triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

   //妙啊！ 36ms
    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        return getResult(triangle,0,0);
    }
    public int getResult(ArrayList<ArrayList<Integer>> triangle,int l,int k) {
        if(l>=triangle.size()){
            return 0;
        }
        int sum = triangle.get(l).get(k);
        return sum+Math.min(getResult(triangle,(l+1),k), getResult(triangle,(l+1),(k+1)));
    }
}
