package com.scy.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类名： CountOfSmallerNumbersAfterSelf <br>
 * 描述：给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * 来源：力扣（LeetCode）315
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 创建日期： 2020/7/12 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 **/
public class CountOfSmallerNumbersAfterSelf {

    //超时
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>(nums.length -1);
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) count++;
            }
            result.add(count);
        }
        return result;
    }


    //    链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/gui-bing-pai-xu-suo-yin-shu-zu-python-dai-ma-java-/
    private int[] t;
    private int[] cnt;
    private int[] idx;

    //归并排序
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        t = new int[len];
        cnt = new int[len];
        idx = new int[len];
        for (int i = 0; i < len; i++) {
            idx[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1);
        for (int i = 0; i < len; i++) {
            res.add(cnt[i]);
        }
        return res;
    }

    /**
     * 针对数组 nums 指定的区间 [l, r] 进行归并排序，在排序的过程中完成统计任务
     *
     * @param nums
     * @param l
     * @param r
     */
    private void mergeAndCountSmaller(int[] nums, int l, int r) {
        if (l == r) {
            // 数组只有一个元素的时候，没有比较，不统计
            return;
        }
        int mid = l + (r - l) / 2;
        mergeAndCountSmaller(nums, l, mid);
        mergeAndCountSmaller(nums, mid + 1, r);
        // 归并排序的优化，同样适用于该问题
        // 如果索引数组有序，就没有必要再继续计算了
        if (nums[idx[mid]] > nums[idx[mid + 1]]) {
            mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
        }
    }

    /**
     * [l, mid] 是排好序的
     * [mid + 1, r] 是排好序的
     *
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
        // 3,4  1,2
        for (int i = l; i <= r; i++) {
            t[i] = idx[i];
        }
        int i = l;
        int j = mid + 1;
        // 左边出列的时候，计数
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                idx[k] = t[j];
                j++;
            } else if (j > r) {
                idx[k] = t[i];
                i++;
                // 此时 j 用完了，[7,8,9 | 1,2,3]
                // 之前的数就和后面的区间长度构成逆序
                cnt[idx[k]] += (r - mid);
            } else if (nums[t[i]] <= nums[t[j]]) {
                idx[k] = t[i];
                i++;
                // 此时 [4,5, 6   | 1,2,3 10 12 13]
                //           mid          j
                cnt[idx[k]] += (j - mid - 1);
            } else {
                // nums[indexes[i]] > nums[indexes[j]] 构成逆序
                idx[k] = t[j];
                j++;
            }
        }
    }


    //MergeSort排序解决
    public List<Integer> countSmaller3(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        cnt = new int[n];
        t = new int[n];
        idx = new int[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        msort(nums, idx, 0, n);
        return Arrays.stream(cnt).boxed().collect(Collectors.toList());
    }

    private void msort(int[] nums, int[] idx, int b, int e) {
        if (b >= e || b + 1 >= e) {
            return;
        }

        int m = b + ((e - b) >> 1);
        msort(nums, idx, b, m);
        msort(nums, idx, m, e);

        int i = b, j = m, to = b;
        while (i < m || j < e) {
            if (j >= e || i < m && nums[idx[i]] <= nums[idx[j]]) {
                cnt[idx[i]] = j - m;
                t[to++] = idx[i++];
            } else {
                t[to++] = idx[j++];
            }
        }

        for (i = b; i < e; i++) {
            idx[i] = t[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1};
        CountOfSmallerNumbersAfterSelf csnas = new CountOfSmallerNumbersAfterSelf();
        List<Integer> list = csnas.countSmaller(arr);
        list.forEach(System.out::println);
    }
}
