package com.scy.algorithm.array;

/**
 * 类名： RotateArray <br>
 * 描述：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）189
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/1/9 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class RotateArray {

    //时间复杂度：O(n*k) 。每个元素都被移动 1 步（O(n)） k次（O(k)） 。
    //空间复杂度：O(1) 。没有额外空间被使用。
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }

    //时间复杂度： O(n) 。将数字放到新的数组中需要一遍遍历，另一边来把新数组的元素拷贝回原数组。
    //空间复杂度： O(n)。另一个数组需要原数组长度的空间。
    public void rotate2(int[] nums, int k) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newArray, 0, nums, 0, nums.length);
    }

    //时间复杂度：O(n) 。只遍历了每个元素一次。
    //空间复杂度：O(1) 。使用了常数个额外空间。
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        RotateArray rotate = new RotateArray();
        rotate.rotate3(nums, 3);
    }
}
