/**
 * LeetCode Problem #1: Two Sum - Easy
 * 
 * Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the two numbers 
 * such that they add up to target. You may assume that each input would have exactly one 
 * solution, and you may not use the same element twice. You can return the answer in any order.
 * 
 * Solution: Two Sum using HashMap
 * This class provides an efficient solution to the Two Sum problem using a HashMap approach.
 * The algorithm iterates through the array once while maintaining a map of previously seen
 * elements and their indices.
 * 
 * Algorithm:
 * 1. Create a HashMap to store element values as keys and their indices as values
 * 2. For each element in the array:
 *    - Calculate the complement (target - current element)
 *    - Check if the complement exists in the HashMap
 *    - If found, return the indices of the complement and current element
 *    - If not found, add the current element and its index to the HashMap
 * 3. Return an empty list if no solution is found
 * 
 * Time Complexity: O(n) - Single pass through the array with O(1) HashMap operations
 * Space Complexity: O(n) - HashMap can store up to n elements in worst case
 * Auxiliary Space: O(n) - Additional space used by the HashMap
 * 
 * @author Generated solution for Two Sum problem
 * @version 1.0
 */
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