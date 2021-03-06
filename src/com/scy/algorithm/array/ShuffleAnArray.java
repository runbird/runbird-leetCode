package com.scy.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 类名： ShuffleAnArray <br>
 * 描述：打乱一个没有重复元素的数组。
 *
 * 示例:
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 *
 * 来源：力扣（LeetCode）384
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/1 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ShuffleAnArray {
    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    private int[] params;
    private int[] copyParams;
    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        this.params = nums;
        this.copyParams = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        params = copyParams;
        copyParams = copyParams.clone();
        return params;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> sux = getArray();
        for (int i = 0; i < params.length; i++) {
            int removeIndex = random.nextInt(sux.size());
            params[i] = sux.get(removeIndex);
            sux.remove(removeIndex);
        }
        return params;
    }

    public List<Integer> getArray() {
        List<Integer> sux = new ArrayList<>(params.length);
        for (int i = 0; i < params.length; i++) {
            sux.add(params[i]);
        }
        return sux;
    }
//
//    class Solution {
//        private int[] array;
//        private int[] original;
//
//        Random rand = new Random();
//
//        private int randRange(int min, int max) {
//            return rand.nextInt(max - min) + min;
//        }
//
//        private void swapAt(int i, int j) {
//            int temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
//        }
//
//        public Solution(int[] nums) {
//            array = nums;
//            original = nums.clone();
//        }
//
//        public int[] reset() {
//            array = original;
//            original = original.clone();
//            return original;
//        }
//
//        public int[] shuffle() {
//            for (int i = 0; i < array.length; i++) {
//                swapAt(i, randRange(i, array.length));
//            }
//            return array;
//        }
//    }
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ShuffleAnArray array = new ShuffleAnArray(nums);
        System.out.println(Arrays.toString(array.shuffle()));
        System.out.println(Arrays.toString(array.reset()));
    }
}


