package Nvk;

/**
 * 设a、b、c 均是0 到9 之间的数字，abc、bcc 是两个三位数，
 * 且有：abc+bcc=532。求满足条件的所有a、b、c 的值。
 *
 * 输出描述:
 * 每行输出3个数，分别表示abc的值，用一个空格隔开。
 *
 */

public class NumAdd {
    public static void main(String[] args) {
        computer();

    }

    public static void computer(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<10; k++){
                    if((i*100+j*10+k)+(j*100+k*10+k)==532){
                        System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        }

    }


}
