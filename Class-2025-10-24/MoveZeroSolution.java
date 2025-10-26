/**
 * LeetCode 283. Move Zeroes
 * Difficulty: Easy
 * 
 * Given an integer array nums, move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 */
class MoveZeroSolution {

    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public void moveZeroes(int[] nums) {
        int left = 0; // pointer for non-zero elements
        
        // Move all non-zero elements to the front
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        
        // Fill remaining positions with zeros
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
    }

    

    public static void main(String[] args) {
        MoveZeroSolution solution = new MoveZeroSolution();
        
        // Test case 1
        int[] nums1 = {0, 1, 0, 3, 12};
        System.out.println("Before: " + java.util.Arrays.toString(nums1));
        solution.moveZeroes(nums1);
        System.out.println("After: " + java.util.Arrays.toString(nums1));
        
        // Test case 2
        int[] nums2 = {0};
        System.out.println("Before: " + java.util.Arrays.toString(nums2));
        solution.moveZeroes(nums2);
        System.out.println("After: " + java.util.Arrays.toString(nums2));
        
        // Test case 3
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Before: " + java.util.Arrays.toString(nums3));
        solution.moveZeroes(nums3);
        System.out.println("After: " + java.util.Arrays.toString(nums3));
    }
}