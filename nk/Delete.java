package Nvk;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 删数
 * 一个数组a[n]顺序存放0~n-1 ，要求每隔两个数删掉一个数，到末尾时循环至开头继续，求最后一个被删掉的数的元素下标位置
 * eg：
 * {0,1,2,3,4,5,6,7} 0->1->2(删除)->3->4->5(删除)->6->7->0(删除)，如此循环到最后一个数被删除
 * 输入：8
 * 输出：6
 */


public class Delete {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            delete(n);
        }
//        System.out.println(delete(8));
    }
    //思路：设置一个标准位，1表示有，0表示无
    public static void delete(int n){
        int flag = 0;
        int count = 0;
        int sy = n;
        int[] tmp = new int[n];
        for(int i=0; i<n; i++){
            tmp[i] = 1;
        }
        int result = 0;
        int i=0;
        while (sy>1) {
            for(i=0; i<n; i++) {
                if(tmp[i]==1) {
                    if (count == 2) {
                        tmp[i] = 0;
                        sy--;
                        count = 0;
                    } else {
                        count++;
                        result=i;
                    }
                }
            }
        }
        System.out.println(result);
    }
//机智啊，还可以使用list
    public static void plan2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n > 1000) {
                n = 999;
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int i = 0;
            while (list.size() > 1) {
                i = (i + 2) % list.size();
                list.remove(i);
            }
            System.out.println(list.get(0));
        }
    }


}
