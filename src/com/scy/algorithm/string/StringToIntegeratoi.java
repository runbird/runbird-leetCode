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
        char[] arr = str.toCharArray();
        if (arr[0] >= 'a' && arr[0] < 'z' || arr[0] >= 'A' && arr[0] < 'Z') return 0;
        int length = str.length();
        //1 首不能为数字
        boolean flag = false;
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != ' ' && !(arr[i] >= 'a' && arr[i] < 'z' || arr[i] >= 'A' && arr[i] < 'Z')) {
                arr[start++] = arr[i];
            } else {
                return 0;
            }
        }
        start--;
        int result = 0;
        if (arr[0] == '-') {
            while (end++ < start) {
                result = result * 10 + (arr[end] - '0');
                if (result >= Integer.MAX_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
            }
            return -result;
        } else {
            while (end <= start) {
                result = result * 10 + (arr[end++] - '0');
                if (result >= Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
            }
            return result;
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
