package org.gulingjingguai.mzp.algorithm.selectSort;

import java.util.Arrays;

/**
 * 选择排序
 * 算法思想：
 * 1. 循环遍历，每次将最小的一个元素与要遍历的区间内的第一个元素交换位置
 */
public class DirectSelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        directSelectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void directSelectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }
}
