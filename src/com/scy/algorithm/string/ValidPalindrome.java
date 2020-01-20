package com.scy.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名： ValidPalindrome <br>
 * 描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）125
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2020/1/19 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ValidPalindrome {
    // 0 1 2 3    1
    // 0 1 2 3 4    2
    //超出时间限制
    public boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.toLowerCase();
            char c = s1.charAt(i);
            if (!Character.isLetterOrDigit(c))
                continue;
            list.add(c);
        }
        if (list.size() == 0) return true;
        int end = list.size() - 1;
        for (int i = 0; i <= list.size() / 2; i++) {
            if (list.get(i).equals(list.get(end))) {
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end --;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }

    //best
    public boolean isPalindrome3(String s) {
        char[] arr = s.toCharArray();
        int n = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            //   Character.isLetterOrDigit(arr[i])
            if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= '0' && arr[i] <= '9')) {
                arr[n++] = arr[i];
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[n++] = (char) (arr[i] - 'A' + 'a');
            }
        }
        n--;
        while (j < n) {
            if (arr[j++] != arr[n--]) return false;
        }
        return true;
    }

    public boolean isPalindromePro(String s) {
        if (s == null || "".equals(s)||" ".equals(s)) return false;
        char[] arr = s.toCharArray();
        int start =0 ,end = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit(arr[i])) {
                arr[start++] = Character.toLowerCase(arr[i]);
            }
        }
        start --;
        while (end < start) {
            if (arr[end++] != arr[start--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        ValidPalindrome valid = new ValidPalindrome();
        valid.isPalindromePro(s);
        System.out.println(valid.isPalindrome2(s));
    }
}
