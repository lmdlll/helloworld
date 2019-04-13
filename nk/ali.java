package Nvk;

/**
 * 阿里笔试题，飞猪小二
 * 输入：m（共有m个城市） n（有n个飞猪小二） {1,2,3,1,……} 每个城市的酒店数量
 * 输出：每个飞猪小二需要管理的城市数量
 *
 * eg：
 * 输入：9,3,new int[]{1,2,3,4,3,1,1,2,3}
 * 输出：3；2；4
 *
 */
public class ali {
    public static void main(String[] args) {
        System.out.println(best(9,3,new int[]{1,2,3,4,3,1,1,2,3}));
//        System.out.println(best(9,3,new int[]{2,3,1,2,3,2,4,2,1}));
    }
    //m个城市，n个小二
    public static String best(int m, int n,int[] data){
        int[] result = new int[n];
        int sum = 0;
        for(int i=0; i<m; i++){
            sum += data[i];
        }
        int tmp = sum/n;
        int count = 0;
        int max = 0;
        int j=0;
        int i=0;
        for(i=0,j=0; i<m&&j<n; i++){
            if(max>=tmp){
                result[j++] = count;
                max = data[i];
                count = 1;
            }else {
                max += data[i];
                count++;
            }
        }
        if (max>=tmp){
            result[n-1] = count;
        }
//        if(i<=m){
//            count += m-i;
//            result[n-1] = count+result[n-1];
//        }
        String str = "";
        for(i=0; i<result.length; i++){
            if(i==result.length-1){
                str += result[i];
            }else {
                str += result[i] + ";";
            }
        }
        return str;
    }
}
