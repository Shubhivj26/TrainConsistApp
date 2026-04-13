import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    int capacity;

    public Bogie(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Performance Comparison (Loop vs Stream) ===");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie((int)(Math.random() * 100)));
        }

        // ---------------- LOOP APPROACH ----------------
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ---------------- STREAM APPROACH ----------------
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ---------------- RESULTS ----------------
        System.out.println("Loop Result Count   : " + loopResult.size());
        System.out.println("Stream Result Count : " + streamResult.size());

        System.out.println("Loop Time   (ns): " + loopTime);
        System.out.println("Stream Time (ns): " + streamTime);
    }
}