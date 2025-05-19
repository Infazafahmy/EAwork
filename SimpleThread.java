
package multithreadapp;

public class SimpleThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getId() + " is executingthe thread.");
    }
    
    public static void main(String[] args) {
        SimpleThread thread1 = new SimpleThread();
        SimpleThread thread2 = new SimpleThread();

        thread1.start(); // Starts thread1
        thread2.start(); // Starts thread2
    }
}

