package kas.concurrrente;
import java.util.concurrent.atomic.AtomicStampedReference;
import kas.concurrrente.snapshot.Snapshot;

public class WFSnapshot<T> implements Snapshot<T> {
    private AtomicStampedReference<StampedSnap<T>>[] a_table;
    private int capacity;

    public WFSnapshot(int capacity, T init) {
        this.capacity = capacity;
        a_table = (AtomicStampedReference<StampedSnap<T>>[]) new AtomicStampedReference[capacity];
        StampedSnap<T> initial = new StampedSnap<>(init);
        for (int i = 0; i < capacity; i++) {
            a_table[i] = new AtomicStampedReference<>(initial, 0);
        }
    }

    @Override
    public T[] scan() {
        StampedSnap<T>[] snaps = (StampedSnap<T>[]) new StampedSnap[capacity];
        StampedSnap<T> oldSnap;
        StampedSnap<T> newSnap;
        int[] stampHolder = new int[1]; // To hold the stamp

        while (true) {
            boolean clean = true;
            for (int i = 0; i < capacity; i++) {
                oldSnap = a_table[i].get(stampHolder);
                snaps[i] = a_table[i].get(stampHolder);
                if (oldSnap != snaps[i]) {
                    clean = false;
                    break;
                }
            }
            
    if (clean) {
        T[] result = (T[]) new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = snaps[i].getValue();
        }
        System.out.println("Scan successful. Returning snapshot.");
        return result;
    }
        }
    }

    @Override
    public void update(T value) {
        int me = ThreadID.get();
        StampedSnap<T> newSnap = new StampedSnap<>(value);
        a_table[me].set(newSnap, 0); // Assuming the stamp is not needed for this example
    }
}
