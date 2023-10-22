import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WFSnapshotTest {
    private WFSnapshot<Integer> wfSnapshot;

    @Before
    public void setUp() {
        wfSnapshot = new WFSnapshot<>(10, 0);
    }

    @Test
    public void testUpdate() {
        wfSnapshot.update(5);
        Integer[] snapshot = wfSnapshot.scan();
        assertEquals("The updated value should be present in the snapshot", Integer.valueOf(5), snapshot[ThreadID.get()]);
    }

    @Test
    public void testScan() {
        for (int i = 0; i < 10; i++) {
            wfSnapshot.update(i);
        }
        Integer[] expectedSnapshot = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] actualSnapshot = wfSnapshot.scan();
        assertArrayEquals("The snapshot should match the expected state", expectedSnapshot, actualSnapshot);
    }
}
