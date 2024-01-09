package edu.mondragon.os.semaphores.readers_writers2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buffer {

    private List<Integer> list;
    private Semaphore roomEmpty;
    private Semaphore turnstile;
    private Lightswitch readLightswitch;

    public Buffer() {
        this.list = new ArrayList<Integer>();
        this.roomEmpty = new Semaphore(1);
        this.turnstile = new Semaphore(1);
        this.readLightswitch = new Lightswitch();
    }

    public void write(String name, int item) throws InterruptedException {

        this.turnstile.acquire();
        this.roomEmpty.acquire();
        this.list.add(item);
        System.out.println(name + " | >  " + item);
        this.turnstile.release();
        this.roomEmpty.release();
    }

    public void read(String name) throws InterruptedException {

        this.turnstile.acquire();
        this.turnstile.release();

        this.readLightswitch.lock(this.roomEmpty);
        System.out.println(name + " |  < " + list.toString());
        this.readLightswitch.unlock(this.roomEmpty);
    }
}
