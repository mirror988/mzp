package org.gulingjingguai.mzp.algorithm.doublePoint;

public class TortoiseRabbit {
    public static int findDuplicate(int[] nums) {
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 获取当前元素的绝对值
            int absValue = Math.abs(nums[i]) - 1;

            // 如果对应位置的元素已经为负数，则说明是重复的元素
            if (nums[absValue] < 0) {
                return absValue + 1;
            } else {
                // 否则，将对应位置的元素取负数，表示已经访问过
                nums[absValue] = -nums[absValue];
            }
        }

        // 如果数组中没有重复元素，返回 -1 或其他合适的值
        return -1;
    }

    public static void main(String[] args) {
        // 示例
        int[] nums = {4, 3, 2, 7, 8, 2, 1};
        int result = findDuplicate(nums);
        System.out.println(result);
    }
}
