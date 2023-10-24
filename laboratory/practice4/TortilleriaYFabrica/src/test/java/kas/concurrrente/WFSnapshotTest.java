package kas.concurrrente;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WFSnapshotTest {

    private WFSnapshot snapshot;

    @BeforeEach
    public void setup() {
        snapshot = new WFSnapshot(15, 10); // Suponiendo que 10 es el tamaño inicial
    }

    @Test
    public void testInitialValue() {
        assertEquals(0, snapshot.get(0), "El valor inicial debe ser 0");
    }

    @Test
    public void testUpdateSingleIndex() {
        snapshot.update(0, 5); // Actualizar el valor en el índice 0 a 5
        assertEquals(5, snapshot.get(0), "El valor actualizado debe ser 5");
    }

    @Test
    public void testUpdateMultipleIndices() {
        snapshot.update(0, 5);
        snapshot.update(1, 10);
        assertEquals(5, snapshot.get(0), "El valor en el índice 0 debe ser 5");
        assertEquals(10, snapshot.get(1), "El valor en el índice 1 debe ser 10");
    }

    @Test
    public void testScan() {
        snapshot.update(0, 5);
        snapshot.update(1, 10);
        int[] result = snapshot.scan();
        assertEquals(5, result[0], "El valor en el índice 0 debe ser 5");
        assertEquals(10, result[1], "El valor en el índice 1 debe ser 10");
    }

    @Test
    public void testScanConsistency() {
        snapshot.update(0, 5);
        snapshot.update(1, 10);
        int[] result1 = snapshot.scan();
        int[] result2 = snapshot.scan();
        assertArrayEquals(result1, result2, "Los resultados de dos escaneos consecutivos deben ser consistentes");
    }
}
