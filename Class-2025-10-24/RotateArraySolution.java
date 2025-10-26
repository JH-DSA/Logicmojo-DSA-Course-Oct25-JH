/**
 * LeetCode 189: Rotate Array - Medium
 * 
 * Description:
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * 
 * Test Cases:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation: rotate 1 step to the right: [7,1,2,3,4,5,6]
 *              rotate 2 steps to the right: [6,7,1,2,3,4,5]
 *              rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation: rotate 1 step to the right: [99,-1,-100,3]
 *              rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArraySolution {
    
    //Time Complexity: O(n*k)
    //Space Complexity: O(1)
    //Pattern: Brute Force
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for(int i=0; i<k; i++) {
            int last = nums[nums.length - 1];
            for(int j=nums.length - 1; j>0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    //optimized approach
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Pattern: Reverse Array
    public void rotateReverseArray(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    // Tracing the reverse array approach:
    // Example: nums = [1,2,3,4,5,6,7], k = 3
    // Step 1: k = k % nums.length = 3 % 7 = 3
    // Step 2: reverse(nums, 0, 6) -> [7,6,5,4,3,2,1]
    // Step 3: reverse(nums, 0, 2) -> [5,6,7,4,3,2,1] 
    // Step 4: reverse(nums, 3, 6) -> [5,6,7,1,2,3,4]
    // Final result: [5,6,7,1,2,3,4]

    //Cyclic Replacements
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    //Pattern: Cyclic Replacements
    public void rotateCyclic(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0; // number of elements rotated
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
    // Tracing the cyclic replacements approach:
    // Example: nums = [1,2,3,4,5,6,7], k = 3
    // Step 1: k = k % n = 3 % 7 = 3
    // Step 2: Start from index 0: 
    //   - Move 1 to index 3, array becomes [1,2,3,1,5,6,7]
    //   - Move 4 to index 6, array becomes [1,2,3,1,5,6,4]
    //   - Move 7 to index 2, array becomes [1,2,7,1,5,6,4]
    //   - Move 3 to index 5, array becomes [1,2,7,1,5,3,4]
    //   - Move 6 to index 1, array becomes [1,6,7,1,5,3,4]
    //   - Move 2 to index 4, array becomes [1,6,7,1,2,3,4]
    //   - Move 5 to index 0, array becomes [5,6,7,1,2,3,4]
    // Final result: [5,6,7,1,2,3,4]
    
    public static void main(String[] args) {
        RotateArraySolution solution = new RotateArraySolution();
        
        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums1, 3);
        System.out.println("Test 1: " + java.util.Arrays.toString(nums1)); 
        System.out.println("Expected Output: [5,6,7,1,2,3,4]");
        
        // Test case 2
        int[] nums2 = {-1, -100, 3, 99};
        solution.rotate(nums2, 2);
        System.out.println("Test 2: " + java.util.Arrays.toString(nums2));
        System.out.println("Expected Output: [3,99,-1,-100]");

        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        solution.rotateReverseArray(nums3, 1);
        System.out.println("Test 3: " + java.util.Arrays.toString(nums3));
        System.out.println("Expected Output: [5,1,2,3,4]");

        // Test case 4
        int[] nums4 = {1, 2, 3, 4, 5, 6};
        solution.rotateCyclic(nums4, 4);
        System.out.println("Test 4: " + java.util.Arrays.toString(nums4));
        System.out.println("Expected Output: [3, 4, 5, 6, 1, 2]");
    }
}