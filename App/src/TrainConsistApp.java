import java.util.ArrayList;
import java.util.List;

// Bogie class (same as previous UCs)
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 54));
        bogies.add(new Bogie("First Class", 24));

        // Calculate total seating capacity
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)          // extract capacity
                .reduce(0, Integer::sum);     // sum all values

        // Display result
        System.out.println("Total Seating Capacity: " + totalSeats);

        // Show original list unchanged
        System.out.println("\nOriginal Bogie List:");
        System.out.println(bogies);
    }
}
