package com.scy.algorithm.string;

import java.util.Arrays;
import java.util.Stack;

/**
 * 类名： LongestValidParentheses <br>
 * 描述：32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()" <br>
 *
 * 来源：力扣（LeetCode）32
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 创建日期： 2020/7/4 <br>
 * @author suocaiyuan
 * @version V1.0
 */
public class LongestValidParentheses {

    //找出最长的有效字符串
    //BUG
    public int longestValidParenthesesError(String s) {
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            if (ch == '('){
                stack.push(ch);
            }else if(!stack.isEmpty() && stack.pop().equals('(')){
                if (stack.size() > 0){
                    result = 1;
                }else {
                    result++;
                }
            }
        }
        return result * 2;
    }

    //链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
      //  String str = ")()())";
      //  String str = "(()";
        String str = "()(()";  // --> 最大有效长度2
      //  String str = "()(())";
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses(str));
    }

}
