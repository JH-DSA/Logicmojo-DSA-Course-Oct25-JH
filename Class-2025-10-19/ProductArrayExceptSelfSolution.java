
/**
 * LeetCode 238: Product of Array Except Self - Medium
 *
 * Given an integer array nums, return an array answer such that answer[i]
 * is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operator.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 * - 2 <= nums.length <= 10^5
 * - -30 <= nums[i] <= 30
 * - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity?
 * (The output array does not count as extra space for space complexity analysis.)
 */

public class ProductArrayExceptSelfSolution {

    public int[] productExceptSelfUsingLeftRightProductApproach(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Calculate left products
        int[] leftProducts = new int[n];
        leftProducts[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right products and final output
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = leftProducts[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    //with 0(1) space
    public int[] productExceptSelfUsingOptimizedSpace(int[] nums) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        int n = nums.length;
        int[] output = new int[n];

        // Step 1: Calculate left products and store in output array
        output[0] = 1; // No elements to the left of the first element
        for (int i = 1; i < n; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate right products on the fly and update output array
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        ProductArrayExceptSelfSolution solution = new ProductArrayExceptSelfSolution();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelfUsingLeftRightProductApproach(nums1);
        System.out.println("Input: [1,2,3,4]");
        System.out.print("Output: [");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i < result1.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        //with optimized space
        int[] result1Opt = solution.productExceptSelfUsingOptimizedSpace(nums1);
        System.out.print("Output: [");
        for (int i = 0; i < result1Opt.length; i++) {
            System.out.print(result1Opt[i]);
            if (i < result1Opt.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");

        // Test case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = solution.productExceptSelfUsingLeftRightProductApproach(nums2);
        System.out.println("Input: [-1,1,0,-3,3]");
        System.out.print("Output: [");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i < result2.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        //with optimized space
        int[] result2Opt = solution.productExceptSelfUsingOptimizedSpace(nums2);
        System.out.print("Output: [");
        for (int i = 0; i < result2Opt.length; i++) {
            System.out.print(result2Opt[i]);
            if (i < result2Opt.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}
