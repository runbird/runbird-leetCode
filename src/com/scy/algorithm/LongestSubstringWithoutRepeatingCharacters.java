package com.scy.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * "abcabcbb" \ "aab"
 * 来源：力扣（LeetCode）3
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Suocaiyuan
 * @date: 2019-12-16 22:20
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastOcurred = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (lastOcurred.containsKey(chars[i]) && lastOcurred.get(chars[i]) >= start) {
                start = lastOcurred.get(chars[i]) + 1;
            }
            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
            }
            lastOcurred.put(chars[i], i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        int i = s.lengthOfLongestSubstring(str);
        System.out.println(i);
    }
}
