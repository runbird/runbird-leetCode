package com.scy.algorithm.string;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 类名： GroupAnagrams <br>
 * 描述：给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 来源：力扣（LeetCode）49. 字母异位词分组
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/7/15 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> res = map.getOrDefault(key, new ArrayList<>());
            res.add(str);
            map.put(key, res);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                    str -> {
                        char[] chars = str.toCharArray();
                        Arrays.sort(chars);
                        return new String(chars);
                    })
                ).values());
    }
}