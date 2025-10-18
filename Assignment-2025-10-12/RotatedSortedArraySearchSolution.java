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