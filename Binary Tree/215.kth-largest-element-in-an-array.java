import java.util.PriorityQueue;
import java.util.Random;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    // Method 1: Priority Queue
    // public int findKthLargest(int[] nums, int k) {
    // PriorityQueue<Integer> queue = new PriorityQueue<>();
    // for (int i = 0; i < nums.length; i++) {
    // queue.offer(nums[i]);
    // if (queue.size() > k) {
    // queue.poll();
    // }
    // }

    // return queue.peek();
    // }

    // Method 2: Quick Select
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);

        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;
        int p = 0;

        while (lo <= hi) {
            p = partition(nums, lo, hi);

            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                break;
            }
        }
        return nums[p];
    }

    private int partition(int[] nums, int lo, int hi) {
        // Method 1
        // int pivot = nums[lo];
        // int i = lo + 1, j = hi;

        // while (i <= j) {
        // while (i < hi && nums[i] <= pivot) {
        // i += 1;
        // }

        // while (j > lo && nums[j] > pivot) {
        // j -= 1;
        // }

        // if (i >= j) {
        // break;
        // }
        // swap(nums, i, j);
        // }

        // swap(nums, j, lo);
        // return j;

        // Method 2
        int pivot = nums[hi];
        int pIndex = lo;

        for (int i = lo; i < hi; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex);
                pIndex += 1;
            }
        }
        swap(nums, pIndex, hi);
        return pIndex;
    }

    private void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();

        for (int i = 0; i < nums.length; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end
