package com.scy.algorithm.string;

/**
 * 类名： ImplementStrstr <br>
 * 描述：实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * <p>
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）28
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/1/22 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if ("".equals(needle)) return 0;

        int length1 = haystack.length();
        int length2 = needle.length();
        if (length2 > length1) return -1;

        int[] arr = new int[length2];
        int c = 0;

        for (int i = 0; i < length2; i++) {
            char cn = needle.charAt(i);
            for (int j = 0; j < length1; j++) {
                char ch = haystack.charAt(j);
                if (ch == cn) {
                    arr[c++] = j;
                }
                if (j == length1 - 1) {
                    return -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // String haystack ="hello", needle = "ll";
       // String haystack = "aaaaa", needle = "bba";
        String haystack = "mississippi", needle = "issip";
        ImplementStrstr str = new ImplementStrstr();
        System.out.println(str.strStr(haystack, needle));
    }
}


