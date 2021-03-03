package bitsnbobs;

import fixture.FakeServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.nio.ByteBuffer;

public class QuoterFakeServerTest {

    FakeServer server = new FakeServer();

    @Test
    public void testGetQuote() {
        StringWriter writer = new StringWriter();
        server.send(ByteBuffer.wrap("BUY 100".getBytes()));
        server.process(writer);
        Assertions.assertEquals("5", writer.toString());
    }
}
