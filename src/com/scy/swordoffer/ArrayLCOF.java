package com.scy.swordoffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 类名： ArrayLCOF <br>
 * 描述：找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 限制：
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）剑指 Offer 03. 数组中重复的数字
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/24 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ArrayLCOF {

    //方法一 set去重
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    //方法二 排序两两对比
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    //方法三 使用临时数组

    /**
     * temp表记录nums数组值对应的索引，如果该索引重复出现，则索引对应的nums有重复
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
            if (temp[nums[i]] > 1) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 放到指定的位置
     * 我们还可以不使用临时数组，我们在遍历的时候把数组nums中的值放到对应的位置上，比如某个元素是5，我们就把他放到nums[5]中，
     * 每次放入的时候查看一下这个位置是否放入了正确的值，如果已经放入了正确的值，就说明重复了，我们直接返回即可。
     * 作者：sdwwld
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/java-de-4chong-jie-fa-by-sdwwld/
     * 作者：derrick_sun
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/yuan-di-zhi-huan-shi-jian-kong-jian-100-by-derrick/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * [2, 3, 1, 0, 2, 5, 3]
     */
    public int findRepeatNumber4(int[] nums) {
        for (int i = 0, temp; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
      //  int[] arr = {0, 1, 2, 2, 4, 5};
      //  int[] arr = {2, 3, 1, 0, 2, 5, 3};
        int[] arr = {1, 2, 3, 2};
        ArrayLCOF lcof = new ArrayLCOF();
        System.out.println(lcof.findRepeatNumber4(arr));
    }
}
