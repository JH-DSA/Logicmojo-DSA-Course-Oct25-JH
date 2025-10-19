// Insertion Sort - Easy
public class InsertionSortSolution {

    // Single method that performs insertion sort on the provided array and prints result
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    //using comparator
    public static <T> void insertionSortWithComparator(T[] arr, java.util.Comparator<? super T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    //print array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(' ');
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //before sorting
        int[] arr = {9, -5, -2, 4, 6, 1, 3, 22, 29, 10, -6, 0, 8, 9}; // static input provided from main
        printArray(arr);
        insertionSort(arr);
        //after sorting
        printArray(arr);

        //with comparator
        String[] strArr = {"banana", "apple", "orange", "kiwi", "grape"};
        System.out.println("Before Comparator Sort: " + java.util.Arrays.toString(strArr));
        insertionSortWithComparator(strArr, java.util.Comparator.naturalOrder());
        System.out.println("After Comparator Sort: " + java.util.Arrays.toString(strArr));
    }
}

// Time Complexity: O(n^2) in the worst and average cases due to nested loops.
// Space Complexity: O(1) as we are using constant space.
// When to use insertion sort: when the array is mostly sorted or when the dataset is small.