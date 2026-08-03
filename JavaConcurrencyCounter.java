public class JavaConcurrencyCounter {

    // First thread counts upward from 0 to 20.
    private static void countUp() {
        System.out.println("\nThread 1: Counting Up");

        for (int i = 0; i <= 20; i++) {
            System.out.println(i);
            pauseThread();
        }
    }

    // Second thread counts downward from 20 to 0.
    private static void countDown() {
        System.out.println("\nThread 2: Counting Down");

        for (int i = 20; i >= 0; i--) {
            System.out.println(i);
            pauseThread();
        }
    }

    // Pauses the current thread so the output can be observed.
    private static void pauseThread() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.err.println("The thread was interrupted.");
        }
    }

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("   Java Concurrency Counter Program");
        System.out.println("======================================");

        Thread firstThread = new Thread(
            JavaConcurrencyCounter::countUp,
            "Count-Up-Thread"
        );

        firstThread.start();

        try {
            // Wait for the first thread to reach 20 and finish.
            firstThread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.err.println("The main thread was interrupted.");
            return;
        }

        Thread secondThread = new Thread(
            JavaConcurrencyCounter::countDown,
            "Count-Down-Thread"
        );

        secondThread.start();

        try {
            // Wait for the second thread to reach 0 and finish.
            secondThread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.err.println("The main thread was interrupted.");
            return;
        }

        System.out.println("\nProgram completed successfully!");
    }
}