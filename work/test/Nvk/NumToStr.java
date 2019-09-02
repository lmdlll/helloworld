package Nvk;

import java.util.Scanner;

public class NumToStr {
    private static String toChinese(String string) {
        String[] s1 = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String[] s2 = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };
        String result = "";
        int n = string.length();
        for (int i = 0; i < n; i++) {
            int num = string.charAt(i)-'0';
            if (i != n - 1 && num != 0) {
                result += s1[num] + s2[n - 2 - i];
            } else {
                result += s1[num];
            }
        }
        System.out.println(result);
        return result;

    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入字符串：");
//        String str = scanner.next();
//        // 将字符串数字转化为汉字
//        toChinese(str);
//
//    }
//



    public static String[] chineseDigits = new String[] { "零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

    /**
     * 把金额转换为汉字表示的数量，小数点后四舍五入保留两位
     * @param amount
     * @return
     */
    public static String amountToChinese(double amount) {
        if(amount > 99999999999999.99 || amount < -99999999999999.99){
            throw new IllegalArgumentException("参数值超出允许范围 (-99999999999999.99 ～ 99999999999999.99)！");
        }

        boolean negative = false;
        if(amount < 0) {
            negative = true;
            amount = amount * (-1);
        }

        long temp = Math.round(amount * 100);
        int numFen = (int)(temp % 10); // 分
        temp = temp / 10;
        int numJiao = (int)(temp % 10); //角
        temp = temp / 10;
        //temp 目前是金额的整数部分

        int[] parts = new int[20]; // 其中的元素是把原来金额整数部分分割为值在 0~9999 之间的数的各个部分
        int numParts = 0;
        for(int i=0; ; i++) {
            if(temp==0)
                break;
            int part = (int)(temp % 10000);
            parts[i] = part;
            numParts ++;
            temp = temp / 10000;
        }

        boolean beforeWanIsZero = true; // 标志“万”下面一级是不是 0

        String chineseStr = "";
        for(int i=0; i<numParts; i++) {

            String partChinese = partTranslate(parts[i]);
            if(i % 2 == 0) {
                if("".equals(partChinese))
                    beforeWanIsZero = true;
                else
                    beforeWanIsZero = false;
            }

            if(i != 0) {
                if(i % 2 == 0)
                    chineseStr = "亿" + chineseStr;
                else {
                    if("".equals(partChinese) && !beforeWanIsZero)   // 如果“万”对应的 part 为 0，而“万”下面一级不为 0，则不加“万”，而加“零”
                        chineseStr = "零" + chineseStr;
                    else {
                        if(parts[i-1] < 1000 && parts[i-1] > 0) // 如果"万"的部分不为 0, 而"万"前面的部分小于 1000 大于 0， 则万后面应该跟“零”
                            chineseStr = "零" + chineseStr;
                        chineseStr = "万" + chineseStr;
                    }
                }
            }
            chineseStr = partChinese + chineseStr;
        }

        if("".equals(chineseStr))  // 整数部分为 0, 则表达为"零元"
            chineseStr = chineseDigits[0];
        else if(negative) // 整数部分不为 0, 并且原金额为负数
            chineseStr = "负" + chineseStr;

        chineseStr = chineseStr + "元";

        if(numFen == 0 && numJiao == 0) {
            chineseStr = chineseStr + "整";
        }
        else if(numFen == 0) { // 0 分，角数不为 0
            chineseStr = chineseStr + chineseDigits[numJiao] + "角";
        }
        else { // “分”数不为 0
            if(numJiao == 0)
                chineseStr = chineseStr + "零" + chineseDigits[numFen] + "分";
            else
                chineseStr = chineseStr + chineseDigits[numJiao] + "角" + chineseDigits[numFen] + "分";
        }

        return chineseStr;

    }


    /**
     * 把一个 0~9999 之间的整数转换为汉字的字符串，如果是 0 则返回 ""
     * @param amountPart
     * @return
     */
    private static String partTranslate(int amountPart) {
        if(amountPart < 0 || amountPart > 10000) {
            throw new IllegalArgumentException("参数必须是大于等于 0，小于 10000 的整数！");
        }


        String[] units = new String[] {"", "拾", "佰", "仟"};

        int temp = amountPart;

        String amountStr = new Integer(amountPart).toString();
        int amountStrLength = amountStr.length();
        boolean lastIsZero = true; //在从低位往高位循环时，记录上一位数字是不是 0
        String chineseStr = "";

        for(int i=0; i<amountStrLength; i++) {
            if(temp == 0)  // 高位已无数据
                break;
            int digit = temp % 10;
            if(digit == 0) { // 取到的数字为 0
                if(!lastIsZero)  //前一个数字不是 0，则在当前汉字串前加“零”字;
                    chineseStr = "零" + chineseStr;
                lastIsZero = true;
            }
            else { // 取到的数字不是 0
                chineseStr = chineseDigits[digit] + units[i] + chineseStr;
                lastIsZero = false;
            }
            temp = temp / 10;
        }
        return chineseStr;
    }



//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入字符串：");
//        long str = scanner.nextLong();
//        // 将字符串数字转化为汉字
//        System.out.println(amountToChinese(str));
//
//    }



    //有问题，如果是11011 预期：壹万壹仟零壹拾壹元整  结果：壹万壹仟零佰壹拾壹元整

    public static String[] RMB = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    public static String[] unit1 = {"元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
    public static String[] unit2 = {"角", "分"};
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s = sc.next();
//            String result = "";
//            if(s.contains(".")) {
//                String s1 = s.substring(s.indexOf('.') + 1);
//                String s2 = s.substring(0, s.indexOf('.'));
//                result = integer(s2) + decimal(s1);
//            } else
//                result = integer(s) + "整";
//            System.out.println(result);
//        }
//    }
    // 处理整数
    public static String integer(String s) {
        if(s.length() == 1 && s.charAt(0) == '0') return "";
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > - 1; i -- )
            sb.append(s.charAt(i));
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i ++ )
            arr[i] = Integer.parseInt(String.valueOf(sb.toString().charAt(i)));
        sb.delete(0, sb.length());
        for (int i = 0; i < arr.length; i ++ )
            sb.append(unit1[i] + RMB[arr[i]]);
        sb = sb.reverse();
        if(sb.charAt(0) == '壹' && sb.charAt(1) == '拾') sb.deleteCharAt(0);
        return sb.toString();
    }
    // 处理小数
    public static String decimal(String s) {
        String temp = "";
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i ++ )
            arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        for (int i = 0; i < arr.length; i ++ ) {
            if(arr[i] == 0) continue;
            temp += RMB[arr[i]] + unit2[i];
        }
        return temp;
    }

    static char[] digit = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    static char[] unitLast = {'角', '分'};
    static char[] unit = {' ','拾','佰','仟'};
    static char[] lastfix = {'万','亿'};
    public static String processPre(char[] pre) {
        StringBuilder str = new StringBuilder();
        str.append('元');
        int count = 0;
        boolean flag = false;
        boolean zero = false;
        boolean first = false;
        boolean input = false;
        if(pre[pre.length-1] == '0')
            first = true;
        for(int i = pre.length-1; i >= 0; i--) {
            count++;
            if(count % 4 == 1 && count != 1) {
                str.append(lastfix[count/4-1]);
            }
            if(pre[i] != '0') {
                flag = true;
                first = false;
                input = true;
            } else {
                zero = true;
            }
            if(first && pre[i] == '0') {
                zero = false;
            }
            if(flag && unit[(pre.length-1-i) % 4] != ' '){
                str.append(unit[(pre.length-1-i) % 4]);
            }
            if(count != pre.length || count % 4 != 2) {
                if(flag) {
                    str.append(digit[pre[i]-'0']);
                    flag = false;
                }
                if(zero && input) {
                    str.append('零') ;
                    input = false;
                    zero = false;
                }
                if(!input && zero)
                    zero = false;

            }
            if(count % 4 == 2 && pre[i] != '0')
                flag = false;

        }
        return str.reverse().toString();
    }
    public static String processLast(char[] last) {
        String str = "";
        for(int i = 0; i < last.length; i++) {
            if(last[i] != '0') {
                str += digit[last[i] - '0'];
                str += unitLast[i];
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            String[] money = cin.next().split("\\.");
            String rmb = "";
            char[] pre = money[0].toCharArray();
            boolean flagLast = true;
            boolean flagPre = true;
            char[] last = null;
            if(money.length == 1)
                flagLast = true;
            else {
                last = money[1].toCharArray();
                for(int i = 0; i < last.length; i++) {
                    if(last[i] != '0')
                        flagLast = false;
                }
            }
            for(int i = 0; i < pre.length; i++) {
                if(pre[i] != '0')
                    flagPre = false;
            }
            if(flagPre && flagLast) {
                System.out.println("零元零角零分");
            }
            if(flagLast && !flagPre) {
                rmb += processPre(pre);
                rmb += '整';
            }
            if(flagPre && !flagLast) {
                rmb += processLast(last);
            }
            if(!flagLast && !flagPre){
                rmb += processPre(pre);
                rmb += processLast(last);
            }
            System.out.println(rmb);

        }
    }



}
