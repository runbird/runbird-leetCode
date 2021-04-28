package com.scy.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 类名： BasicCalculator <br>
 * 描述：给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 来源：力扣（LeetCode）224
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/3/30 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BasicCalculator {
    /**
     * 代码里面:
     *
     * res 表示左边表达式除去栈内保存元素的计算结果；
     * sign 表示运算符；
     * num 表示当前遇到的数字，会更新到 res 中；
     * 用栈保存遇到左括号时前面计算好了的结果和运算符。
     * 操作的步骤是：
     *
     * 如果当前是数字，那么更新计算当前数字；
     * 如果当前是操作符+或者-，那么需要更新计算当前计算的结果 res，并把当前数字 num 设为 0，sign 设为正负，重新开始；
     * 如果当前是 ( ，那么说明遇到了右边的表达式，而后面的小括号里的内容需要优先计算，所以要把 res，sign 进栈，更新 res 和 sign 为新的开始；
     * 如果当前是 ) ，那么说明右边的表达式结束，即当前括号里的内容已经计算完毕，所以要把之前的结果出栈，然后计算整个式子的结果；
     * 最后，当所有数字结束的时候，需要把最后的一个 num 也更新到 res 中。
     *
     * 作者：fuxuemingzhu
     * 链接：https://leetcode-cn.com/problems/basic-calculator/solution/ru-he-xiang-dao-yong-zhan-si-lu-lai-zi-y-gpca/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int calculate(String s) {
        int result = 0, sign = 1, num = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (' ' == c) {
                continue;
            } else if ('+' == c || '-' == c) {
                result += sign * num;
                num = 0;
                sign = '+' == c ? 1 : -1;
            } else if ('(' == c) {
                stack.addLast(result);
                stack.addLast(sign);
                result = 0 ;
                sign = 1;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else{
                result  += num * sign;
                num = 0;
                result *= stack.pop();
                result += stack.pop() ;
            }
        }
        result += sign * num;
        return result;
    }

    //TODO
//    public int calculate2(String s) {
//    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        // System.out.println(calculator.calculate("1 + 1"));
        System.out.println(calculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
