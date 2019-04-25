package Nvk;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 数组中出现次数一般的数字
 * 数组中有一个数字出现的次数超过长度的一半，找到此数字
 * 如果不存在则返回0
 *
 */


public class ArrayHelf {
    //思路1：数组
    public static int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int[] tmp = new int[array[array.length-1]+1];
        for (int i=0; i<array.length; i++){
            tmp[array[i]]++;
        }
        int len = array.length/2;
        for(int i=0; i<tmp.length; i++){
            if(len<tmp[i]){
                return i;
            }
        }
        return 0;
    }
    //思路2：HashMap
    public static int MoreThanHalf(int[] data){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<data.length; i++){
           if(map.containsKey(data[i])){
               int count = map.get(data[i])+1;
               map.put(data[i],count++);
           }else {
               map.put(data[i],1);
           }
        }
        int len  = data.length/2;
        for(int i=0; i<data.length; i++){
            if(map.get(data[i])>len){
                return data[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(MoreThanHalf(new int[]{1,2,3,2,2,2,2,5,4,2}));
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,2,5,4,2}));
        System.out.println(MoreThanHalfNum_Solutionii(new int[]{1,2,3,2,2,2,2,5,4,2}));


    }


    public static int MoreThanHalfNum_Solutioni(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }

        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times=1;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }

        times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
        }

        if(times*2<length){
            result=0;
        }
        return result;
    }




    //巧解，厉害
    //思路：出现次数超过一半的，经过排序，中间的一定是出现次数最多的
    public static int MoreThanHalfNum_Solutionii(int [] array) {
        Arrays.sort(array);
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }

    }


    //快排
    public int MoreThanHalfNum_Solutioniv(int [] array) {
        if(array.length<=0) {
            return 0;
        }
        int start = 0;
        int length = array.length;
        int end  = length-1;
        int middle = length>>1;

        int index = Partition(array,start,end);
        while(index!=middle){
            if(index>middle){
                index = Partition(array,start,index-1);
            } else{
                index = Partition(array,index+1,end);
            }
        }
        int result = array[middle];

        int times = 0;
        for(int i=0;i<length;++i){
            if(array[i] == result)
                times++;
        }
        if(times*2<length){
            System.out.println(times);
            return 0;
        }else{
            return result;
        }
    }
    public int Partition(int[] array,int start,int end){
        int flag = (array[start]+array[end])/2;

        while(start<end){
            while(array[end]>flag){
                end--;
            }
            swap(array,start,end);
            while(array[start]<=flag){
                start++;
            }
            swap(array,start,end);
        }
        return start;
    }
    public void swap(int[] array,int num1,int num2){
        int temp =array[num1];
        array[num1] =array[num2];
        array[num2] =temp;
    }


}
