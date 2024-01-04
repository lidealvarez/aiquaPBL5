package edu.mondragon.os.monitors.barrier;

public class Barrier {

    private int numThreads;
    private int numWaiting;

    public Barrier(int numThreads) {
        this.numThreads = numThreads;
        this.numWaiting = 0;
    }

    public synchronized void waitBarrier() throws InterruptedException {

        numWaiting++;
        if (numWaiting == numThreads) {
            this.notifyAll();
        }
        while (numWaiting < numThreads) {
            this.wait();
        }
    }
}
