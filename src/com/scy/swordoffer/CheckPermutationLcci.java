package com.scy.swordoffer;

/**
 * 类名： CheckPermutationLcci <br>
 * 描述：给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）面试题 01.02. 判定是否互为字符重排
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/4 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class CheckPermutationLcci {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        //字符范围为 128
        int[] nums = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            nums[s1.charAt(i)]++;
            nums[s2.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (nums[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bad";
        CheckPermutationLcci cpl = new CheckPermutationLcci();
        System.out.println(cpl.CheckPermutation(str1, str2));
    }
}
