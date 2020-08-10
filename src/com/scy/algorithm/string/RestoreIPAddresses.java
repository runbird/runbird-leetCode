package com.scy.algorithm.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @desc: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）93
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2020-08-09 20:08
 **/
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> ans = new ArrayList<>(4);
        if (len < 4 || len > 12) {
            return ans;
        }
        Deque<String> deque = new ArrayDeque<>();
        dfs(s, len, ans, deque, 0, 4);
        return ans;
    }

    private void dfs(String s, int len, List<String> ans, Deque<String> deque, int start, int end) {
        //迭代到最底层
        if (start == len) {
            //最后层是合法的
            if (end == 0) {
                ans.add(String.join(".", deque));
            }
            return;
        }
        //每一个结点可以选择截取的方法只有 3 种：1位、 2位、 3位，
        // 因此每一个结点可以生长出的分支最多只有 3 条分支
        for (int i = start; i < start + 3; i++) {
            if (i >= len) break;
            if (end * 3 < len - i) continue;
            if (judgement(s, start, i)) {
                String cur = s.substring(start, i + 1);
                deque.addLast(cur);
                dfs(s, len, ans, deque, i + 1, end - 1);
                deque.removeLast();
            }
        }
    }

    public boolean judgement(String s, int start, int end) {
        int len = end - start + 1;
        if (len > 1 && s.charAt(start) == '0') {
            return false;
        }
        int res = 0;
        while (start <= end) {
            res = res * 10 + s.charAt(start) - '0';
            start++;
        }
        return res >= 0 && res <= 255;
    }
}
