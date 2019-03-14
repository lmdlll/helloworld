package Nvk;


public class BuyChicken {
    public static void main(String[] args) {
        //公鸡
        for(int g=0; g<=100; g++){
            //母鸡
            for(int m=0; m+g<100; m++){
                //小鸡
                int x=100-g-m;
                if((x%3==0) && (g*5+m*3+x/3==100) ){
                    System.out.println(g+" "+m+" "+x);
                }
            }

        }

    }
}
