import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Automated test suite asserting correctness against the assignment requirements matrix.
 */
public class MessageTest {

    @Before
    public void setupDatasetContext() {
        String rawJsonData = "[" +
            "{\"recipient\":\"+27834557896\",\"message\":\"Did you get the cake?\",\"flag\":\"Sent\"}," +
            "{\"recipient\":\"+27838884567\",\"message\":\"Where are you? You are late! I have asked you to be on time.\",\"flag\":\"Stored\"}," +
            "{\"recipient\":\"+27834484567\",\"message\":\"Yohoooo, I am at your gate.\",\"flag\":\"Disregard\"}," +
            "{\"developer\":\"0838884567\",\"message\":\"It is dinner time !\",\"flag\":\"Sent\"}," +
            "{\"recipient\":\"+27838884567\",\"message\":\"Ok, I am leaving without you.\",\"flag\":\"Stored\"}" +
            "]";
        Message.populateFromJSON(rawJsonData);
    }

    @Test
    public void testSentMessagesArrayPopulatedCorrectly() {
        String[] sent = Message.getSentMessages();
        assertEquals("Did you get the cake?", sent[0]);
        assertEquals("It is dinner time !", sent[1]);
    }

    @Test
    public void testLongestStoredMessageExtraction() {
        String expectedLongest = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(expectedLongest, Message.getLongestStoredMessage());
    }

    @Test
    public void testSearchByMessageIDMatchesValue() {
        String expectedPayload = "\"It is dinner time !\"";
        assertEquals(expectedPayload, Message.searchByMessageId("0838884567"));
    }

    @Test
    public void testSearchByRecipientMatchesValues() {
        String expectedResult = "\"Where are you? You are late! I have asked you to be on time.\" \"Ok, I am leaving without you.\"";
        assertEquals(expectedResult, Message.searchAllMessagesForRecipient("+27838884567"));
    }

    @Test
    public void testDeleteMessageEntryByHashKey() {
        String expectedDeleteLog = "Message: \"Where are you? You are late! I have asked you to be on time\" successfully deleted.";
        assertEquals(expectedDeleteLog, Message.deleteMessageByHash("Test Message 2"));
        
        // Assert the deletion changed the active array state
        String longestAfterDeletion = Message.getLongestStoredMessage();
        assertEquals("Ok, I am leaving without you.", longestAfterDeletion);
    }
}