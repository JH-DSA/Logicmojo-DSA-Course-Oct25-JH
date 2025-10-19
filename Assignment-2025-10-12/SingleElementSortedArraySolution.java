/**
 * Solution for LeetCode Problem 540: Single Element in a Sorted Array - Medium
 * 
 * Problem Statement:
 * You are given a sorted array consisting of only integers where every element appears exactly 
 * twice, except for one element which appears exactly once.
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * Algorithm:
 * Uses binary search to find the single element by analyzing the parity of indices.
 * In a normal array where all elements appear twice, the first occurrence of each pair
 * is at even index and second occurrence is at odd index. The single element breaks
 * this pattern.
 * 
 * Key Insight:
 * - If mid is paired with left element and (mid-1) is even, single element is on right
 * - If mid is paired with left element and (mid-1) is odd, single element is on left
 * - If mid is paired with right element and mid is even, single element is on right
 * - If mid is paired with right element and mid is odd, single element is on left
 * 
 * Edge Cases:
 * - Single element array
 * - Single element at the beginning
 * - Single element at the end
 * 
 * @param n the size of the array
 * @param arr the sorted array containing pairs and one single element
 * @return the single element that appears only once
 * 
 * Time Complexity: O(log n) - binary search approach
 * Space Complexity: O(1) - constant extra space
 */
import java.util.*;

public class SingleElementSortedArraySolution {

    public int singleElement(int n, List<Integer> arr) {
    if (n == 1) return arr.get(0);

    if (!arr.get(0).equals(arr.get(1))) return arr.get(0); 
    if (!arr.get(n - 1).equals(arr.get(n - 2))) return arr.get(n - 1); 

    int start = 0, end = n - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;

        boolean isLeftSame = mid > 0 && arr.get(mid).equals(arr.get(mid - 1));
        boolean isRightSame = mid < n - 1 && arr.get(mid).equals(arr.get(mid + 1));

        if (!isLeftSame && !isRightSame) {
            return arr.get(mid);
        }
        if (isLeftSame) {
            if ((mid - 1) % 2 == 0) {
                start = mid + 1;
            } else {
                end = mid - 2;
            }
        }
        else if (isRightSame) {
            if (mid % 2 == 0) {
                start = mid + 2;
            } else {
                end = mid - 1;
            }
        }
    }
    return -1;
    }

    public static void main(String[] args) {
        SingleElementSortedArraySolution solution = new SingleElementSortedArraySolution();
        List<Integer> arr = Arrays.asList(-1, -1, 0, 0, 1, 1, 2, 2, 3, 4, 4);
        int n = arr.size();
        int result = solution.singleElement(n, arr);
        System.out.println("The single element is: " + result);
    }
}

// Time Complexity: O(log n) because we are using a binary search approach.
// Space Complexity: O(1) because we are using only a constant amount of extra space.
// Auxiliary Space: O(1) as we are not using any extra space that grows with input size.