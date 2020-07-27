package com.scy.algorithm.string;

/**
 * 类名： IsSubsequence <br>
 * 描述：给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 *
 * 后续挑战 :
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 致谢:
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 * 来源：力扣（LeetCode）392
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/27 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class IsSubsequence {

    //竟然连续错了几次，应该多看下测试用例
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > 0 && t.length() == 0){
            return false;
        }
        int sLength = s.length() , tLength = t.length();
        int jStart = 0;
        for (int i = 0; i < sLength; i++) {
            boolean temp = false;
            for (int j = jStart; j < tLength; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    jStart = j + 1;
                    temp = true;
                    break;
                }
            }
            if (!temp){
                return false;
            }
        }
        return true;
    }

    //双指针 贪心算法
    public boolean isSubsequence2(String s, String t) {
        int sLength = s.length() , tLength = t.length();
        int sIndex = 0 , tIndex = 0;
        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == sLength;
    }

    //DP     链接：https://leetcode-cn.com/problems/is-subsequence/solution/pan-duan-zi-xu-lie-by-leetcode-solution/
    public boolean isSubsequence3(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        String s = "abc", t = "ahbgdc";
        //  String s = "axc", t = "ahbgdc";
        // String s = "", t = "ahbgdc";
        // String s = "acb",t ="ahbgdc";
        System.out.println(subsequence.isSubsequence(s, t));
    }
}
