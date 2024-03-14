package org.gulingjingguai.mzp.algorithm.selectSort;

import java.util.Arrays;

/**
 * 堆排序：
 * 算法思想：
 * 1. 遍历所有的非叶子节点
 * 2. 比较当前的非叶子节点和他的子节点的大小，如果子节点中最大的比当前的非叶子节点大，那就交换两个的位置
 * 3. 重复2步骤直到根节点
 * 4. 交换根节点与末尾节点的位置
 * 5. 从根节点开始继续调整大根堆
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        // 遍历所有的非叶子节点
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }


    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //把当前左子树和右子树的数据作比较，更换较大的数据
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                //交换位置
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

}


