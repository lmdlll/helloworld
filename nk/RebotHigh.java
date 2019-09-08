package Nvk;

import java.util.*;

/**
 * 输入：
 * 4
 * 6 5 3 4
 * 输出：
 * 5
 *
 * 5被3和4看到，记2次最多
 */
public class RebotHigh {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            int n = in.nextInt();
            int[] high = new int[n];
            Map<Integer,Integer> map = new HashMap<>();

            for (int i=0; i<n; i++){
                high[i] = in.nextInt();
                map.put(high[i],0);
            }

            for (int i=n-1; i>=0; i--){
                for (int k = i; k>=0; k--){
                    if(high[k]>high[i]){
                        int len = map.get(high[k])+1;
                        map.put(high[k],len);
                        while (i>=0 && i-1>=0 && high[i]>high[i-1]){
                            len = map.get(high[k])+1;
                            map.put(high[k],len);
                            i--;
                        }
                        break;
                    }
                }
            }

            Set<Integer> set = map.keySet();
            int max = Collections.max(map.values());
            for (int s:set) {
                if(map.get(s)==max){
                    System.out.println(s);
                    break;
                }
            }



        }

    }
}
