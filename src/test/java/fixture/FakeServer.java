package fixture;

import bitsnbobs.Quoter;

import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

public class FakeServer {

    private final LinkedBlockingQueue<ByteBuffer> queue = new LinkedBlockingQueue<>();
    private final Quoter server = new Quoter();

    public void send(ByteBuffer buffer) {
        try {
            queue.put(buffer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void process(StringWriter writer) {
        new Thread(()->{
            while ( ! queue.isEmpty() ) {
                try {
                    // This is to simulate transition time
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                server.handleRequest(queue.poll(), writer);
            }
        }).start();
    }
}
