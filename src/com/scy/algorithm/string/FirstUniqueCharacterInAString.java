package com.scy.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名： FirstUniqueCharacterInAString <br>
 * 描述：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）387
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 创建日期： 2020/1/17 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
           // char c = s.charAt(i);
//            if (map.containsKey(chars[i])) {
//                map.put(chars[i], -1);
//            } else {
//                map.put(chars[i], i);
//            }
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString change = new FirstUniqueCharacterInAString();
        System.out.println(change.firstUniqChar("loveleetcode"));
    }
}
