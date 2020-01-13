package com.scy.algorithm.string;

/**
 * 类名： PalindromeNumber <br>
 * 描述：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）9
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2019/12/26 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        int origin = x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse == origin;
    }

    public boolean isPalindrome2(int x) {
        String s = new StringBuilder(x + "").reverse().toString();
        return s.equals(String.valueOf(x));
    }

    public static void main(String[] args) {
        PalindromeNumber number = new PalindromeNumber();
        System.out.println(number.isPalindrome(0));
        System.out.println(number.isPalindrome(333));
    }
}
