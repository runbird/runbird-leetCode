package com.scy.algorithm.string;

import java.util.*;

/**
 * 类名： ReverseWordsInAString <br>
 * 描述：给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 *
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）151
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/7/17 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReverseWordsInAString {

    //方法一
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    //方法二
    public String reverseWords2(String s) {
       // s = s.trim();
        int left = 0 ,right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if ((sb.length() != 0 && c == ' ')) {
                deque.offerFirst(sb.toString());
                sb.setLength(0);
            } else if (c != ' ') {
                sb.append(c);
            }
            left++;
        }
        //扫尾，最后一组push
        deque.offerFirst(sb.toString());
        return String.join(" ",deque);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String s2 = "  hello world!  ";
        String s3 = "a good   example";
        ReverseWordsInAString rws = new ReverseWordsInAString();
        System.out.println(rws.reverseWords2(s));
        System.out.println(rws.reverseWords2(s2));
        System.out.println(rws.reverseWords2(s3));
    }
}
