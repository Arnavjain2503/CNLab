import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class leakybucket {
    private int bucketCapacity;
    private int leakRate;
    private int currentLoad;
    private Queue<Integer> bucket;

    public leakybucket(int bucketCapacity, int leakRate) {
        this.bucketCapacity = bucketCapacity;
        this.leakRate = leakRate;
        this.currentLoad = 0;
        this.bucket = new LinkedList<>();
    }

    public void addPacket(int packetSize) {
        if (packetSize + currentLoad > bucketCapacity) {
            System.out.println("Packet of size " + packetSize + " cannot be added. Bucket full.");
        } else {
            bucket.add(packetSize);
            currentLoad += packetSize;
            System.out.println("Packet of size " + packetSize + " added to the bucket. Current load: " + currentLoad);
        }
    }

    public void leak() {
        int leaked = Math.min(currentLoad, leakRate);
        currentLoad -= leaked;
        System.out.println("Leaked " + leaked + ". Current load after leaking: " + currentLoad);
    }

    public void simulate() throws InterruptedException {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int packetSize = random.nextInt(10) + 1;
            addPacket(packetSize);
            leak();
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int bucketCapacity = 50;
        int leakRate = 2;
        leakybucket lb = new leakybucket(bucketCapacity, leakRate);
        lb.simulate();
    }
}
