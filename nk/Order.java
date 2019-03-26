package Nvk;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个正整数N代表火车数量，0<N<10 ，接下来输入火车入站序列,求火车的出栈序列
 * 输入：第一行输入一个正整数N，第二行包括N个正整数，范围（1~9）
 * eg：
 * 输入：
 * 3
 * 1 2 3
 * 输出：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 */

public class Order {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i=0; i<n; i++){
                data[i] = in.nextInt();
            }
            count(n,data);
        }

    }

    //此题实际是栈的问题，求所有可能的出栈方式

    /**
     * 判断一个序列是否是入栈序列的出栈序列的基本思路为：每次入栈后都判断是否需要出栈，具体操作如下：
     * （1）对于输入序列，每次先入栈，后判断是否需要出栈，
     *          出栈条件：栈非空且栈顶元素与出栈序列当前所指元素相等。
     * （2）每出栈一次，指向出栈序列下一个元素。
     * （3）重复过程（1），直到输入序列遍历完成。
     * （4）遍历结束后，若栈空则true，否则false
     */
    public static boolean counti(int[] data,int[] num) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0; i<data.length; i++){
            stack.push(num[i]);
            while (!stack.empty() && stack.peek()==data[j]){
                stack.pop();
                j++;
            }

        }
        return stack.empty();
    }



    public static void count(int n,int[] data){
        int[] tmp = new int[n];



//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++) {
//                for (int x = 0; x < n; x++) {
//                    if (data[i] != data[j] && data[i] != data[x] && data[j] != data[x]) {
//                        boolean flag = counti(new int[]{data[i],data[j],data[x]},data);
//                        if(flag==true){
//                            System.out.println(data[i]+" "+data[j]+" "+data[x]);
//                        }
//                    }
//                }
//            }
//        }


    }



    /**
     * public static void main(String[] args) {
     *         Scanner in = new Scanner(System.in);
     *         while(in.hasNext()){
     *             int n = in.nextInt();
     *             int[] A = new int[n];
     *             for(int i=0;i<n;i++){
     *                 A[i] = in.nextInt();
     *             }
     *             int start = 0;
     *             ArrayList<int[]> result = new ArrayList<int[]>();
     *
     *             Permutation(A,start,n,result);
     *             Set<String> sortResult = new TreeSet<String>();
     *
     *             for(int[] out:result){
     *                 if(isLegal(A,out,n)){
     *                     StringBuilder sb = new StringBuilder();
     *                     for(int i=0;i<n-1;i++){
     *                         sb.append(out[i]+" ");
     *                     }
     *                     sb.append(out[n-1]);
     *                     sortResult.add(sb.toString());
     *                     System.out.println(sb.toString());
     *                 }
     *             }
     *             for(String list:sortResult){
     *                 System.out.println(list);
     *             }
     *         }
     *         in.close();
     *
     *     }
     *     private static boolean isLegal(int[] in,int[] out,int n){
     *         LinkedList<Integer> stack = new LinkedList<Integer>();
     *         int i=0;
     *         int j=0;
     *         while(i<n){ // in 还有元素的时候都需要判断
     *             if(in[i] == out[j]){ //  相等时候就不用入栈，直接后移
     *                 i++;
     *                 j++;
     *             }else{
     *                 if(stack.isEmpty()){ //空stack 就只有入栈了
     *                     stack.push(in[i]);
     *                     i++;
     *                 }else{
     *                     int top = stack.peek(); // 栈顶元素相等，进行出栈
     *                     if(top ==out[j]){
     *                         j++;
     *                         stack.pop();
     *                     }else if(i<n){ //  不等时候入栈
     *                         stack.push(in[i]);
     *                         i++;
     *                     }
     *                 }
     *             }
     *         }
     *         while(!stack.isEmpty() && j<n){ // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素 相同
     *             int top = stack.pop();
     *             if(top == out[j]){
     *                 j++;
     *             }else{
     *                 return false;
     *             }
     *         }
     *         return true;
     *
     *     }
     *
     *     private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){
     *         if(start == n){
     *             return;
     *         }
     *         if(start == n-1){
     *             int[] B = A.clone();
     *             result.add(B);
     *             return;
     *         }
     *         for(int i=start;i<n;i++){
     *             swap(A,start,i);
     *             Permutation(A,start+1,n,result);// 后一个位置开始，进行递归
     *             swap(A,start,i);
     *         }
     *
     *     }
     *     private static void swap(int[] A,int i,int j){
     *         int t = A[i];
     *         A[i] = A[j];
     *         A[j] = t;
     *     }
     *
     */
}
