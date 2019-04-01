package Array;

public class uglyNum {
    public static void main(String[] args) {
        GetUglyNumber_Solution();
    }
        public static void GetUglyNumber_Solution() {
            int count = 0;
            for(int i=1;count<=100;i++){
                if(isUgly(i)) {
                    count++;
                    System.out.print(i+" ");
                }
            }

        }

        public static boolean isUgly(int n){
            while(n%3==0)
                n = n/3;
            while(n%2==0)
                n = n/2;
            while(n%5==0)
                n = n/5;
            if(n==1)
                return true;
            else
                return false;
        }



}
