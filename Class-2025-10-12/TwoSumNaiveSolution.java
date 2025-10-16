public class TwoSumNaiveSolution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSumNaiveSolution sol = new TwoSumNaiveSolution();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = sol.twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}

// Time Complexity: O(n^2) because of the nested loops 
// Space Complexity: O(1) as we are using constant space
// Auxiliary Space: O(1) as we are not using any extra space that grows with input size
