import java.util.*;

    public class TwoSumHashingSolution {
        public static List<Integer> twoSum(List<Integer> arr, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.size(); i++) {
                int need = target - arr.get(i);
                if (map.containsKey(need)) {
                    return Arrays.asList(map.get(need), i);
                }
                map.put(arr.get(i), i);
            }
            return Collections.emptyList();
        }

        // optional simple test
        public static void main(String[] args) {
            List<Integer> nums = Arrays.asList(9, 10, 12, 2, 7, 11, 15);
            int target = 9;
            System.out.println(twoSum(nums, target)); 
        }
    }

// Time Complexity: O(n) because we traverse the list containing n elements only once. Each lookup in the hash map costs O(1) time on average.
// Space Complexity: O(n) because we store up to n elements in the hash map in the worst case.
// Auxiliary Space: O(n) for the hash map used to store the elements and their indices.