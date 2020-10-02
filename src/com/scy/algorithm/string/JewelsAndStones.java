package com.scy.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 类名： JewelsAndStones <br>
 * 描述： 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 *
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 *
 * 来源：力扣（LeetCode）771
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/2 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null ||S == null || S.length() < 1 || J.length() < 1) return 0;
        char[] chars = S.toCharArray();
        Map<Character, Integer> dict = new HashMap<>();
        for (char c : chars) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (char c : J.toCharArray()) {
            ans += dict.getOrDefault(c,0);
        }
        return ans;
    }

    public int numJewelsInStones2(String J, String S) {
        int jewelsCount = 0;
        Set<Character> jewelsSet = new HashSet<Character>();
        int jewelsLength = J.length(), stonesLength = S.length();
        for (int i = 0; i < jewelsLength; i++) {
            char jewel = J.charAt(i);
            jewelsSet.add(jewel);
        }
        for (int i = 0; i < stonesLength; i++) {
            char stone = S.charAt(i);
            if (jewelsSet.contains(stone)) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }
}
