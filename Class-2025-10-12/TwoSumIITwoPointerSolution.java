public class TwoSumIITwoPointerSolution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; 
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { -1, -1 }; 
    }

    public static void main(String[] args) {
        TwoSumIITwoPointerSolution sol = new TwoSumIITwoPointerSolution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(numbers, target);
        System.out.println(result[0] + ", " + result[1]);
    }
}

// Time Complexity: O(n) because we traverse the list containing n elements only once. Each lookup in the hash map costs O(1) time on average.
// Space Complexity: O(1) because we are using only a constant amount of extra space
// Auxiliary Space: O(1) as we are not using any extra space that grows with input size