public class Main {
    public static void main(String[] args) {
        // Initialize the Snapshot object
        WFSnapshot<Integer> snapshot = new WFSnapshot<>(10, 0);

        // Create a TortillaFactory and a TortillaStore
        TortillaFactory factory = new TortillaFactory(snapshot);
        TortillaStore store = new TortillaStore(snapshot);

        // Create threads for the factory and the store
        Thread factoryThread = new Thread(factory);
        Thread storeThread = new Thread(store);

        // Start the threads
        factoryThread.start();
        storeThread.start();

        // Wait for the threads to finish
        try {
            factoryThread.join();
            storeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
