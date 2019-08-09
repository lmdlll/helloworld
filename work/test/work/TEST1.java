package work;

//看书上的测试
public class TEST1 {
    static final int max = 1000;
    static final int min = 0;
    static int input = 0;

    public static void main(String[] args) {
        TEST1 check = new TEST1();
        try {
            check.checkArgs(args);
        } catch (Exception e) {
            System.out.println("Usage: check x");
            System.out.println("---where 0<x<1000");

            System.exit(1);
        }

        if (check.primeCheck(input))
            System.out.println("Yippeee..." + input + "is a prime number");
        else
            System.out.println("Bummer..." + input + "is not a prime number");

    }

    public boolean primeCheck(int num){
        double sqroot = Math.sqrt(max);
        boolean[] primeBucket = new boolean[max+1];
        for (int i=2; i<max; i++){
            primeBucket[i] = true;
        }
        int j=2;
        for(int i=j+j; i<max; i=i+j){
            primeBucket[i] = false;
        }
        for(j=3;j<sqroot; j=j+2){
            if(primeBucket[j]==true){
                for(int i=j+1; i<max; i=i+j){
                    primeBucket[i]=false;
                }
            }
        }
        if(primeBucket[num]==true){
            return true;
        }else {
            return false;
        }
    }

    private void checkArgs(String[] args) throws Exception {
        if(args.length!=1){
            throw new Exception();
        }else {
            Integer num = Integer.valueOf(args[0]);
            input = num.intValue();
            if(input<0){
                throw new Exception();
            }else if(input>num){
                throw new Exception();
            }
        }
    }


}
