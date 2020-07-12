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

    //水平扫描法
    // https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode/
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //水平扫描Pro 优化部分字符较短，甚至只有单字符的情况
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }


    public String longestCommonPrefixPro(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < strs[i].length() && j < ans.length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) return ans;
        }
        return ans;
    }


    public static void main(String[] args) {
       // String[] source = {"flower","flow","flight"};
        String[] source = {"dog","racecar","car"};
       // String[] source = {""};
       // String[] source = {"a","b"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String s = longestCommonPrefix.longestCommonPrefix1(source);
        System.out.println(s);

    }
}
