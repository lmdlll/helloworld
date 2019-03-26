package Nvk;


//格雷码

//TODO
public class GrayCode {
    public static void main(String[] args) {
        String[] str = getGray(2);
        System.out.println(str);

    }

    //思路没有~~~
    public static String[] getGray(int n) {
        String[] data = new String[(int) Math.pow(2,n)];
        if(n==1) {
            data[0] = "0";
            data[1] = "1";
            return data;
        }
        String[] last = getGray(n-1);
        for(int i=0; i<last.length; i++){
            data[i] = "0"+last[i];
            data[data.length-1-i] = "1"+last[i];

        }
        return data;
    }
}
