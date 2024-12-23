package usa1000cities;

import java.io.*;
import java.util.*;

public class USA1000Cities {

    public static void main(String[] args) throws IOException {
        // Load data from files (unsorted)
        List<IndexedElement<Integer>> numbers = loadNumbersFromFile("Random.txt");

        // Step 1: Linear Search on Unsorted List
        System.out.println("Linear Search on Random.txt (unsorted):");
        linearSearch(numbers, numbers.get(0).value);  // First value of the unsorted list
        linearSearch(numbers, numbers.get(numbers.size() - 1).value);  // Last value of the unsorted list
        linearSearch(numbers, 999999);  // Non-existent value
        linearSearch(numbers, numbers.get(49).value);  // Random value (index 49)
        linearSearch(numbers, numbers.get(99).value);  // Random value (index 99)

        // Step 2: Sort the numbers (using Merge Sort)
        mergeSort(numbers);  // Sort using merge sort

        // Step 3: Binary Search on Sorted List
        System.out.println("\nBinary Search on Random.txt (sorted):");
        binarySearch(numbers, numbers.get(0).value);  // First value (after sorting)
        binarySearch(numbers, numbers.get(numbers.size() - 1).value);  // Last value (after sorting)
        binarySearch(numbers, 999999);  // Non-existent value
        binarySearch(numbers, numbers.get(49).value);  // Random value (index 49)
        binarySearch(numbers, numbers.get(99).value);  // Random value (index 99)
    }

    // Load numbers from Random.txt
    private static List<IndexedElement<Integer>> loadNumbersFromFile(String fileName) throws IOException {
        List<IndexedElement<Integer>> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int index = 0;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            for (String token : tokens) {
                numbers.add(new IndexedElement<>(Integer.parseInt(token.trim()), index++));
            }
        }
        reader.close();
        return numbers;
    }

    // Linear Search for numbers in Random.txt (unsorted)
    private static void linearSearch(List<IndexedElement<Integer>> numbers, Integer target) {
        int steps = 0;
        for (IndexedElement<Integer> element : numbers) {
            steps++;
            if (element.value.equals(target)) {
                System.out.println("Found " + target + " at index " + element.index + " in " + steps + " steps.");
                return;
            }
        }
        System.out.println(target + " not found after " + steps + " steps.");
    }

    // Binary Search for numbers in Random.txt (sorted)
    private static void binarySearch(List<IndexedElement<Integer>> numbers, Integer target) {
        int low = 0, high = numbers.size() - 1;
        int steps = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;
            if (numbers.get(mid).value.equals(target)) {
                System.out.println("Found " + target + " at index " + mid + " in " + steps + " steps.");
                return;
            } else if (numbers.get(mid).value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(target + " not found after " + steps + " steps.");
    }

    // Merge Sort for the list
    private static <T extends Comparable<T>> void mergeSort(List<IndexedElement<T>> list) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        List<IndexedElement<T>> left = new ArrayList<>(list.subList(0, mid));
        List<IndexedElement<T>> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);  // Recursively sort the left half
        mergeSort(right);  // Recursively sort the right half
        merge(list, left, right);  // Merge the sorted halves
    }

    // Merge helper method
    private static <T extends Comparable<T>> void merge(List<IndexedElement<T>> list, List<IndexedElement<T>> left, List<IndexedElement<T>> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).value.compareTo(right.get(j).value) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    // Helper class to store elements along with their original index
    private static class IndexedElement<T> {
        T value;
        int index;

        IndexedElement(T value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
