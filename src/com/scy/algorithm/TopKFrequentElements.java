package com.scy.algorithm;

import java.util.*;

/**
 * 类名： TopKFrequentElements <br>
 * 描述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 来源：力扣（LeetCode）347
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2019/12/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class TopKFrequentElements {

    private class Frequence implements Comparable<Frequence> {
        public int e, freq;

        public Frequence(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Frequence o) {
            if (this.freq > o.freq) {
                return 1;
            } else if (this.freq < o.freq) {
                return -1;
            }
            return 0;
        }
    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> source = new HashMap<>();
        for (int num : nums) {
            if (source.containsKey(num))
                source.put(num, source.get(num) + 1);
            else
                source.put(num, 1);
        }

        PriorityQueue<Frequence> queue = new PriorityQueue<>();
        for (int key : source.keySet()) {
            if (queue.size() < k) {
                queue.add(new Frequence(key, source.get(key)));
            } else if (queue.peek().freq < source.get(key)) {
                queue.poll();
                queue.offer(new Frequence(key, source.get(key)));
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty())
            list.add(queue.remove().e);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        TopKFrequentElements test = new TopKFrequentElements();
        List<Integer> integers = test.topKFrequent(nums, k);
        System.out.println(integers.toString());
    }
}
