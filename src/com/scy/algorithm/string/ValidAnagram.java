package com.scy.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： ValidAnagram <br>
 * 描述：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * s = "aacc", t = "ccac";
 * s = "a",t="b";
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * ***进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）242
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/1/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                mapt.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!mapt.get(s.charAt(i)).equals(mapt.get(s.charAt(i))))
                return false;
        }
        return true;
    }

    //GJ
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a'] ++;
            dict[t.charAt(i) - 'a'] --;
        }
        for (int value : dict) {
            if (value != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aacc", t = "ccac";
        ValidAnagram valid = new ValidAnagram();
        System.out.println(valid.isAnagram2(s, t));
    }
}
