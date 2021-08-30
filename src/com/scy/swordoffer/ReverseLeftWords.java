package com.scy.swordoffer;

/**
 * 类名： ReverseLeftWords <br>
 * 描述：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 来源：力扣（LeetCode）剑指 Offer 58 - II. 左旋转字符串
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/8/30 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() == 0) return null;
        String behind = s.substring(0, n);
        String concat = s.concat(behind);
        System.out.println(concat.substring(n, concat.length() - 1));
        return concat.substring(n, concat.length() - 1);
    }

    // 取余操作
    // 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/solution/mian-shi-ti-58-ii-zuo-xuan-zhuan-zi-fu-chuan-qie-p/
    public String reverseLeftWords2(String s, int n) {
        if (s == null || s.length() == 0) return null;
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    public static void main(String[] args) {
        ReverseLeftWords reverse = new ReverseLeftWords();
        System.out.println(reverse.reverseLeftWords2("abcdefg", 6));
    }
}
