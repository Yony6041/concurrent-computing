package kas.concurrrente.snapshotimp;

import java.util.concurrent.atomic.AtomicReferenceArray;

import kas.concurrrente.snapshot.Snapshot;
import kas.concurrrente.stamped.StampedValue;

public class SimpleSnapshot<T> implements Snapshot<T> {
    private AtomicReferenceArray<StampedValue<T>> aTable;

    public SimpleSnapshot(int capacity, T init) {
        aTable = new AtomicReferenceArray<>(capacity);
        for (int i = 0; i < capacity; i++) {
            aTable.set(i, new StampedValue<>(init));
        }
    }

    @Override
    public void update(T value) {
        int me = Integer.parseInt(Thread.currentThread().getName());
        StampedValue<T> oldValue = aTable.get(me);
        StampedValue<T> newValue = new StampedValue<>((oldValue.getStamp()) + 1, value);
        aTable.set(me, newValue);
    }

    @Override
    public T[] scan() {
        T[] result = (T[]) new Object[aTable.length()];
        for (int j = 0; j < aTable.length(); j++) {
            result[j] = aTable.get(j).value();
        }
        return result;
    }
}
