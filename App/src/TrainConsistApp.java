import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App (Safe Search) ===");

        // Try with empty array to test exception
        String[] bogieIds = {};   // ❗ change to {"BG101","BG205"} to test normal flow

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        try {
            boolean found = searchBogie(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie ID " + searchKey + " FOUND ✅");
            } else {
                System.out.println("Bogie ID " + searchKey + " NOT FOUND ❌");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }

    // Method with validation + Binary Search
    public static boolean searchBogie(String[] arr, String key) {

        // ✅ Step 1: Fail-Fast Validation
        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available in the train to search.");
        }

        // ✅ Step 2: Sort before Binary Search
        Arrays.sort(arr);

        // ✅ Step 3: Binary Search Logic
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = key.compareTo(arr[mid]);

            if (result == 0) {
                return true;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}