import java.util.Random;

public class Message {

    private static int totalMessages = 0;

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    // Check message ID
    public boolean checkMessageID(String id) {

        return id.length() <= 10;
    }

    // Check recipient cell
    public String checkRecipientCell(String recipient) {

        if (recipient.matches("^\\+27\\d{9}$")) {

            return "Cell phone number successfully captured.";

        } else {

            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
    }

    // Check message length
    public String checkMessageLength(String message) {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            int extra = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extra
                    + ", please reduce size.";
        }
    }

    // Generate ID
    public String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // Create Hash
    public String createMessageHash(String id,
                                    int num,
                                    String message) {

        String[] words = message.split(" ");

        String firstWord =
                words[0].toUpperCase();

        String lastWord =
                words[words.length - 1].toUpperCase();

        return id.substring(0, 2)
                + ":" + num
                + ":" + firstWord + lastWord;
    }

    // Send Message Option
    public String SentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Press 0 to delete message.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // Return total messages
    public int returnTotalMessages() {

        return totalMessages;
    }

    // Process message
    public void processMessage(String recipient,
                               String message,
                               int num) {

        this.messageID =
                generateMessageID();

        this.recipient =
                recipient;

        this.message =
                message;

        this.messageHash =
                createMessageHash(
                        messageID,
                        num,
                        message
                );

        totalMessages++;

        System.out.println("\nMessage ID: " + messageID);

        System.out.println("Message Hash: " + messageHash);

        System.out.println("Recipient: " + recipient);

        System.out.println("Message: " + message);
    }
}