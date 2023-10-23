package kas.concurrrente;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

public class TortilleriaStore implements Runnable {
    private WFSnapshot<Integer> snapshot;
    private final AtomicLongArray timestamps; // Array to hold timestamps

    public TortilleriaStore(WFSnapshot<Integer> snapshot, int capacity) {
        this.snapshot = snapshot;
        this.timestamps = new AtomicLongArray(capacity); // Initialize with the number of customers
    }

    @Override
    public void run() {
        System.out.println("Running ...");
        sortAndDispatch(); // Call this after all timestamps are set
    }

    public void setTimestamp(int index, long timestamp) {
        timestamps.set(index, timestamp); // Set timestamp for a customer
    }

    public long getTimestamp(int index) {
        return timestamps.get(index); // Get timestamp for a customer
    }

    public void sortAndDispatch() {
        long[] sortedTimestamps = new long[timestamps.length()];
        for (int i = 0; i < timestamps.length(); i++) {
            sortedTimestamps[i] = timestamps.get(i);
        }
        Arrays.sort(sortedTimestamps); // Sort the timestamps

        for (long timestamp : sortedTimestamps) {
            dispatchCustomer((int) timestamp); // Dispatch customer with this timestamp
        }
    }

    public void dispatchCustomer(int timestamp) {
        Integer[] availableTortillas = snapshot.scan();
        System.out.println("Dispatching customer with timestamp: " + timestamp);
    }
}
