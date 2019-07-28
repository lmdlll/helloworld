package work;
//给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
//{6,-3,-2,7,-15,1,2,2}
public class Maximum {
    public static void main(String[] args) {
        int[] arr = new int[]{-15,0,13,6,-3,-2,7,-15,1,2,2};
        System.out.println(Maximum(arr));

    }

    //最大连续子数组和   14ms
    public static int Maximum(int[] arr){
        if(arr.length==1){
            return arr[0];
        }
        int max = arr[0];
        int sum = arr[0];
        for (int i=1; i<arr.length; i++){
            sum += arr[i];
            //如果加上num[i]后反而更小了，则从num[i]开始重新计算
            if(sum<arr[i]){
                sum = arr[i];
            }
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }

}
