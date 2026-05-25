import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    Message msg = new Message();

    @Test
    public void testMessageLengthSuccess() {

        assertEquals(
                "Message ready to send.",
                msg.checkMessageLength(
                        "Hi Mike"
                )
        );
    }

    @Test
    public void testRecipientSuccess() {

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell(
                        "+27718693002"
                )
        );
    }

    @Test
    public void testMessageHash() {

        String hash =
                msg.createMessageHash(
                        "0012345678",
                        0,
                        "Hi tonight"
                );

        assertEquals(
                "00:0:HITONIGHT",
                hash
        );
    }
}