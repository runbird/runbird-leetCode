package com.scy.swordoffer;

import java.util.*;

/**
 * 类名： GetLeastNumbers <br>
 * 描述：输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）剑指 Offer 40. 最小的k个数
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/23 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class GetLeastNumbers {

    //时间复杂度 O（nlgn)
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[]{};
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    //快速排序
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        //要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        //每次快排切分1次，找到排序后下标为j的元素，如果j恰好等于K，就返回j及左边所有的数
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        //否则根据下标j与k的大小关系来决定继续切分 左边或右边
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) break;
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    //堆
    //复杂度分析：时间复杂度，每个元素都需要入堆，而堆 push 的时间复杂度为 O(lgk)。
    //因为我们控制了堆的大小为 k，所以总的时间复杂度为 O(Nlgk)。
    //因为我们使用了 k 个元素的堆，所以空间复杂度为 O(k)。
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<>((i, j) -> j - i);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                queue.poll();
                queue.offer(num);
            }
        }
        //返回堆中的元素
//        int[] res = new int[queue.size()];
//        int idx = 0;
//        for (int num : queue) {
//            res[idx++] = num;
//        }
//        return res;
        List<Integer> res = new ArrayList<>(queue);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

}