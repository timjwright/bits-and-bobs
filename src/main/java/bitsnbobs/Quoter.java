package bitsnbobs;

import java.io.StringWriter;
import java.nio.ByteBuffer;

public class Quoter {
    private Pricer pricer = new Pricer();

    public void handleRequest(ByteBuffer buffer, StringWriter result) {
        // do something with pricer
        // hint: StandardCharsets.UTF_8.decode(byteBuffer).toString();

    }
}
