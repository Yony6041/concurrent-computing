public class StampedSnap<T> {
    private T value;
    private long stamp;

    public StampedSnap(T value) {
        this.value = value;
        this.stamp = System.currentTimeMillis(); // Generate a timestamp
    }

    public T getValue() {
        return value;
    }

    public long getStamp() {
        return stamp;
    }
}
