package com.scy.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类名： FindCommonCharacters <br>
 * 描述：给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 来源：力扣（LeetCode）1002
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/10/14 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq,Integer.MAX_VALUE);

        for (String words : A) {
            int[] freq = new int[26];
            for (int i = 0; i < words.length(); i++) {
                freq[words.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(freq[i], minFreq[i]);
            }
        }

        List<String> ans = new ArrayList<>();
//        for (int i = 0; i < 26; i++) {
//            for (int j = 0; j < minFreq[i]; j++) {
//                ans.add(String.valueOf((char) (i + 'a')));
//            }
//        }
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] str = {"bella","label","roller"};
        FindCommonCharacters find = new FindCommonCharacters();
        System.out.println(find.commonChars(str));
    }
}
