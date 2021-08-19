package com.scy.swordoffer;

/**
 * 类名： ReversePairs <br>
 * 描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 输入：[1, 2, 3, 4, 0]
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/8/16 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReversePairs {

    /**
     * 解题思路：这是一道归并排序的思路
     * 合并排序提供的信息是“有序性”，那么我们就找到 “逆序性”
     *
     * 当两个有序的子数组合并的时候，如果 a[i] <= a[j]，此时应该执行 t[to++] = a[i++]。
     * 那么左子数组的 [b, i)，以及右子数组 [m, j) 里面的元素肯定都在 a[i] 之前就被合并掉了。
     *
     * 由于 a[i] 在左子数组，所以 a[i] 与 [m, j) 这个范围里面的元素就构成逆序对。 因此，在此时可以得到的逆序对的数目需要加上 j - m。
     */
    int cnt = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int e = nums.length;
        msort(nums, 0, e, new int[nums.length]);
        return cnt;
    }

    public void msort(int[] nums, int b, int e, int[] t) {
        if (b >= e || b + 1 >= e) {
            return;
        }

        int m = b + ((e - b) >> 1);
        msort(nums, b, m, t);
        msort(nums, m, e, t);

        int i = b, j = m, to = b;
        while (i < m || j < e) {
            if (j >= e || i < m && nums[i] <= nums[j]) {
                t[to++] = nums[i++];
                cnt += j - m;
            } else {
                t[to++] = nums[j++];
            }
        }

        for (i = b; i < e; i++) {
            nums[i] = t[i];
        }
    }
}
