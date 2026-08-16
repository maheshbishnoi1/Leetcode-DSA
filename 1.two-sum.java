/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store the value and its corresponding index
        Map<Integer, Integer> numToIndex = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement exists, we found the pair
            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }
            
            // Otherwise, store the current number and its index
            numToIndex.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (guaranteed not to happen per constraints)
        return new int[] {};
    }
}
// @lc code=end

