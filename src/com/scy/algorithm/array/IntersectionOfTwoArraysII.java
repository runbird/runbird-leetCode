package com.scy.algorithm.array;

import java.util.*;

/**
 * 类名： IntersectionOfTwoArraysII <br>
 * 描述：给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）350
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2019/12/3 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        //hashmap O(n) < treemap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int index = 0;
        int[] result = new int[list.size()];
        for (Integer integer : list) {
            result[index++] = integer;
        }
        return result;
    }

    //如果 nums1 元素个数大于 nums2，则交换数组元素。
    //对于 nums1 的每个元素，添加到 HashMap m 中，如果元素已经存在则增加对应的计数。
    //初始化 k = 0，记录当前交集元素个数。
    //遍历数组 nums2：
    //检查元素在 m 是否存在，若存在且计数为正：
    //将元素拷贝到 nums1[k]，且 k++。
    //减少 m 中对应元素的计数。
    //返回 nums1 前 k 个元素。
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect2(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int k = 0;
        for (int i : nums2) {
            int cnt = map.getOrDefault(i, 0);
            if (cnt > 0) {
                nums1[k++] = i;
                map.put(i, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public int[] intersect3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int up = 0 , down = 0;
        List<Integer> res = new ArrayList<>();
        while (up < nums1.length && down < nums2.length) {
            if (nums1[up] == nums2[down]){
                res.add(nums1[up]);
                up ++ ; down ++;
                continue;
            }

            if (nums1[up] > nums2[down]) {
                down++;
            } else {
                up ++;
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }



        public static void main(String[] args) {
        IntersectionOfTwoArraysII list = new IntersectionOfTwoArraysII();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersect = list.intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}
