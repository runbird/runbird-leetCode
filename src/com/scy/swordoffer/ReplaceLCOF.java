package com.scy.swordoffer;

/**
 * @desc:
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 * 来源：力扣（LeetCode）剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-08-02 16:32
 **/
public class ReplaceLCOF {

    public String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

    public String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = s.charAt(i);
            }
        }
        return new String(array, 0, index);
    }
}
