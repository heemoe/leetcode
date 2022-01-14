import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

//  "aab"\n2
// "ababbc"\n2

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        char[] charArr = s.toCharArray();
        int result = 0, start = 0, end = 1, n = charArr.length;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // 所有子串
        // hashmap 统计每个字符出现次数

        while (start < n) {

            charFrequencyMap.put(charArr[start], 1);

            //
            while (end < n && !(charArr[end - 1] != charArr[end] && charFrequencyMap.get(charArr[end - 1]) < k)) {

                // 循环把end加进window中
                char next = charArr[end++];
                if (charFrequencyMap.containsKey(next)) {
                    // 有则 cnt ++；
                    charFrequencyMap.put(next, charFrequencyMap.get(next) + 1);

                } else {
                    // 没有则put进去
                    charFrequencyMap.put(next, 1);
                }

            }

            result = Math.max(result, end - start);
            charFrequencyMap.put(charArr[end - 1], charFrequencyMap.get(charArr[end - 1]) - 1);

            start++;
        }

        return result;

    }
}
// @lc code=end
