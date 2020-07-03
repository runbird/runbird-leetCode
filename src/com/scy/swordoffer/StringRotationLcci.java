package com.scy.swordoffer;

import java.util.*;

/**
 * 类名： StringRotationLcci <br>
 * 描述：字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 示例2:
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 *
 * 提示：
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 * 你能只调用一次检查子串的方法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/3 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class StringRotationLcci {
    //runbird
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] chars1 = s1.toCharArray();
        Map<Character, Integer> origin = new HashMap<>(chars1.length);
        for (char c : chars1) {
            origin.put(c, origin.getOrDefault(c, 0) + 1);
        }
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < chars2.length; i++) {
            if (origin.get(chars2[i]) == null) {
                return false;
            } else {
                Integer ch = origin.get(chars2[i]);
                ch --;
                if (ch < 0) return false;
                origin.put(chars2[i], ch);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = origin.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            if (next.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    //TODO good
    public boolean isFlipedString2(String s1, String s2) {
     //   return s1.length() == s2.length() && (s1+s1).indexOf(s2) != -1;
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }


    public static void main(String[] args) {
      //  String s1 = "waterbottle" , s2="erbottlewat";
        String s1 = "aa" , s2="aba";
        StringRotationLcci sr = new StringRotationLcci();
        System.out.println(sr.isFlipedString(s1, s2));
    }
}
