package com.scy.swordoffer;

/**
 * 类名： ReplaceSpace <br>
 * 描述：请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 来源：力扣（LeetCode）剑指 Offer 05. 替换空格
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/8/30 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return null;
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                ans.append(c);
            } else {
                ans.append("%20");
            }
        }
        return ans.toString();
    }


    public String replaceSpace2(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chars = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                chars[size++] = '%';
                chars[size++] = '2';
                chars[size++] = '0';
            } else {
                chars[size++] = c;
            }
        }
        return new String(chars, 0, size);
    }
}
