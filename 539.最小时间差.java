import java.util.List;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start
class Solution {
    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (String t : timePoints) {
            treeSet.add(convert(t));
        }

        if (treeSet.size() != timePoints.size()) {
            return 0;
        }

        int prev = -10000;
        int min = 10000;
        for (int t : treeSet) {
            min = Math.min(min, t - prev);
            prev = t;
        }
        min = Math.min(min, treeSet.first() + 1440 - treeSet.last());
        return min;
    }

    private int convert(String t) {
        return Integer.valueOf(t.substring(0, 2)) * 60 + Integer.valueOf(t.substring(3));
    }

}
// @lc code=end
