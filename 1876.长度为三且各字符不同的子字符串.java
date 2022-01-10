import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1876 lang=java
 *
 * [1876] 长度为三且各字符不同的子字符串
 */

//  aababcabc

// @lc code=start
class Solution {
    public int countGoodSubstrings(String s) {

        int n = s.length();
        int count = 0;

        if (n < 3) {
            return count;
        }

        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2)
                    && s.charAt(i + 1) != s.charAt(i + 2)) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
