/**
 * LeetCode Problem 167: Two Sum II - Input Array Is Sorted - Easy
 * 
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers
 * be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array
 * [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not use the same
 * element twice.
 * 
 * Your solution must use only constant extra space.
 * 
 * Solution: Two Pointer Approach
 * - Uses two pointers starting from both ends of the sorted array
 * - If sum equals target, return indices (1-indexed)
 * - If sum is less than target, move left pointer right
 * - If sum is greater than target, move right pointer left
 * 
 * @param numbers 1-indexed array of integers sorted in non-decreasing order
 * @param target the target sum to find
 * @return array containing 1-indexed positions of two numbers that sum to target,
 *         or [-1, -1] if no solution exists
 * 
 * Time Complexity: O(n) - single pass through the array
 * Space Complexity: O(1) - constant extra space
 */

public class TwoSumIITwoPointerSolution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; 
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 }; 
    }

    public static void main(String[] args) {
        TwoSumIITwoPointerSolution sol = new TwoSumIITwoPointerSolution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(numbers, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}

// Time Complexity: O(n) because we traverse the list containing n elements only once. Each lookup in the hash map costs O(1) time on average.
// Space Complexity: O(1) because we are using only a constant amount of extra space
// Auxiliary Space: O(1) as we are not using any extra space that grows with input size