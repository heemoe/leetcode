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
        int k = 3;
        int n = s.length();
        int start = 0;
        int count = 0;

        if (n < 3) {
            return count;
        }

        while (start < n - k + 1) {

            HashSet<String> set = new HashSet<>();
            int i = start;
            while (i < start + k) {
                char temp = s.charAt(i);
                if (set.contains(temp + "")) {
                    break;
                }
                set.add(temp + "");
                i++;
            }

            if (set.size() == 3) {
                count++;
            }
            start++;
        }
        return count;
    }
}
// @lc code=end
