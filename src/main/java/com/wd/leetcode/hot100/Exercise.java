package com.wd.leetcode.hot100;

import java.util.*;

public class Exercise {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int curr = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            res = Math.max(res, curr);
        }
        return res;
    }

    //    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
    //    输出：[[1,6],[8,10],[15,18]]
    //    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int size = res.size();
            if (size > 0 && interval[0] <= res.get(size - 1)[1]) {
                res.get(size - 1)[1] = Math.max(res.get(size - 1)[1], interval[1]);
            } else {
                res.add(interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    //    输入: nums = [1,2,3,4,5,6,7], k = 3
    //    输出: [5,6,7,1,2,3,4]
    //    解释:
    //    向右轮转 1 步: [7,1,2,3,4,5,6]
    //    向右轮转 2 步: [6,7,1,2,3,4,5]
    //    向右轮转 3 步: [5,6,7,1,2,3,4]
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        reverse(nums, 0, length - 1);//先反转全部的元素
        reverse(nums, 0, k - 1);//在反转前k个元素
        reverse(nums, k, length - 1);//接着反转剩余的
    }

    //把数组中从[start，end]之间的元素两两交换,也就是反转
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int rightRes = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightRes;
            rightRes = rightRes * nums[i];
        }
        return answer;
    }

    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstColumn = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        setZeroes(new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 6},
                {7, 8, 9, 1}
        });
        System.out.println();
    }
}
