package bitsnbobs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.StringWriter;
import java.nio.ByteBuffer;

public class QuoterTest {

    Quoter quoter = new Quoter();

    @Test
    public void testGetQuote() {
        StringWriter writer = new StringWriter();
        quoter.handleRequest(ByteBuffer.wrap("BUY 100".getBytes()), writer);
        Assertions.assertEquals("5", writer.toString());
    }
}
