package Nvk;

import java.util.Scanner;

/**
 * 题目描述：
 * 饭后散步是一个很好的习惯，一天晚上，小A在一条笔直的路上散步，起点在路上某处，但是因为路上没有标识，他并不知道这个起点位于路上的那个位置，
 * 现在将道路划分为N-1个等距的部分，你可以把这条路当成一个数轴，道路上的结点标记为1~N，起点只可能是这N个点中的一个。
 *
 * 但是小A还提供了一个重要信息，他每隔一段时间就会用手机看一下自己走了多远，记作D，但是他并不记得他是朝着哪个方向走的，
 * 唯一可以确定的是，在两次看手机的间隔中他不会改变方向，每次看完手机后他可能继续向前或者回头走。
 *
 * 那么问题来了，已知他在散步过程中始终在1~N的范围内，那么符合上述条件的起点可能有多少个呢？
 *
 * 输入
 * 输入第一行包含一个正整数N，M，
 * N表示道路的长度，也是数轴上点的数量，M是小A提供的D的数量。(N,M<=20000)
 *
 * 接下来有M行，每行一个正整数D，表示小A朝着某个方向走了D个单位。(D<=20000)
 *
 * 输出
 * 输出仅包含一个整数，表示可能的起点的数量。
 *
 *
 * 样例输入
 * 10 3
 * 5
 * 2
 * 6
 * 样例输出
 * 8
 *
 */
public class Walk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int length = input.nextInt();
            int times = input.nextInt();
            int[] steps = new int[times];
            for (int i = 0; i < times; i++) {
                steps[i] = input.nextInt();
            }
            //ans
            int count = 0;
            //统计轴上的每一个点
            for (int cur = 0; cur < length; cur++) {
                if (can(cur, steps, (times - 1), length)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    /**
     * @param cur    当前的位置
     * @param steps  步数记录
     * @param index  步数记录的index
     * @param length 轨道长度
     */
    public static boolean can(int cur, int[] steps, int index, int length) {
        if (index == 0) {
            //判断是否在界限内
            return (0 <= cur && cur < length);
        } else {
            boolean f1 = (0 <= cur && cur < length);
            //判断向左走或者向右走是否成功并且在界限内
            boolean f21 = can( (cur-steps[index]), steps, (index-1), length);
            boolean f22 = can((cur+steps[index]), steps, (index-1), length);
            return f1 && (f21 || f22);
        }

    }
}




