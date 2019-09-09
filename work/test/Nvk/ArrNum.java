package Nvk;

import java.util.*;

/**
 * 神奇的数列
 * f(n+2) = f(n+1)+f(n)
 *
 *  2<=x<=2^32
 *
 * 输入：3
 * 输出：
 * 3 2
 * 4 1
 *
 * 说明：
 * 1 1 2 3 5
 * 1 2 3 5 8
 * 2 1 3 4 7
 *
 *
 */
public class ArrNum {
    //创建数组
    static String[] data1 = CreateArr("1","1");
    static String[] data2 = CreateArr("1","2");
    static String[] data3 = CreateArr("2","1");
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        map.clear();
        while (in.hasNext()){
            int n = in.nextInt();
            Add(n,data1);
            Add(n,data2);
            Add(n,data3);

            for (Object obj: map.keySet()){
                System.out.println(obj+" "+map.get(obj));
            }

//
//            Find(n,data1,data2,data3);

        }


    }


    public static void Add(int n, String[] data){
        for (int i=0; i<data.length; i++){
            int a = Integer.parseInt(data[i]);
            if(a==n){
                if(map.containsKey(i+1)){
                    int len = map.get(i+1)+1;
                    map.put(i+1,len);
                }else {
                    map.put(i+1,1);
                }
                break;
            }else if(a>n){
                break;
            }
        }
    }

    public static String[] CreateArr(String a, String b){
        String[] data = new String[1024];
        data[0] = a;
        data[1] = b;
        for (int i=2; i<data.length; i++){
            int tmp = Integer.parseInt(data[i-2])+Integer.parseInt(data[i-1]);
            data[i] = String.valueOf(tmp);
        }
        return data;
    }
}
