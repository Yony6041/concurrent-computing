package kas.concurrrente;

public class StampedSnap<T> {
    private T value;
    private long stamp;
    private Object snap;

    

       public StampedSnap(T value) {
            this.stamp = System.currentTimeMillis(); // Generate a unique timestamp
            this.value = value;
            this.snap = null;
    }

    public T getValue() {
        return value;
    }

    public long getStamp() {
        return stamp;
    }
}
