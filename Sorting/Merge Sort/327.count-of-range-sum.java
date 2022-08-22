/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 */

// @lc code=start
class Solution {

    private int lower, upper;
    private int count = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;

        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + (long) nums[i];
        }
        sort(preSum);
        return count;
    }

    private long[] temp;

    public void sort(long[] nums) {
        temp = new long[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(long[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(long[] nums, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        // 在合并有序数组之前加点私货（这段代码会超时）
        // for (int i = lo; i <= mid; i++) {
        // for (int j = mid + 1; j <= hi; k++) {
        // // 寻找符合条件的 nums[j]
        // long delta = nums[j] - nums[i];
        // if (delta <= upper && delta >= lower) {
        // count++;
        // }
        // }
        // }

        // 进行效率优化
        // 维护左闭右开区间 [start, end) 中的元素和 nums[i] 的差在 [lower, upper] 中
        int start = mid + 1, end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            // convert the nested for loops above to while loops
            while (start <= hi && (nums[start] - nums[i] < lower)) {
                start++;
            }
            while (end <= hi && (nums[end] - nums[i]) <= upper) {
                end++;
            }
            count += end - start;
        }

        int i = lo;
        int j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                nums[p] = temp[j++];
            } else if (j == hi + 1) {
                nums[p] = temp[i++];
            } else if (temp[i] > temp[j]) {
                // 左半边数组已全部被合并
                nums[p] = temp[j++];
            } else if (temp[i] <= temp[j]) {
                // 右半边数组已全部被合并
                nums[p] = temp[i++];
            }
        }
    }
}
// @lc code=end
