package edu.mondragon.os.semaphores.readers_writers2;

import java.util.Random;

public class Writer extends Thread {

    private Buffer buffer;
    private Random rand;

    public Writer(Buffer buffer, int id) {
        super("Writer " + id);
        this.buffer = buffer;
        rand = new Random();
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                buffer.write(this.getName(), rand.nextInt(50));
            } catch (InterruptedException e) {
                this.interrupt();
            }
        }
    }
}
