package com.scy.algorithm.string;

/**
 * 类名： StringToIntegeratoi <br>
 * 描述：请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * 输入: "42"
 * 输出: 42
 * <p>
 * 示例 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * <p>
 * 示例 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * <p>
 * 示例 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * <p>
 * 示例 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）8
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/1/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class StringToIntegeratoi {
    public int myAtoi(String str) {
        if (null == str) return 0;
        String strr = str.trim();
        //存储最终过滤出来的字符串
        String result = null;
        if (!strr.isEmpty()) {
            char c = strr.charAt(0);
            if (c >= '0' && c <= '9' || c == '+' || c == '-') {
                result = strr.substring(0, 1);
                //这时候循环只要数字，因为正负号只能出现在第一位
                for (int i = 1; i < strr.length(); i++) {
                    if (strr.charAt(i) >= '0' && strr.charAt(i) <= '9') {
                        result = strr.substring(0, i + 1);
                    }
                    //这是遇到不符合要求的字符，直接忽略剩余元素
                    else {
                        break;
                        //return 0  如果遇到 3.1415这类则不正确
                    }
                }
            }
        }
        if (result == null || result.equals("+") || result.equals("-")) return 0;
        int num = 0;
        //使用异常机制打印结果
        try {
            num = Integer.parseInt(result);
        } catch (Exception e) {
            if (result.charAt(0) == '-')
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        return num;
    }

    static NumberFormatException forInputString(String s, int radix) {
        return new NumberFormatException("For input string: \"" + s + "\"" +
                (radix == 10 ?
                        "" :
                        " under radix " + radix));
    }

    //source code from jdk12
    public static int parseInt(String s, int radix)
            throws IllegalArgumentException {
        /*
         * WARNING: This method may be invoked early during VM initialization
         * before IntegerCache is initialized. Care must be taken to not use
         * the valueOf method.
         */

        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix +
                    " greater than Character.MAX_RADIX");
        }
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+') {
                 //   throw NumberFormatException.forInputString(s, radix);
                }

                if (len == 1) { // Cannot have lone "+" or "-"
                 //   throw NumberFormatException.forInputString(s, radix);
                }
                i++;
            }
            int multmin = limit / radix;
            int result = 0;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                int digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0 || result < multmin) {
                 //   throw NumberFormatException.forInputString(s, radix);
                }
                result *= radix;
                if (result < limit + digit) {
                 //   throw NumberFormatException.forInputString(s, radix);
                }
                result -= digit;
            }
            //GJ
            return negative ? result : -result;
        } else {
          //  throw NumberFormatException.forInputString(s, radix);
            throw new IllegalArgumentException("");
        }
    }

    public static void main(String[] args) {
//        String s = "words and 987"; //0
//        String s = "421"; //42
//        String s = "     -421";
//        String s = "4193 with words";
//        String s = "-91283472332";
        String s = "3.1415926";
        StringToIntegeratoi atoi = new StringToIntegeratoi();
        System.out.println(atoi.myAtoi(s));
    }
}
