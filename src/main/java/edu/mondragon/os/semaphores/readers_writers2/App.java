package edu.mondragon.os.semaphores.readers_writers2;

/**
 * readers_writers2
 *
 */
public class App {

    final static int NREADERS = 3;
    final static int NWRITERS = 2;

    private Buffer buffer;
    private Reader readers[];
    private Writer writers[];

    public App() {
        buffer = new Buffer();

        readers = new Reader[NREADERS];
        writers = new Writer[NWRITERS];
    }

    public void createThreads() {
        for (int i = 0; i < NREADERS; i++) {
            readers[i] = new Reader(buffer, i);
        }
        for (int i = 0; i < NWRITERS; i++) {
            writers[i] = new Writer(buffer, i);
        }
    }

    public void startThreads() {
        for (int i = 0; i < NWRITERS; i++) {
            writers[i].start();
        }
        for (int i = 0; i < NREADERS; i++) {
            readers[i].start();
        }
    }

    public void interruptThreads() {
        for (int i = 0; i < NWRITERS; i++) {
            writers[i].interrupt();
        }
        for (int i = 0; i < NREADERS; i++) {
            readers[i].interrupt();
        }
    }

    public void waitEndOfThreads() {
        try {
            for (int i = 0; i < NWRITERS; i++) {
                writers[i].join();
            }
            for (int i = 0; i < NREADERS; i++) {
                readers[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        App app = new App();

        app.createThreads();
        app.startThreads();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        app.interruptThreads();
        app.waitEndOfThreads();
    }
}
