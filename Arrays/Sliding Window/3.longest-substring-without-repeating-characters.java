import java.util.Hashwindow;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char c2 = s.charAt(left);
                left++;
                window.put(c2, window.get(c2) - 1);
            }
            // after get rid of the repetitive character (the above while loop)
            res = Math.max(res, right - left);
        }

        return res;
    }
}
// @lc code=end
