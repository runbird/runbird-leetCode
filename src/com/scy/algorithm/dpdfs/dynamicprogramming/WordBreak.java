package com.scy.algorithm.dpdfs.dynamicprogramming;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类名： WordBreak <br>
 * 描述：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）139
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/27 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class WordBreak {

    //更优的方法
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && words.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //https://mp.weixin.qq.com/s?__biz=MzU0ODMyNDk0Mw==&mid=2247491645&idx=1&sn=456bb5dd519be3fafa1bcb08d73d8944&chksm=fb42731dcc35fa0bf914ae98e51a26e6a6c5d2b8c77a90dc1abde6625daeaa6cacb3b2376bdc&scene=21#wechat_redirect
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                //如果往前截取全部字符串，我们直接判断子串[0,i-1]
                //是否存在于字典wordDict中即可
                if (i == j && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    continue;
                }
                //如果dp[i]为true，说明前i个字符串结果拆解可以让他的所有子串
                //都存在于字典wordDict中，直接终止内层循环，不用再计算dp[i]了。
                dp[i] = dp[i - j] && wordDict.contains(s.substring(i - j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("pen");
        WordBreak wb = new WordBreak();
        System.out.println(wb.wordBreak(s, words));
    }
}
