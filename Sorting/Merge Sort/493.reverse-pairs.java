/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    int count = 0;
    private int[] temp;

    public int reversePairs(int[] nums) {
        sort(nums);
        return count;
    }

    // avoid re-creating temp[] in the recusion function
    public void sort(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;

        sort(nums, lo, mid);
        sort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 nums
        for (int i = lo; i <= hi; i++) {
            temp[i] = nums[i];
        }

        int i = lo, end = mid + 1;

        // Method 1
        // while (i <= mid && end <= hi) {
        // if ((long) nums[i] > (long) 2 * nums[end]) {
        // count += mid - i + 1; // i to mid are all satisfied
        // end++;
        // } else {
        // i++;
        // }
        // }

        // Method 2
        while (i <= mid) {
            // nums 中的元素可能较大，乘 2 可能溢出，所以转化成 long
            while (end <= hi && (long) nums[i] > (long) 2 * nums[end]) {
                end++;
            }
            count += end - mid - 1;
            i++;
        }

        i = lo;
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
