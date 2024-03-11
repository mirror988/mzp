package org.gulingjingguai.mzp.algorithm.binarySearch;

/**
 * 二分查找
 * 思想：
 * 1.找出中间元素,中间元素与目标元素比较
 * 2.若目标元素比中间元素小，则在左半部分查找
 * 3.若目标元素比中间元素大，则在右半部分查找
 * 4，如果都没有找到，则返回-1
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int h = binarySearch(array, 0, array.length - 1, 6);
        System.out.println(h);
    }

    private static int binarySearch(int[] array, int start, int end, int target) {

        if (start > end) { // 如果左边界大于右边界，说明目标值不存在于数组中
            return -1;
        }

        int mid = start + (end - start) / 2; // 计算中间索引，防止整数溢出

        if (array[mid] == target) { // 如果找到目标值，则返回其索引
            return mid;
        } else if (array[mid] < target) { // 如果目标值在中间元素的右侧，则在右侧子数组中递归查找
            return binarySearch(array, mid + 1, end, target);
        } else { // 如果目标值在中间元素的左侧，则在左侧子数组中递归查找
            return binarySearch(array, start, mid - 1, target);
        }
    }
}
