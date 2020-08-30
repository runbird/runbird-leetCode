package com.scy.algorithm.string;

import java.util.List;

/**
 * @desc:
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 * 提示：
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * 来源：力扣（LeetCode）557
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-08-30 21:52
 **/
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] str = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (String s1 : str) {
            ans.append(new StringBuilder().append(s1).reverse().toString()).append(" ");
        }
        return ans.deleteCharAt(ans.length() -1).toString();
    }
}
