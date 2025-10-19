// Bubble Sort - Easy
import java.util.Arrays;
import java.util.Comparator;

public class BubbleSortSolution {
    // Optimized bubble sort (stops early if array is already sorted)
    public static void bubbleSortAsc(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //Add code for descending order bubble sort
    public static void bubbleSortDesc(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //using comparator with string type
    //why use comparator? to define custom sorting order
    // we can pass different comparators to sort in different ways
    public static void bubbleSortComparator(String[] arr, Comparator<String> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    String tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //Using comparator with custom object type
    public static void bubbleSortStudents(Student[] arr, Comparator<Student> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    Student tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        int[] a = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before Asc: " + Arrays.toString(a));
        bubbleSortAsc(a);
        System.out.println("After Asc: " + Arrays.toString(a));
        int[] b = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before Desc: " + Arrays.toString(b));
        bubbleSortDesc(b);
        System.out.println("After Desc: " + Arrays.toString(b));

        String[] strArr = {"banana", "apple", "orange", "grape"};
        //Natural order comparator for ascending order
        Comparator<String> stringComparator = Comparator.naturalOrder();
        System.out.println("Before String Asc: " + Arrays.toString(strArr));
        bubbleSortComparator(strArr, stringComparator);
        System.out.println("After String Asc: " + Arrays.toString(strArr));

        //Reverse order comparator for descending order
        Comparator<String> reverseStringComparator = Comparator.reverseOrder();
        System.out.println("Before String Desc: " + Arrays.toString(strArr));
        bubbleSortComparator(strArr, reverseStringComparator);
        System.out.println("After String Desc: " + Arrays.toString(strArr));

        //Comparator based on string length in ascending order
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        System.out.println("Before String Length Asc: " + Arrays.toString(strArr));
        bubbleSortComparator(strArr, lengthComparator);
        System.out.println("After String Length Asc: " + Arrays.toString(strArr));

        //Comparator based on string length in descending order
        System.out.println("Before String Length Desc: " + Arrays.toString(strArr));
        bubbleSortComparator(strArr, lengthComparator.reversed());
        System.out.println("After String Length Desc: " + Arrays.toString(strArr));

        //Custom comparator: sort by last character
        Comparator<String> lastCharComparator = (s1, s2) -> {
            char lastChar1 = s1.charAt(s1.length() - 1);
            char lastChar2 = s2.charAt(s2.length() - 1);
            return Character.compare(lastChar1, lastChar2);
        };
        System.out.println("Before String Last Char Asc: " + Arrays.toString(strArr));
        bubbleSortComparator(strArr, lastCharComparator);
        System.out.println("After String Last Char Asc: " + Arrays.toString(strArr));

        Student[] students = {
            new Student("Alice", 90),
            new Student("Bob", 85),
            new Student("Charlie", 90),
            new Student("David", 80)
        };
        //Custom comparator: sort student by grade, followed by name
        Comparator<Student> gradeComparator = (s1, s2) -> {
            int cmp = Integer.compare(s1.grade, s2.grade);
            if (cmp == 0) {
                return s1.name.compareTo(s2.name);
            }
            return cmp;
        };
        System.out.println("Before Students Sort:");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.grade);
        }
        bubbleSortStudents(students, gradeComparator);
        System.out.println("After Students Sort:");
        for (Student s : students) {
            System.out.println(s.name + ": " + s.grade);
        }
    }
}

// Time Complexity: O(n^2) in the worst and average cases, O(n) in the best case (when the array is already sorted).
// Space Complexity: O(1) as it is an in-place sorting algorithm.
// When to use bubble sort: when the array is nearly sorted, as it can finish in O(n) time in that case.