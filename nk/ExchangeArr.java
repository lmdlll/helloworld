package Nvk;

/** 要求：交换数组中arr[0] 与arr[1]的元素
 *  不允许使用临时变量
 */
public class ExchangeArr {
    public static void main(String[] args) {
        int[] data = new int[]{1,2};
        exchangeAB1(data);
        exchangeAB2(data);
        exchangeAB3(data);
        System.out.println(data[0]+" "+data[1]);

    }
    public static int[] exchangeAB1(int[] AB) {
        AB[0] = AB[0]+AB[1];
        AB[1] = AB[0]-AB[1];
        AB[0] = AB[0]-AB[1];
        return AB;
    }
    public static int[] exchangeAB2(int[] AB) {
        AB[0] = AB[0]*AB[1];
        AB[1] = AB[0]/AB[1];
        AB[0] = AB[0]/AB[1];
        return AB;
    }
    public static int[] exchangeAB3(int[] AB) {
        AB[0] = AB[0]^AB[1];
        AB[1] = AB[0]^AB[1];
        AB[0] = AB[0]^AB[1];
        return AB;
    }
}
