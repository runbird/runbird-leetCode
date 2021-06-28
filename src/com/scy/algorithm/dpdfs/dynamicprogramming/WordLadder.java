package com.scy.algorithm.dpdfs.dynamicprogramming;

import com.sun.deploy.util.UpdateCheck;

import javax.sql.PooledConnection;
import java.util.*;

/**
 * 类名： WordLadder <br>
 * 描述：字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 *  
 * 示例 1：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 *
 * 示例 2：
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *  
 *
 * 来源：力扣（LeetCode）127. 单词接龙
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/6/25 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class WordLadder {
    Set<String> set = new HashSet<>();
    public int ladderLength(String s, String e, List<String> ws) {
        set.addAll(ws);
        if (!set.contains(e)) return 0;
        int ans = bfs(s,e);
        return ans == -1 ? 0 : ans + 1;
    }

    int bfs(String s, String e) {
        //d1正向搜索，d2反向搜索
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        //m1 和 m2 分别记录两个方向出现的单词是经过多少次转换而来
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        //* m1 = {"abc":1} 代表 abc 由 beginWord 替换 1 次字符而来
        //* m2 = {"xyz":3} 代表 xyz 由 endWord 替换 3 次字符而来
        d1.add(s);
        m1.put(s, 0);
        d2.add(e);
        m2.put(e, 0);

        /*
         * 只有两个队列都不空，才有必要继续往下搜索
         * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
         * e.g.
         * 例如，如果 d1 为空了，说明从 beginWord 搜索到底都搜索不到 endWord，反向搜索也没必要进行了
         */
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            // 为了让两个方向的搜索尽可能平均，优先拓展队列内元素少的方向
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) return t;
        }
        return -1;
    }

    // update 代表从 deque 中取出一个单词进行扩展，
    // cur 为当前方向的距离字典；other 为另外一个方向的距离字典
    int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        // 获取当前需要扩展的原字符串
        String poll = deque.pollFirst();
        int n = poll.length();

        // 枚举替换原字符串的哪个字符 i
        for (int i = 0; i < n; i++) {
            // 枚举将 i 替换成哪个小写字母
            for (int j = 0; j < 26; j++) {
                // 替换后的字符串
                String sub = poll.substring(0, i) + String.valueOf((char)('a' + j)) + poll.substring(i + 1);
                if (set.contains(sub)) {
                    // 如果该字符串在「当前方向」被记录过（拓展过），跳过即可
                    if (cur.containsKey(sub)) continue;

                    // 如果该字符串在「另一方向」出现过，说明找到了联通两个方向的最短路
                    if (other.containsKey(sub)) {
                        return cur.get(poll) + 1 + other.get(sub);
                    } else {
                        // 否则加入 deque 队列
                        deque.addLast(sub);
                        cur.put(sub, cur.get(poll) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
