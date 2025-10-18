import java.util.Arrays;
import java.util.Comparator;

public class SelectionSortSolution {
    // In-place selection sort for int arrays
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int tmp = a[i];
                a[i] = a[minIdx];
                a[minIdx] = tmp;
            }
        }
    }

    //with comparator for custom object sorting
    public static <T> void selectionSort(T[] arr, java.util.Comparator<? super T> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (comparator.compare(arr[j], arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                T tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 50, 0, -10, 99};
        System.out.println("Before: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After:  " + Arrays.toString(arr));

        // Example with custom objects
        class Person {  
            String name; 
            int age; 

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }
        Person[] people = {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 20),
            new Person("Eve", 28)
        };
        //With comparator to sort by age
        Comparator<Person> ageComparatorAsc = (p1, p2) -> p1.age - p2.age; // ascending order
        Comparator<Person> ageComparatorDesc = (p1, p2) -> p2.age - p1.age; // descending order
        // Sort by age
        selectionSort(people, ageComparatorAsc);
        System.out.println("Sorted by age (ascending): " + Arrays.toString(people));
        selectionSort(people, ageComparatorDesc);
        System.out.println("Sorted by age (descending): " + Arrays.toString(people));
    }
}

// Time Complexity: O(n^2) because of the nested loops
// Space Complexity: O(1) as we are using constant space
// When to use selection sort: small datasets, when memory write operations are costly.