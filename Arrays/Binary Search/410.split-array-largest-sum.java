/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        // x: speed of loading (weight / day) == nums[i] here
        // f(x): how many days
        // target: days == m here
        int left = 0, right = 1;
        // 计算「子数组各自的和的最大值」的上下界
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
        // 使用「二分查找」确定一个恰当的「子数组各自的和的最大值」，
        // 使得它对应的「子数组的分割数」恰好等于 m
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(nums, mid) <= m) {
                right = mid;
            } else {
                // 如果分割数太多，说明「子数组各自的和的最大值」太小，
                // 此时需要将 splits 调小，「子数组各自的和的最大值」调大
                // 单调递减函数
                // 下一轮搜索的区间是 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length;) {
            int cap = x;
            while (i < nums.length) {
                if (nums[i] > cap) {
                    break;
                } else {
                    cap -= nums[i];
                }
                i++;
            }
            sum++;
        }
        return sum;
    }
}
// @lc code=end
