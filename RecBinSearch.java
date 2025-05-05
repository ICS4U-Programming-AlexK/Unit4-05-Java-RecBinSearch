import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
/**
 * This program populates an array with random numbers and sorts it.
 * It then allows the user to search for a number using binary search.
 * The process repeats until the user enters 'q'.
 *
 * @author Alex Kapajika
 * @version 1.1
 * @since 2025-03-31
 */
public final class RecBinSearch {
    /** Defining MAX_SIZE. */
    private static final int MAX_SIZE = 10;
    /** Defining MAX_VALUE. */
    private static final int MAX_VALUE = 100;
    /**
     * Private constructor to prevent instantiation.
     */
    private RecBinSearch() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * Main Method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[] numArray = new int[MAX_SIZE];
        for (int counter = 0; counter < MAX_SIZE; counter++) {
            numArray[counter] = random.nextInt(MAX_VALUE);
        }
        Arrays.sort(numArray);
        System.out.println("Sorted array: " + Arrays.toString(numArray));
        System.out.print("Enter the number you want to find: ");
        int userInput = scanner.nextInt();
        int index = recBinSearch(numArray, userInput, 0, numArray.length - 1);
        if (index == -1) {
            System.out.println("The number " + userInput
                    + " is not in the array.");
        } else {
            System.out.println("The number " + userInput
                    + " was found at index " + index + ".");
        }
        scanner.close();
    }
    /**
     * Recursive Binary Search Method.
     *
     * @param arr The array to search in.
     * @param target The number to search for.
     * @param low The lower bound of the search.
     * @param high The upper bound of the search.
     * @return The index of the target if found, otherwise -1.
     */
    public static int recBinSearch(final int[] arr, final int target,
            final int low, final int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return recBinSearch(arr, target, mid + 1, high);
        } else {
            return recBinSearch(arr, target, low, mid - 1);
        }
    }
}
