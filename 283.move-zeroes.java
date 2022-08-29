/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // remove all the zeroes first and fill the end of the array
        // with zeroes
        int p = removeElement(nums, 0);
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }

    }

    private int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
// @lc code=end
