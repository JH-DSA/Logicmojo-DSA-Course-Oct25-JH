/*
LeetCode 26: Remove Duplicates from Sorted Array - Easy

Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: nums = [1,1,2]
Output: 2, nums = [1,2]

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]

Constraints:
- 0 <= nums.length <= 3 * 10^4
- -100 <= nums[i] <= 100
- nums is sorted in ascending order.
*/

import java.util.LinkedHashSet;
import java.util.Set;
public class RemoveDuplicatesSortedArraySolution {

    public int removeDuplicatesUsingSet(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // Java LinkedHashSet or TreeSet to maintain insertion order
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = 0;
        for (Integer num: set) {
            nums[i++] = num;
        }
        return set.size();
    }

    public int removeDuplicatesUsingTwoPointers(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        if (nums.length == 0) return 0;
        int writeIndex = 1;
        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[readIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }
        return writeIndex;
    }
    
    public static void main(String[] args) {
        RemoveDuplicatesSortedArraySolution solution = new RemoveDuplicatesSortedArraySolution();
        
        // Test case 1
        int[] nums1 = {1, 1, 2};
        System.out.println("Original array: " + java.util.Arrays.toString(nums1));
        int result1 = solution.removeDuplicatesUsingSet(nums1);
        System.out.println("Number of unique elements: " + result1);
        System.out.println("Array after removing duplicates: " + java.util.Arrays.toString(java.util.Arrays.copyOf(nums1, result1)));
        
        // Test case 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\nOriginal array: " + java.util.Arrays.toString(nums2));
        int result2 = solution.removeDuplicatesUsingSet(nums2);
        System.out.println("Number of unique elements: " + result2);
        System.out.println("Array after removing duplicates: " + java.util.Arrays.toString(java.util.Arrays.copyOf(nums2, result2)));

        // Test case 3  
        int[] nums3 = {1, 1, 2};
        System.out.println("\nOriginal array: " + java.util.Arrays.toString(nums3));
        int result3 = solution.removeDuplicatesUsingTwoPointers(nums3);
        System.out.println("Number of unique elements: " + result3);
        System.out.println("Array after removing duplicates: " + java.util.Arrays.toString(java.util.Arrays.copyOf(nums3, result3)));

        // Test case 4
        int[] nums4 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\nOriginal array: " + java.util.Arrays.toString(nums4));
        int result4 = solution.removeDuplicatesUsingTwoPointers(nums4);
        System.out.println("Number of unique elements: " + result4);
        System.out.println("Array after removing duplicates: " + java.util.Arrays.toString(java.util.Arrays.copyOf(nums4, result4)));
    }
}