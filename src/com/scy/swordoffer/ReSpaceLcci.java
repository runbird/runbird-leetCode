package com.scy.swordoffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 类名： ReSpaceLcci <br>
 * 描述：哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。
 * 像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
 * 在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。
 * 假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * 示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）面试题 17.13. 恢复空格
 * 链接：https://leetcode-cn.com/problems/re-space-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/9 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReSpaceLcci {

    // 链接：https://leetcode-cn.com/problems/re-space-lcci/solution/hui-fu-kong-ge-by-leetcode-solution/
    // Trie + 动态规划
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word : dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }

    //方法二 哈希表
    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;

    public int respace2(String[] dictionary, String sentence) {
        Set<Long> hashValues = new HashSet<>();
        for (String word : dictionary) {
            hashValues.add(getHash(word));
        }

        int[] f = new int[sentence.length() + 1];
        Arrays.fill(f, sentence.length());

        f[0] = 0;
        for (int i = 1; i <= sentence.length(); ++i) {
            f[i] = f[i - 1] + 1;
            long hashValue = 0;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a' + 1;
                hashValue = (hashValue * BASE + t) % P;
                if (hashValues.contains(hashValue)) {
                    f[i] = Math.min(f[i], f[j - 1]);
                }
            }
        }

        return f[sentence.length()];
    }

    private long getHash(String s) {
        long hashValue = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
        }
        return hashValue;
    }

    public static void main(String[] args) {

    }
}

class Trie {
    public Trie[] next;
    public boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String s) {
        Trie curPos = this;

        for (int i = s.length() - 1; i >= 0; --i) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Trie();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }
}