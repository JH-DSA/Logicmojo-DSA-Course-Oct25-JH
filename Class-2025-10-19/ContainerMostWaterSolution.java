/**
 * LeetCode 11: Container With Most Water - Medium
 * 
 * Problem Description:
 * You are given an integer array height of length n. There are n vertical lines drawn 
 * such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * 
 * Find two lines that together with the x-axis form a container that can hold the most water.
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * Example:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
 * In this case, the max area of water (blue section) the container can contain is 49.
 * 
 * Constraints:
 * - n == height.length
 * - 2 <= n <= 10^5
 * - 0 <= height[i] <= 10^4
 */
public class ContainerMostWaterSolution {
    
    /**
     * Two Pointer Approach - Optimal Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Algorithm:
     * 1. Use two pointers at the beginning and end of array
     * 2. Calculate area with current pointers
     * 3. Move the pointer with smaller height inward
     * 4. Keep track of maximum area found
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        
        while (left < right) {
            // Calculate current area
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentArea = width * minHeight;
            
            // Update maximum area
            maxWater = Math.max(maxWater, currentArea);
            
            // Move pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
    
    /**
     * Brute Force Approach - For comparison
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int maxAreaBruteForce(int[] height) {
        int maxWater = 0;
        
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                int area = width * minHeight;
                maxWater = Math.max(maxWater, area);
            }
        }
        
        return maxWater;
    }
    
    // Test the solution
    public static void main(String[] args) {
        ContainerMostWaterSolution solution = new ContainerMostWaterSolution();
        
        // Test case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input: [1,8,6,2,5,4,8,3,7]");
        System.out.println("Output: " + solution.maxArea(height1)); // Expected: 49
        
        // Test case 2
        int[] height2 = {1, 1};
        System.out.println("Input: [1,1]");
        System.out.println("Output: " + solution.maxArea(height2)); // Expected: 1
        
        // Test case 3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("Input: [4,3,2,1,4]");
        System.out.println("Output: " + solution.maxArea(height3)); // Expected: 16
    }
}