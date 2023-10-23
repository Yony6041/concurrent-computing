package kas.concurrrente;

public class TortilleriaFactory implements Runnable {
    private WFSnapshot<Integer> snapshot;

    public TortilleriaFactory(WFSnapshot<Integer> snapshot) {
        this.snapshot = snapshot;
    }

    @Override
    public void run() {
        while (true) {
            // Simulate the production of tortillas
            int producedTortillas = (int) (Math.random() * 10);  // Randomly produce up to 10 tortillas
            snapshot.update(producedTortillas);

            try {
                Thread.sleep(1000);  // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
