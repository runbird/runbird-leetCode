package com.scy.algorithm.heap;

import java.util.*;

/**
 * @desc: 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 * 来源：力扣（LeetCode）692. 前K个高频单词
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @program: runbird-leetCode
 * @author: Suocaiyuan
 * @date: 2021-07-25 22:23
 **/
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || k == 0) return new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>(dict.keySet());
//        List<String> res = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
//            res.add(entry.getKey());
//        }

        res.sort((i,j)->{
            if (dict.get(i).equals(dict.get(j))) {
                return i.compareTo(j);
            } else {
                return dict.get(j) - dict.get(i);
            }
        });
        return res.subList(0, k);
    }


    public List<String> topKFrequent2(String[] words, int k) {
        if (words == null || k == 0) return new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        for (String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        Queue<String> queue = new PriorityQueue<>((i, j) -> {
            if (dict.get(i).equals(dict.get(j))) {
                return j.compareTo(i);
            } else {
                return dict.get(i).compareTo(dict.get(j));
            }
        });

        for (String s : dict.keySet()) {
            queue.offer(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> res = new ArrayList<>(k);
        while (queue.size() > 0) {
            res.add(queue.poll());
        }
        Collections.reverse(res);
//        错误解法
//        List<String> res = new ArrayList<>(queue);
//        Collections.reverse(res);
//        res.subList(0, k);
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        TopKFrequentWords k = new TopKFrequentWords();
        k.topKFrequent2(str, 2);
    }
}
