package Nvk;


import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/6bc058b32ee54a5fa18c62f29bae9863
 * 来源：牛客网
 *
 * 用两个栈实现队列，支持队列的基本操作。
 *
 * 输入描述:
 * 第一行输入一个整数N，表示对队列进行的操作总数。
 *
 * 下面N行每行输入一个字符串S，表示操作的种类。
 *
 * 如果S为"add"，则后面还有一个整数X表示向队列尾部加入整数X。
 *
 * 如果S为"poll"，则表示弹出队列头部操作。
 *
 * 如果S为"peek"，则表示询问当前队列中头部元素是多少。
 *
 *
 * 输出描述:
 * 对于每一个为"peek"的操作，输出一行表示当前队列中头部元素是多少。
 * 示例1
 * 输入
 * 6
 * add 1
 * add 2
 * add 3
 * peek
 * poll
 * peek
 * 输出
 * 1
 * 2
 */

class Queue{
    Stack<Integer> s1;
    Stack<Integer> s2;
    public Queue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void add(int x){
        s1.push(x);
    }

    public void poll(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
        }
        s2.pop();
    }

    public int peek(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
        }
        return s2.peek();
    }


}
public class SToQu{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            Queue q = new Queue();
            for(int i=0; i<n; i++){
                String str = in.next();
                if(str.equals("add")){
                    int m = in.nextInt();
                    q.add(m);
                }else if(str.equals("poll")){
                    q.poll();
                }else if(str.equals("peek")){
                    System.out.println(q.peek());
                }

            }
        }

    }

}