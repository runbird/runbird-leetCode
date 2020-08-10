package com.scy.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： CountBinarySubstrings <br>
 * 描述：给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 *
 * 示例 1 :
 * 输入: "00110011"
 * 输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *
 * 请注意，一些重复出现的子串要计算它们出现的次数。
 * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 * 示例 2 :
 * 输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 * 注意：
 * s.length 在1到50,000之间。
 * s 只包含“0”或“1”字符。
 *
 * 来源：力扣（LeetCode）696
 * 链接：https://leetcode-cn.com/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/8/10 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CountBinarySubstrings {

    //例如 s = 00111011，可以得到这样的counts 数组：counts={2,3,1,2}。
    //则u(1) v(0) 或者 u(0) v(1), 组合为  min(u,v)
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int left = 0, size = s.length();
        while (left < size) {
            int count = 1;
            while (left < size - 1 && s.charAt(left) == s.charAt(left + 1)) {
                count++;
                left++;
            }
            list.add(count);
            left++;
        }
        int ans = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            ans += Math.min(list.get(i), list.get(i + 1));
        }
        return ans;
    }

    //方法二
    public int countBinarySubstrings2(String s) {
        char[] chs = s.toCharArray();
        int res = 0;
        int cur = chs[0] - '0';
        int count = 1;
        int pre = 0;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] - '0' == cur) {
                count++;
                if (count <= pre)
                    res++;
            } else {
                pre = count;
                count = 1;
                cur = chs[i] - '0';
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        System.out.println(cbs.countBinarySubstrings2("00110011"));
    }
}
