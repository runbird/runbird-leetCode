package com.scy.algorithm.sortandsearch;

/**
 * 类名： HeapSort <br>
 * 描述：堆排序 <br>
 * 创建日期： 2021/7/5 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class HeapSort {

    public void heapSort(int[] array) {
        int length = array.length;
        buildMaxHeap(array, length);
        for (int i = 0; i < length; i++) {
            swap(array, 0, length - 1 - i);
            maxHeapfy(array, 0, length - i - 1);
        }
    }

    private void buildMaxHeap(int[] array, int heapSize) {
        //从最后一个非叶子节点开始循环
        for (int i = (heapSize - 2) >> 1; i >= 0; i--) {
            maxHeapfy(array, i, heapSize);
        }
    }

    private void maxHeapfy(int[] array, int i, int heapSize) {
        //堆的特性，左子节点为 root * 2 + 1 ;  右子节点为 root * 2 + 2;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            //把最大值给父节点
            swap(array, largest, i);
            maxHeapfy(array, largest, heapSize);
        }

    }

    private void swap(int[] array, int i, int j) {
        if (i != j) {
            array[i] ^= array[j];
            array[j] ^= array[i];
            array[i] ^= array[j];
        }
    }
}
