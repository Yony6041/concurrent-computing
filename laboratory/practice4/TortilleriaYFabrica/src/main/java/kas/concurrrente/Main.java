package kas.concurrrente;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kas.concurrrente.WFSnapshot; 

public class Main {
    public static void main(String[] args) {
        // Initialize the Snapshot object
        WFSnapshot<Integer> snapshot = new WFSnapshot<>(10, 0);

        TortilleriaFactory factory = new TortilleriaFactory(snapshot);
        TortilleriaStore store = new TortilleriaStore(snapshot);

        // Create threads for the factory and the store
        Thread factoryThread = new Thread(factory);
        Thread storeThread = new Thread(store);

        // Create a lock for controlling customer access
        Lock customerLock = new ReentrantLock();

        // Create an array to store timestamps
        int[] timestamps = new int[10];  // Assuming 10 customers

        // Start the threads
        factoryThread.start();
        storeThread.start();

        // Simulate customer arrivals and populate the timestamps array
        for (int i = 0; i < 10; i++) {
            customerLock.lock();
            try {
                timestamps[i] = (int) (Math.random() * 100);  // Generate a random timestamp
            } finally {
                customerLock.unlock();
            }
        }

        // Sort the timestamps array
        Arrays.sort(timestamps);

        // Dispatch customers based on sorted timestamps
        for (int i = 0; i < 10; i++) {
            customerLock.lock();
            try {
                // Dispatch customer with timestamp[i]
                store.dispatchCustomer(timestamps[i]);
            } finally {
                customerLock.unlock();
            }
        }

        // Wait for the threads to finish
        try {
            factoryThread.join();
            storeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
