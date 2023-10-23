package kas.concurrrente;

import java.util.concurrent.atomic.AtomicLong;

public class StampedSnap<T> {
    private T value;
    private long stamp;
    private Object snap;

    // Atomic counter to ensure unique timestamps
    private static final AtomicLong counter = new AtomicLong(0);

    public StampedSnap(T value) {
        // Generate a unique timestamp
        this.stamp = generateUniqueTimestamp();
        this.value = value;
        this.snap = null;
    }

    // Method to generate a unique timestamp
    private long generateUniqueTimestamp() {
        long currentTime = System.currentTimeMillis();
        long count = counter.incrementAndGet(); // Increment the counter
        return currentTime * 10000 + count; // Combine the current time and counter to form a unique timestamp
    }

    public T getValue() {
        return value;
    }

    public long getStamp() {
        return stamp;
    }

    public Object getSnap() {
        return snap;
    }

    public void setSnap(Object snap) {
        this.snap = snap;
    }
}
