package Nvk;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 数据分类处理
 * 输入：一组输入整数序列I 和一组规则整数序列R，I和R序列的第一个整数位序列的个数（个数不包含第一个整数）
 * 整数范围：0~0xFFFFFFFF 序列个数不限
 *
 * 输出：从R依次取出R<i> 对应的数字   eg：R<i> 23  I<j> 321 那么I<j>包含R<i> 条件满足
 * 按R<i>从小到大到顺序：
 * 1.先输出R<i>
 * 2.再输出满足条件的 I<j>的个数
 * 3.然后输出满足条件的 I<j>在I序列中的位置索引
 * 4.最后输出 I<j>
 *
 *  PS：
 *  1.R<i>需要从小到大排序，相同R<i>只需要输出索引小的以及满足条件的I<j>
 *  2.如果没有满足条件的I<j>，对应的R<i>不用输出
 *  3.最后需要在输出序列的第一个整数位置记录后续整数序列的个数
 *
 *
 *
 * eg：
 * 输入
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 *
 * 输出
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123  6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 * 51 3 6 0 123 3 453 7 3 9 453456 13 453 14 123  6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 *    6 6 2 786 4 46 8 665 9 453456 11 456 12 786   3 5 3 453 7 3 9
 *
 */

public class DataExcute {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            int n = in.nextInt();
            int[] datai = new int[n];
            for(int i=0; i<n; i++){
                datai[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] datar = new int[m];
            for(int i=0; i<m; i++){
                datar[i] = in.nextInt();
            }
            excute(datai,datar);
        }


    }

    public static void excute(int[] datai, int[] datar){
        String[] dataii = new String[datai.length];
        for(int i=0; i<datai.length; i++){
            dataii[i] = String.valueOf(datai[i]);
        }
        int count = 0;
        String[] datarr = new String[datar.length];
        for(int i=0; i<datar.length; i++){
            datarr[i] = String.valueOf(datar[i]);
        }
        String[] qc = new String[datarr.length];
        String red = "";
        int r = 0;
        int all = 0;
        int[] data = new int[500];
        int k = 0;
        for(int i=0; i<dataii.length; i++){
            int tmp = i;
            for(int j=0; j<datarr.length; j++){
                if (dataii[i].contains(datarr[j])) {
                    data[k] = Integer.parseInt(datarr[j]);
                    count++;
                    int key = k+1;
                    k += 2;
                    data[k++] = i;
                    data[k++] = Integer.parseInt(dataii[i]);
                    for(int q = i+1; q<dataii.length ; q++){
                        if (dataii[q].contains(datarr[j])) {
                            data[k++] = q;
                            data[k++] = Integer.parseInt(dataii[q]);
                            count++;
                        }
                    }
                    data[key] = count;
                    all += count;
                    count=0;
                    i = tmp+1;
                }
            }
        }
        System.out.print(all+" ");
        for (int i=0; i<all; i++) {
            if (i == all - 1) {
                System.out.print(data[i]);
            } else {
                System.out.print(data[i] + " ");
            }
        }
    }

}


/**
 * public class Main{
 *    public static void resultData(String[] strR, String[] strI){
 *         LinkedList<Integer> result = new LinkedList<>();
 *         Set<Integer> setR = new TreeSet<>();
 *         for (int i = 1; i < strR.length; i++){
 *             setR.add(Integer.parseInt(strR[i]));
 *         }
 *
 *         for (int str : setR){
 *             LinkedList<Integer> tmp = new LinkedList<>();
 *             for (int i = 1; i < strI.length; i++){
 *                 if (strI[i].contains("" + str)){
 *                     tmp.add(i - 1);
 *                     tmp.add(Integer.parseInt(strI[i]));
 *                 }
 *             }
 *             if (!tmp.isEmpty()){
 *                 result.add(str);
 *                 result.add((tmp.size() / 2));
 *                 result.addAll(tmp);
 *             }
 *         }
 *
 *         System.out.print(result.size() + " ");
 *        int count = result.size();
 *         for (int ele : result){
 *             if (count != 1)
 *                 System.out.print(ele + " ");
 *             else
 *                 System.out.print(ele);
 *             count--;
 *
 *         }
 *        System.out.println();
 *
 *     }
 *
 *     public static void main(String[] args){
 *         Scanner sc = new Scanner(System.in);
 *         while (sc.hasNext()){
 *             String I = sc.nextLine();
 *             String R = sc.nextLine();
 *             String[] arrR = R.split(" ");
 *             String[] arrI = I.split(" ");
 *             resultData(arrR, arrI);
 *         }
 *         sc.close();
 *     }
 * }
 */


