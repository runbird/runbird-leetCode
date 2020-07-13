package com.scy.algorithm.string;

/**
 * 类名： PermutationInString <br>
 * 描述：给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）567
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/13 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];

//        for (int i = 0; i < s1.length(); i++) {
//            map1[i] = s1.charAt(i) - 'a';
//        }
//        for (int i = 0; i < s2.length(); i++) {
//            map2[i] = s2.charAt(i) - 'a';
//        }
        //初始化
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        //窗口滑动
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(map1, map2)) {
                return true;
            }
            //滑动核心,每次滑动一位
            map2[s2.charAt(i + s1.length()) - 'a']++;
            map2[s2.charAt(i) - 'a']--;
        }
        return matches(map1, map2);
    }

    private boolean matches(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                return false;
            }
        }
        return true;
    }


    //滑动窗口优化
    // 链接：https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode/
    public boolean checkInclusionPro(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (s1map[i] == s2map[i])
                count++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;
            s2map[r]++;
            if (s2map[r] == s1map[r])
                count++;
            else if (s2map[r] == s1map[r] + 1)
                count--;
            s2map[l]--;
            if (s2map[l] == s1map[l])
                count++;
            else if (s2map[l] == s1map[l] - 1)
                count--;
        }
        return count == 26;
    }

    public static void main(String[] args) {
        //  String s1 = "ab", s2 = "eidbaooo";
        String s1 = "abc", s2 = "dcda";
        PermutationInString pi = new PermutationInString();
        System.out.println(pi.checkInclusion(s1, s2));
    }
}
