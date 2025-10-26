/**
 * LeetCode 42. Trapping Rain Water - Hard
 * 
 * Problem Statement:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * 
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
 * In this case, 6 units of rain water (blue section) are being trapped.
 * 
 * Example 2:
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * Constraints:
 * - n == height.length
 * - 1 <= n <= 2 * 10^4
 * - 0 <= height[i] <= 3 * 10^4
 */

public class TrappingRainWaterSolution {
    
    //Time Complexity: O(n^2)
    //Space Complexity: O(1)
    //Pattern: Brute Force
    public int trap(int[] height) {
        int total = 0;
        for(int i=1; i<height.length; i++) {
            int left = i-1, right = i+1;
            int maxLeft = height[i], maxRight = height[i];
            while(left >= 0) {
                maxLeft = Math.max(maxLeft, height[left--]);
            }
            while(right < height.length) {
                maxRight = Math.max(maxRight, height[right++]);
            }
            total += Math.min(maxLeft, maxRight) - height[i];
        }
        return total;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Pattern: Two Pointers
    public int trapOptimized(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int total = 0;

        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                total += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                total += maxRight - height[right];
            }
        }
        return total;
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    //Pattern: Precomputed Arrays
    public int trapUsingPrecomputedArrays(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return total;
    }

    public static void main(String[] args) {
        TrappingRainWaterSolution solution = new TrappingRainWaterSolution();
        
        // Test case 1
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Test 1: " + solution.trap(height1)); // Expected: 6
        
        // Test case 2
        int[] height2 = {4,2,0,3,2,5};
        System.out.println("Test 2: " + solution.trap(height2)); // Expected: 9

        // Test case 3
        int[] height3 = {1,0,2,1,0,1,3,8,9,7,6,4,5};
        System.out.println("Test 3: " + solution.trapOptimized(height3)); // Expected: 6

        // Test case 4
        int[] height4 = {2,0,2,1,3,0,1,2,1,2,1,5,2};
        System.out.println("Test 4: " + solution.trapOptimized(height4)); // Expected: 14

        // Test case 5
        int[] height5 = {3,0,1,3,0,5};
        System.out.println("Test 5: " + solution.trapUsingPrecomputedArrays(height5)); // Expected: 8

        // Test case 6
        int[] height6 = {0,2,0,4,0,3,0,5,0,1};
        System.out.println("Test 6: " + solution.trapUsingPrecomputedArrays(height6)); // Expected: 12
    }
}