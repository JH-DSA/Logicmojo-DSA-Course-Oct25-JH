
/**
 * Solution for LeetCode Problem 33: Search in Rotated Sorted Array - Medium
 * 
 * Problem Statement:
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k 
 * (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Algorithm Approach:
 * Uses modified binary search to handle the rotated sorted array. At each step, determines which half
 * of the array is properly sorted and checks if the target lies within that sorted range.
 * If target is in the sorted half, searches that half; otherwise searches the other half.
 * 
 * Key Logic:
 * - If left half is sorted (nums[l] <= nums[mid]), check if target is within [nums[l], nums[mid])
 * - If right half is sorted (nums[mid] < nums[r]), check if target is within (nums[mid], nums[r]]
 * - Adjust search boundaries based on where target could be located
 * 
 * Time Complexity: O(log n) - Binary search approach
 * Space Complexity: O(1) - Only uses constant extra space
 */
public class RotatedSortedArraySearchSolution {

    // Returns index of target in rotated sorted array nums, or -1 if not found.
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            // left half is sorted
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else { // right half is sorted
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,7,0,1,2};
        int[] nums2 = {6,7,0,1,2,4,5};
        System.out.println(search(nums1, 0)); // expected 4
        System.out.println(search(nums1, 3)); // expected -1
        System.out.println(search(nums2, 6)); // expected 0
        System.out.println(search(nums2, 5)); // expected 6
    }
}

//Time Complexity: O(log n) because we are using a modified binary search approach.
//Space Complexity: O(1) because we are using only a constant amount of extra space.
//Auxiliary Space: O(1) as we are not using any extra space that grows with input size.