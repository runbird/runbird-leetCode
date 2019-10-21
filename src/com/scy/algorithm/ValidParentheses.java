package com.scy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 类名： ValidParentheses <br>
 * 描述：Leetcode 20 <br>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 输入: "()"
 * 输出: true
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * 创建日期： 2019/10/16 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put(']', '[');
        dict.put('}', '{');
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (!dict.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.isEmpty() || !stack.pop().equals(dict.get(ch))) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        ValidParentheses vp = new ValidParentheses();
        boolean valid = vp.isValid(s);
        System.out.println(valid);
    }
}
