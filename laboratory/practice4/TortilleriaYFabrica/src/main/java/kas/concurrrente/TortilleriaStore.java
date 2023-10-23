package kas.concurrrente;

public class TortilleriaStore implements Runnable {
    private WFSnapshot<Integer> snapshot;

    public TortilleriaStore(WFSnapshot<Integer> snapshot) {
        this.snapshot = snapshot;
    }

    @Override
    public void run() {
        System.out.println("Running ...");
    }

    public void dispatchCustomer(int timestamp) {
        Integer[] availableTortillas = snapshot.scan();
        System.out.println("Dispatching ... ");
    }
}
