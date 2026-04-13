import java.util.Arrays;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Array of bogie type names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        // Display original array
        System.out.println("Original Bogie Names: " + Arrays.toString(bogieNames));

        // Sort using built-in method
        Arrays.sort(bogieNames);

        // Display sorted array
        System.out.println("Sorted Bogie Names: " + Arrays.toString(bogieNames));
    }
}
