import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left == p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }

                char c2 = s.charAt(left);
                left++;

                if (need.containsKey(c2)) {
                    if (need.get(c2).equals(window.get(c2))) {
                        valid--;
                    }
                    window.put(c2, window.getOrDefault(c2, 0) - 1);
                }
            }
        }

        return res;
    }
}
// @lc code=end
