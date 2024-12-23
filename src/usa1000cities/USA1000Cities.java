package usa1000cities;

import java.io.*;
import java.util.*;

public class USA1000Cities {

    public static void main(String[] args) throws IOException {
        // Load data from files
        List<IndexedElement<Integer>> numbers = loadNumbersFromFile("Random.txt");
        List<IndexedElement<String>> states = loadStatesFromFile("GPSdata.txt");

        // Perform Linear Search on Random.txt (unsorted) - Numbers
        System.out.println("Linear Search on Random.txt (unsorted) :");
        linearSearch(numbers, 73074);  // First value
        linearSearch(numbers, 69621);  // Random value
        linearSearch(numbers, 999999); // Non-existent value
        linearSearch(numbers, 243991); // Another random value

        // Perform Binary Search on Random.txt (sorted) - Numbers
        Collections.sort(numbers, new IndexedElementComparator<>());  // Sort using the comparator
        System.out.println("\nData sorted successfully: " + isSorted(numbers));  // Verify sorting
        System.out.println("\nBinary Search on Random.txt (sorted) :");
        binarySearch(numbers, 73074);  // First value
        binarySearch(numbers, 69621);  // Random value
        binarySearch(numbers, 999999); // Non-existent value
        binarySearch(numbers, 243991); // Another random value

        System.out.println("\n========================================================");

        // Perform Linear Search on GPSdata.txt (unsorted) - States
        System.out.println("\nLinear Search on GPSdata.txt (unsorted) :");
        linearSearchStates(states, "Oklahoma"); // First state
        linearSearchStates(states, "California"); // Random state
        linearSearchStates(states, "London"); // Non-existent state
        linearSearchStates(states, "Texas"); // Another random state

        // Perform Binary Search on GPSdata.txt (sorted) - States
        Collections.sort(states, new IndexedElementComparator<>());  // Sort using the comparator
        System.out.println("\nData sorted successfully: " + isSorted(states));  // Verify sorting
        System.out.println("\nBinary Search on GPSdata.txt (sorted) :");
        binarySearchStates(states, "Oklahoma"); // First state
        binarySearchStates(states, "California"); // Random state
        binarySearchStates(states, "Paris"); // Non-existent state
        binarySearchStates(states, "Texas"); // Another random state
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

    // Load states from GPSdata.txt
    private static List<IndexedElement<String>> loadStatesFromFile(String fileName) throws IOException {
        List<IndexedElement<String>> states = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int index = 0;
        while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            states.add(new IndexedElement<>(tokens[tokens.length - 1].trim(), index++)); // State is the last token
        }
        reader.close();
        return states;
    }

    // Linear Search for numbers in Random.txt (unsorted)
    private static void linearSearch(List<IndexedElement<Integer>> numbers, int target) {
        int steps = 0;
        for (IndexedElement<Integer> element : numbers) {
            steps++;
            if (element.value == target) {
                System.out.println("Found " + target + " at index " + element.index + " in " + steps + " steps.");
                return;
            }
        }
        System.out.println(target + " not found after " + steps + " steps.");
    }

    // Binary Search for numbers in Random.txt (sorted)
    private static void binarySearch(List<IndexedElement<Integer>> numbers, int target) {
        int low = 0, high = numbers.size() - 1;
        int steps = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;
            if (numbers.get(mid).value == target) {
                System.out.println("Found " + target + " at index " + numbers.get(mid).index + " in " + steps + " steps.");
                return;
            } else if (numbers.get(mid).value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(target + " not found after " + steps + " steps.");
    }

    // Linear Search for states in GPSdata.txt (unsorted)
    private static void linearSearchStates(List<IndexedElement<String>> states, String target) {
        int steps = 0;
        Iterator<IndexedElement<String>> iterator = states.iterator();  // Using Iterator for iteration
        while (iterator.hasNext()) {
            steps++;
            String state = iterator.next().value;
            if (state.equalsIgnoreCase(target)) {
                System.out.println("Found state '" + target + "' in " + steps + " steps.");
                return;
            }
        }
        System.out.println("State '" + target + "' not found after " + steps + " steps.");
    }

    // Binary Search for states in GPSdata.txt (sorted)
    private static void binarySearchStates(List<IndexedElement<String>> states, String target) {
        int low = 0, high = states.size() - 1;
        int steps = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            steps++;
            if (states.get(mid).value.equalsIgnoreCase(target)) {
                System.out.println("Found state '" + target + "' at index " + mid + " in " + steps + " steps.");
                return;
            } else if (states.get(mid).value.compareToIgnoreCase(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("State '" + target + "' not found after " + steps + " steps.");
    }

    // Helper method to check if the list is sorted
    private static <T extends Comparable<T>> boolean isSorted(List<IndexedElement<T>> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).value.compareTo(list.get(i).value) > 0) {
                return false;
            }
        }
        return true;
    }

    // Comparator for sorting IndexedElement by value
    private static class IndexedElementComparator<T extends Comparable<T>> implements Comparator<IndexedElement<T>> {
        public int compare(IndexedElement<T> o1, IndexedElement<T> o2) {
            return o1.value.compareTo(o2.value);
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
