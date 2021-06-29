package com.scy.algorithm.dpdfs.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 类名： PalindromePartitioning <br>
 * 描述：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 *  
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * 来源：力扣（LeetCode）131. 分割回文串
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/6/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PalindromePartitioning {
    //方法一
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, res, stack, 0, len);
        return res;
    }

    private void dfs(char[] s, List<List<String>> res, Deque<String> path, int index, int len) {
        if (len == index) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!isPalind(s, index, i)) {
                continue;
            }
            path.addLast(new String(s, index, i + 1 - index));
            dfs(s, res, path, i + 1, len);
            path.removeLast();
        }
    }

    private boolean isPalind(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning pp = new PalindromePartitioning();
        System.out.println(pp.partition(s));
    }


    //方法二
    public List<List<String>> partition2(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                //dp[left+1][right-1] && s[left] == s[right] 回文
                if (charArray[left] == charArray[right] && (right - left <= 2) || dp[left + 1][right - 1]) {
                    dp[left][right] = true;
                }
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        dfs2(s, 0, len, dp, stack, res);
        return res;
    }

    private void dfs2(String s, int index, int len, boolean[][] dp, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) {
                path.addLast(s.substring(index, i + 1));
                dfs2(s, i + 1, len, dp, path, res);
                path.removeLast();
            }
        }
    }
}