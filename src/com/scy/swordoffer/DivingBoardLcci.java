package com.scy.swordoffer;

import java.util.*;

/**
 * 类名： DivingBoardLcci <br>
 * 描述：你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * <p>
 * 提示：
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * <p>
 * 来源：力扣（LeetCode）面试题 16.11. 跳水板
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/8 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class DivingBoardLcci {
    //输入:
    //1,1, 100000
    //1
    //100000
    //输出
    //[100000,100000,100000,100000,100000.....
    //预期结果
    //[100000]
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[k];
        if (shorter == longer) return new int[]{shorter * k};
        int[] ans = new int[k + 1];
        for (int s = 0; s <= k; s++) {
            int l = k - s;
            ans[s] = s * longer + l * shorter;
        }
        return ans;
    }

    public static void main(String[] args) {
        int shorter = 1, longer = 2 , k = 3;
        //int shorter = 1, longer = 0 , k = 1;
        DivingBoardLcci dbl = new DivingBoardLcci();
        int[] ints = dbl.divingBoard(shorter, longer, k);
        System.out.println(Arrays.toString(ints));
    }
}
