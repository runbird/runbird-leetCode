package com.scy.swordoffer;

/**
 * 类名： MinArray <br>
 * 描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <p>
 * 来源：力扣（LeetCode）剑指 Offer 11. 旋转数组的最小数字
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 <br>
 * 创建日期： 2021/9/1 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MinArray {

    //非有效排序的二分搜索使用
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) {
                j = mid;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        //int[] numbers = new int[]{3, 4, 5, 1, 2};
        int[] numbers = new int[]{2, 2, 2, 0, 1};
        MinArray rotate = new MinArray();
        System.out.println(rotate.minArray(numbers));
    }
}
