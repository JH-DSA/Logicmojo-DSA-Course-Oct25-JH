/**
 * LeetCode 268: Missing Number
 * Difficulty: Easy
 * 
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 * 
 * Example 1:
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 
 * 2 is the missing number in the range since it does not appear in nums.
 * 
 * Example 2:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 
 * 2 is the missing number in the range since it does not appear in nums.
 * 
 * Example 3:
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 
 * 8 is the missing number in the range since it does not appear in nums.
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^4
 * - 0 <= nums[i] <= n
 * - All the numbers of nums are unique.
 */
public class MissingNumberSolution {
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Pattern: Mathematical Formula
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers - Formula: n(n+1)/2
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }

    // Bitwise XOR approach
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int missingNumberXOR(int[] nums) {
        int xorAll = 0;
        int xorArray = 0;
        int n = nums.length;
        
        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }
        
        // XOR all numbers in the array
        for (int num : nums) {
            xorArray ^= num;
        }
        
        // The missing number is the XOR of the two results
        return xorAll ^ xorArray;
    }

    public static void main(String[] args) {
        MissingNumberSolution solution = new MissingNumberSolution();
        
        // Test case 1
        int[] nums1 = {3, 0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums1)); // Output: 2
        
        // Test case 2
        int[] nums2 = {0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums2)); // Output: 2
        
        // Test case 3
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing number: " + solution.missingNumber(nums3)); // Output: 8

        // Test case 4 - Using XOR method
        int[] nums4 = {0, 2, 3};   
        System.out.println("Missing number (XOR): " + solution.missingNumberXOR(nums4)); // Output: 1
    }
}