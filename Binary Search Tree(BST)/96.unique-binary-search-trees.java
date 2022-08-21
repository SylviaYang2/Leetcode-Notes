import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        // 如果只有0，或者1个节点，则可能的子树情况为1种
        if (n == 0 || n == 1) {
            return 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftNum = numTrees(i - 1);
            int rightNum = numTrees(n - i);
            count += leftNum * rightNum;
        }
        map.put(n, count);

        return count;
    }
}
// @lc code=end
