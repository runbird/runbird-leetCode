package com.scy.algorithm.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 类名： KthLargestElementInAnArray <br>
 * 描述：在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）215
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/6/29 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class KthLargestElementInAnArray {

    //方法一
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //方法三 最小堆
    public int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(length, (a, b) -> a - b);
        for (int num : nums) {
            minHeap.add(num);
        }
        for (int i = 0; i < nums.length - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek() == null ? -1 : minHeap.peek();
    }

    public static void main(String[] args) {

    }

}
