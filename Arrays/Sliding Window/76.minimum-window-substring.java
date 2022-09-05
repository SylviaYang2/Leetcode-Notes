import java.util.HashMap;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // record the min substring's starting index and length
        int start = 0, maxLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // update the data within the window
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if ((right - left) < maxLen) {
                    start = left;
                    maxLen = right - left;
                }

                char c2 = s.charAt(left);
                left++;
                if (need.containsKey(c2)) {
                    if (need.get(c2).equals(window.get(c2))) {
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
            }
        }

        if (maxLen == (Integer.MAX_VALUE)) {
            return "";
        }
        return s.substring(start, start + maxLen);
    }
}
// @lc code=end
