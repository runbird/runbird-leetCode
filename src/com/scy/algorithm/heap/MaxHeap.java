package com.scy.algorithm.heap;

/**
 * 类名： MaxHeap <br>
 * 描述：TODO <br>
 * 创建日期： 2021/7/20 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class MaxHeap {
    private int[] heap;

    private int len;

    private void push(int num) {
        heap[len++] = num;
        swim(len - 1);
    }

    private int pop() {
        int ret = heap[0];
        heap[0] = heap[--len];
        sink(0);
        return ret;
    }

    //大顶堆 下沉
    private void sink(int i) {
        //临时代替换
        int j = 0;
        //关键点需要一个存储的临时变量t
        int t = heap[i];
        //找到i的左子节点
        while ((j = (i << 1) + 1) < len) {
            //需要在两个后继中找个最大的出来  j < n - 1判断是否有右子结点
            // 如果有，并且右子结点更大，那么j指向右子结点
            if (j < len - 1 && heap[j] < heap[j + 1]) {
                j++;
            }
            //heap[j] 大于 heap[i], heap[i]往后排
            if (heap[j] > t) {
                heap[i] = heap[j];
                i = j;
            } else {
                break;
            }
        }
        //将t放到位置
        heap[i] = t;
    }

    //大顶堆 上浮
    private void swim(int i) {
        int par = i;
        int t = heap[i];
        while (par > 0) {
            par = (i - 1) >> 1;
            if (heap[par] < t) {
                heap[i] = heap[par];
                i = par;
            } else {
                break;
            }
        }
        heap[i] = t;
    }
}
