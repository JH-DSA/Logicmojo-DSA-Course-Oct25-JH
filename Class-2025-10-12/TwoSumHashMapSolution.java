/**
 * LeetCode Problem 1: Two Sum - Easy
 * 
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may 
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * Constraints:
 * - 2 <= nums.length <= 10^4
 * - -10^9 <= nums[i] <= 10^9
 * - -10^9 <= target <= 10^9
 * - Only one valid answer exists.
 * 
 * Solution Approach:
 * Uses HashMap to store array elements and their indices as we iterate through
 * the array. For each element, we check if the complement (target - current element)
 * exists in the map. If found, we return the indices. Otherwise, we add the
 * current element and its index to the map.
 * 
 * Time Complexity: O(n) - single pass through the array
 * Space Complexity: O(n) - for the HashMap storage
 * 
 * @param nums Array of integers
 * @param target Target sum value
 * @return Array containing indices of two numbers that sum to target, or null if no solution
 */

import java.util.HashMap;
import java.util.Map;

class TwoSumHashMapSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) { //Time complexity for containsKey is O(1)
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i); //Time complexity for put is O(1)
        }
        return null;
    }
    
    public static void main(String[] args) {
        TwoSumHashMapSolution sol = new TwoSumHashMapSolution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);
        if(result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}

// Time Complexity: O(n) because we traverse the list containing n elements only once. Each lookup in the hash map costs O(1) time on average.
// Space Complexity: O(n) because we store up to n elements in the hash map in the worst case.
// Auxiliary Space: O(n) for the hash map used to store the elements and their indices.