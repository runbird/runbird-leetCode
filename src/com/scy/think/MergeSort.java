package com.scy.think;

import java.util.Arrays;

/**
 * 归并排序，思想类似于 树的后续遍历
 * postOrder(root.left)
 * postOrder(root.right)
 */
public class MergeSort {

    private void msort(int[] a, int b, int e, int[] t) {
        // 空区间(b == e) 或 只有一个元素(b + 1 == e)
        // 为了防止b + 1溢出，这里用b >= e先判断一下
        if (b >= e || b + 1 >= e) {
            return ;
        }

        int m = b + ((e - b) >> 1);

        // 类比二叉树分别遍历左子树和右子树。
        msort(a, b, m, t);
        msort(a, m, e, t);

        //临时数组，i指向左数组开头；j指向右数组开头
        //to指向要临时数组t与区间[b, e)对应的位置
        int i = b;
        int j = m;
        int to = b;

        //两个子数组中还有元素
        while (i < m || j < e) {
            //右子数组没有元素 或 左子数组开头的元素小于右子数组开头的元素
            // 只看 ? || ?
            if (j >= e || i < m && a[i] <= a[j]) {
                t[to++] = a[i++];
            } else {
                t[to++] = a[j++];
            }
        }

        // 把合并的结果拷回原来的数组a[]
        a = Arrays.copyOfRange(t, 0, t.length);
//        for (i = b; i <=e ; i++) {
//            a[i] = t[i];
//        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 7};
        int[] b = Arrays.copyOfRange(a,0,a.length);
        Arrays.stream(b).forEach(System.out::println);
    }
}
