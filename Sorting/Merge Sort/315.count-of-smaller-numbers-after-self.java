import java.util.ArrayList;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    class Pair {
        int val, index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private Pair[] temp;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        Pair[] arr = new Pair[len];
        temp = new Pair[len];
        count = new int[len];

        // iterate through num and store the values and indexes into pairs
        for (int i = 0; i < len; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        sort(arr, 0, len - 1);

        LinkedList<Integer> res = new LinkedList<>();
        for (int c : count) {
            res.add(c);
        }
        return res;
    }

    private void sort(Pair[] arr, int lo, int hi) {
        if (lo == hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;

        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(Pair[] arr, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组中
        // 以便合并后的结果能够直接存入 arr
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo, j = mid + 1;
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                arr[p] = temp[j++];
            } else if (j == hi + 1) {
                arr[p] = temp[i++];
                count[arr[p].index] += j - mid - 1;
            } else if (temp[i].val > temp[j].val) {
                // 左半边数组已全部被合并
                arr[p] = temp[j++];
            } else if (temp[i].val <= temp[j].val) {
                // 右半边数组已全部被合并
                arr[p] = temp[i++];
                count[arr[p].index] += j - mid - 1;
            }
        }
    }
}
// @lc code=end
