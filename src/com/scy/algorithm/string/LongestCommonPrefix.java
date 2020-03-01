package com.scy.algorithm.string;

/**
 * @desc: 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 *
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）14
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-03-01 21:36
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].equals("")) return "";

        int length = strs.length;
        StringBuilder result = new StringBuilder();
        boolean ifCommon  = true;
        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
                for (int j = 1; j < length; j++) {
                    char chj = strs[j].charAt(i);
                    if (ch != chj) ifCommon  = false;
                }
                if (ifCommon){
                    String s = Character.toString(ch);
                    result.append(s);
                }
        }
        return result.toString();
    }

    public static void main(String[] args) {
       // String[] source = {"flower","flow","flight"};
       // String[] source = {"dog","racecar","car"};
        String[] source = {""};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix(source);
        System.out.println(s);
    }
}
