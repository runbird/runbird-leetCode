package com.scy.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
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

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, length = s.length();
        for (int end = 0, start = 0; end < length; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return max;
    }


    public int lengthOfLongestSubstringError(String s) {
        int length = s.length(), max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int start = 0,end = 0; end < length; end++){
            char ch  = s.charAt(end);
            if(map.containsKey(ch)){
              //  start = end;  s = "dvdf" ,start会多移动导致计算错误
              //  start = Math.max(map.get(ch), start) + 1; s = "tmmzuxt" ,最后一个t的时候，start= max(0,2)+1
                start = Math.max(map.get(ch), start) + 1;
            }
            max = Math.max(max,end-start+1);
           // map.put(ch,end++); end++ 和 end +1 区别。。。
            map.put(ch,end);
        }
        return max;
    }

    public static void main(String[] args) {
       // String str = "pwwkew";
      //  String str = "dvdf";
        String str = "tmmzuxt";
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        int i = s.lengthOfLongestSubstringError(str);
        System.out.println(i);
    }
}
