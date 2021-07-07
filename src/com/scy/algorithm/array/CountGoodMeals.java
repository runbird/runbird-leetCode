package com.scy.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： CountGoodMeals <br>
 * 描述：大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。
 * 结果需要对 10^9 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * 示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *
 * 示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * 来源：力扣（LeetCode）1711. 大餐计数
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/7 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CountGoodMeals {
    /**
     * 使用哈希表减少重复计算，降低时间复杂度。具体做法是，使用哈希表存储数组中的每个元素的出现次数，遍历到数组 deliciousness 中的某个元素时，
     * 在哈希表中寻找与当前元素的和等于 22 的幂的元素个数，然后用当前元素更新哈希表。由于遍历数组时，哈希表中已有的元素的下标一定小于当前元素的下标，
     * 因此任意一对元素之和等于 22 的幂的元素都不会被重复计算。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-good-meals/solution/da-can-ji-shu-by-leetcode-solution-fvg9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        final int mod = 1000000007;
        int maxVal = 0;
        for (int i : deliciousness) {
            maxVal = Math.max(maxVal, i);
        }
        //int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= (maxVal * 2); sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % mod;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] de = {1, 3, 5, 7, 9};
        CountGoodMeals count = new CountGoodMeals();
        System.out.println(count.countPairs(de));
    }
}
