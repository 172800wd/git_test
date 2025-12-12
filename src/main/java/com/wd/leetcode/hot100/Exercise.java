package main.java.com.wd.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }
}
