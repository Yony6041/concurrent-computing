package kas.concurrrente;

public class TortilleriaStore implements Runnable {
    private WFSnapshot<Integer> snapshot;

    public TortilleriaStore(WFSnapshot<Integer> snapshot) {
        this.snapshot = snapshot;
    }

    @Override
    public void run() {
        // This method can be used to simulate customer interactions, inventory management, etc.
    }

    public void dispatchCustomer(int timestamp) {
        // Implement your logic here to serve the customer based on the timestamp
        // For example, you can check the snapshot to see how many tortillas are available
        Integer[] availableTortillas = snapshot.scan();
        // ... (your dispatch logic here)
    }
}
