package com.scy.algorithm.heap;

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
public class TopKFrequentElements2 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> source = new HashMap<>();
        for (int num : nums) {
            if (source.containsKey(num))
                source.put(num, source.get(num) + 1);
            else
                source.put(num, 1);
        }

      //  PriorityQueue<Integer> queue = new PriorityQueue<>( (o1, o2) -> source.get(o1) - source.get(o2));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(source::get));
        for (int key : source.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (source.get(key) > source.get(queue.peek())) {
                queue.poll();
                queue.offer(key);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty())
            list.add(queue.remove());
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        TopKFrequentElements2 test = new TopKFrequentElements2();
        List<Integer> integers = test.topKFrequent(nums, k);
        System.out.println(integers.toString());
    }
}
