import java.util.HashMap;
import java.util.Map;

class TwoSumHashMapSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) { //Time complexity for containsKey is O(1)
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i); //Time complexity for put is O(1)
        }
        return null;
    }
    
    public static void main(String[] args) {
        TwoSumHashMapSolution sol = new TwoSumHashMapSolution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);
        if(result != null) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}

// Time Complexity: O(n) because we traverse the list containing n elements only once. Each lookup in the hash map costs O(1) time on average.
// Space Complexity: O(n) because we store up to n elements in the hash map in the worst case.
// Auxiliary Space: O(n) for the hash map used to store the elements and their indices.