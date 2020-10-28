package com.scy.algorithm.array;

import java.util.*;

/**
 * 类名： UniqueNumberOfOccurrences <br>
 * 描述：给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 *
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *  
 * 提示：
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）1207
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/28 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            dict.put(arr[i],dict.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer value : dict.values()) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1,1,3};
       // int[] arr = new int[]{1,2};
        UniqueNumberOfOccurrences uo = new UniqueNumberOfOccurrences();
        System.out.println(uo.uniqueOccurrences(arr));
    }
}
