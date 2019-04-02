package Nvk;

import java.util.Scanner;

/**
 * 中文大写金额数字前标明“人民币”字样，
 * 壹 贰 参 肆 伍 陆 柒 捌 玖 拾 佰 仟 万 亿 元 角 分 零 整
 * 中文大写金额数字到元为止，在元之后，应写整字，
 * 如：￥532.00 --> 人民币伍佰参拾贰元整
 * 阿拉伯数字中间有0时中文大写要写零字，中间有连续几个0，中文只写一个零
 * 如：￥6007.14 --> 人民币陆仟零柒元壹角肆分
 *
 *eg：
 * 151121.15 --> 人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 */


public class Money {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        if (in.hasNext()){
//            String m = in.next();
//            Exchange(m);
//        }
        Exchange("123456.00");
    }

    public static void Exchange(String n){
        String result = "人民币";
        char[] tmp = n.toCharArray();
        String xs = "";
        String[] tran1 = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] tran2 = new String[]{"拾", "佰", "仟", "万", "亿"};
        int ws = tmp.length-3;
        int jiao = 0;
        int fen = 0;
        for(int i=0; i<tmp.length; i++){
            if(i<tmp.length-3) {
                int dg = Integer.parseInt(String.valueOf(tmp[i]));
                while (dg==0){
                    if(tmp[i]!=tmp[i+1]){
                        break;
                    }else {
                        i++;
                        ws--;
                    }
                }
                result += tran1[dg];
                if (ws == 2) {
                    result += tran2[0];
                } else if (ws == 3) {
                    result += tran2[1];
                } else if (ws == 4) {
                    result += tran2[2];
                } else if (ws == 5) {
                    result += tran2[3];
                } else if (ws == 9) {
                    result += tran2[4];
                } else if(ws>5 && ws<9){
                    result += tran2[ws-4];
                }
                ws--;
            } else {
                jiao = Integer.parseInt(String.valueOf(tmp[i+1]));
                fen = Integer.parseInt(String.valueOf(tmp[i+2]));
                if(jiao==0 && fen==0){
                    xs = "整";
                } else {
                    xs = tran1[jiao]+"角"+tran1[fen]+"分";
                }
                break;
            }
        }

        result += "元"+xs;
        System.out.println(result);

    }


        public static void main1(String[] args) {
            //单位
            String[] tran1 = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
            String[] tran2 = new String[]{"拾", "佰", "仟", "万", "亿"};
            //数据记录
            StringBuilder tin = new StringBuilder();
            StringBuilder result = new StringBuilder("元");
            //标识和临时变量
            int jiao = 0;
            int fen = 0;
            int count = 0;
            boolean flag = false;
            //用户输入
            Scanner scanner = new Scanner(System.in);
            String in = String.valueOf(scanner.nextDouble());
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i) != '.' && !flag) {
                    tin.append(in.charAt(i));
                } else {
                    flag = true;
                    if (count == 1) {
                        //计算角
                        jiao = in.charAt(i) - '0';
                    } else if (count == 2) {
                        //计算分
                        fen = in.charAt(i) - '0';
                    }
                    count++;
                }
            }
            char[] chars = tin.toString().toCharArray();
            if (chars[chars.length - 1] != '0') {
                result.insert(0, tran1[chars[chars.length - 1] - '0']);
            }
            int count1 = 0;
            for (int i = tin.toString().length() - 2; i >= 0; i--) {
                if (chars[i] - '0' != 0) {
                    if (count1 == 8) {
                        result.insert(0, tran2[4]);
                    } else {
                        result.insert(0, tran2[count1 % 4]);
                    }
                    if (chars[i] - '0' != 1 || count1 % 4 != 0) {
                        result.insert(0, tran1[chars[i] - '0']);
                    }
                }
                count1++;
                count1 %= 9;
            }
            //输出
            System.out.print("人民币" + result);
            //0 假
            //!0 真
            boolean bJiao = jiao != 0;
            boolean bFen = fen != 0;
            if (!bJiao && !bFen) {
                System.out.println("整");
            } else {
                if (bJiao) {
                    System.out.print(tran1[jiao] + "角");
                }
                if (bFen) {
                    System.out.print(tran1[fen] + "分");
                }
                System.out.println();
            }
        }



}
