package com.scy.algorithm.string;

import java.util.Stack;

/**
 * 类名： ReverseSubstringsBetweenEachPairOfParentheses <br>
 * 描述：给出一个字符串 s（仅含有小写英文字母和括号）。
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * 注意，您的结果中 不应 包含任何括号。
 *
 *  
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *  abcd -> bcda
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *  uevoli -> iloveu
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *  edocteel
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * a bcdefghijklonmp q -> apmnolkjihgfedcbq
 * 来源：力扣（LeetCode）1190. 反转每对括号间的子串
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/5/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ')') {
                StringBuilder cur = sb.reverse();
                String pop = stack.pop();
                sb = new StringBuilder(pop + cur.toString());
            } else {
                sb.append(c);
            }
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        String str = "a(bcdefghijkl(mno)p)q";
        ReverseSubstringsBetweenEachPairOfParentheses reverse = new ReverseSubstringsBetweenEachPairOfParentheses();
        System.out.println(reverse.reverseParentheses(str));
    }
}
