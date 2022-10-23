/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int left = leftBound(nums, target);
        int right = rightBound(nums, target);
        res[0] = left;
        res[1] = right;

        return res;
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        // 此时 target 比所有数都大，返回 -1
        // 由于这里 right 初始化为 nums.length，所以 left 变量的取值区间
        // 是闭区间 [0, nums.length]，
        // 那么我们在检查 nums[left] 之前需要额外判断一下，防止索引越界
        if (left == nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        // 此时 target 比所有数都大，返回 -1
        // 由于这里 right 初始化为 nums.length，所以 left 变量的取值区间是闭区间 [0, nums.length]，
        // 那么我们在检查 nums[left] 之前需要额外判断一下，防止left - 1 < 0
        if (left - 1 < 0) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[right - 1] == target ? right - 1 : -1;
    }
}
// @lc code=end
