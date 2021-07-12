package com.scy.algorithm.string;

/**
 * 类名： LongestPalindrome <br>
 * 描述：给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 来源：力扣（LeetCode）409. 最长回文串
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int ans = 0;
        int mark = -2;
        for (int i = 0; i < map.length; i++) {
            // -2 在32机制为 11111111 11111111 11111111 11111110
            // map[i]如果为偶数则 则 ans + map[i]； 否则 ans + map[i] - 1
            ans += mark & map[i];
        }
        //理解最长的要求，比如 abba 满足要求，但如果 < length,不是最长，加1个字母构成最长 abXba
        return ans < s.length() ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(1 & 1);
        System.out.println(1 & 0);
        System.out.println(0 & 0);
        System.out.println(0 & 1);
    }
}
