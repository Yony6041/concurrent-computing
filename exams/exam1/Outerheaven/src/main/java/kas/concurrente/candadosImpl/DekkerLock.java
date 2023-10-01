package kas.concurrente.candadosImpl;

import kas.concurrente.candados.Lock;

public class DekkerLock implements Lock {

    private volatile boolean[] wantsToEnter = {false, false};
    private volatile int turn = 0;

    @Override
    public void lock() {
        int i = Integer.parseInt(Thread.currentThread().getName()); // Nombre del thread (0 o 1)
        int j = 1 - i; // El otro thread

        wantsToEnter[i] = true;

        while (wantsToEnter[j]) {
           if (turn != i) {
        wantsToEnter[i] = false;
        while (turn != i) {
            Thread.yield();  // Hacer que el thread actual ceda su tiempo de ejecución
        }
        wantsToEnter[i] = true;
         }
        }
    }

    @Override
    public void unlock() {
        int i = Integer.parseInt(Thread.currentThread().getName()); 
        turn = 1 - i;
        wantsToEnter[i] = false;
    }
}
