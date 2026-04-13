import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (Binary Search) ===");

        // Unsorted bogie IDs (can handle unsorted input)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // Step 1: Sort the array (MANDATORY for Binary Search)
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs: " + Arrays.toString(bogieIds));

        Scanner sc = new Scanner(System.in);

        // Input search key
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        // Step 2: Binary Search
        boolean found = binarySearch(bogieIds, searchKey);

        // Step 3: Display result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND ✅");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND ❌");
        }

        sc.close();
    }

    // Binary Search Method
    public static boolean binarySearch(String[] arr, String key) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = key.compareTo(arr[mid]);

            if (result == 0) {
                return true; // found
            } else if (result < 0) {
                high = mid - 1; // search left
            } else {
                low = mid + 1; // search right
            }
        }

        return false; // not found
    }
}