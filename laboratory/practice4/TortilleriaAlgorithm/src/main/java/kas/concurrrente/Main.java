import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Initialize the WFSnapshot object with a capacity of 10 and initial value of 0
        WFSnapshot<Integer> wfSnapshot = new WFSnapshot<>(10, 0);

        // Array to hold StampedSnap objects (timestamps)
        StampedSnap<Integer>[] timestamps = new StampedSnap[10];

        // Populate the array with timestamps
        for (int i = 0; i < 10; i++) {
            wfSnapshot.update(i);  // Update the WFSnapshot object with new values
            timestamps[i] = new StampedSnap<>(i);  // Create new StampedSnap objects with timestamps
        }

        // Sort the array based on timestamps
        Arrays.sort(timestamps, (a, b) -> Long.compare(a.getStamp(), b.getStamp()));

        // Dispatch clients based on sorted timestamps
        for (StampedSnap<Integer> stampedSnap : timestamps) {
            System.out.println("Dispatching client with timestamp: " + stampedSnap.getStamp() + " and value: " + stampedSnap.getValue());
        }
    }
}
