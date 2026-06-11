import java.util.Scanner;

/**
 * Main application class coordinating user registration, login workflows, 
 * and advanced parallel array communication options.
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        // Target assignment data repository string
        String rawJsonData = "[" +
            "{\"recipient\":\"+27834557896\",\"message\":\"Did you get the cake?\",\"flag\":\"Sent\"}," +
            "{\"recipient\":\"+27838884567\",\"message\":\"Where are you? You are late! I have asked you to be on time.\",\"flag\":\"Stored\"}," +
            "{\"recipient\":\"+27834484567\",\"message\":\"Yohoooo, I am at your gate.\",\"flag\":\"Disregard\"}," +
            "{\"developer\":\"0838884567\",\"message\":\"It is dinner time !\",\"flag\":\"Sent\"}," +
            "{\"recipient\":\"+27838884567\",\"message\":\"Ok, I am leaving without you.\",\"flag\":\"Stored\"}" +
            "]";
        
        // Dynamic loading processing setup
        Message.populateFromJSON(rawJsonData);

        // ===== REGISTER =====
        System.out.println("===== REGISTER =====");
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone number: ");
        String phone = input.nextLine();

        System.out.println(login.registerUser(username, password, phone));

        // ===== LOGIN =====
        System.out.println("\n===== LOGIN =====");
        System.out.print("Username: ");
        String loginUser = input.nextLine();

        System.out.print("Password: ");
        String loginPass = input.nextLine();

        boolean status = login.loginUser(loginUser, loginPass);
        System.out.println(login.returnLoginStatus(status));

        // ===== QUICKCHAT RUN LOOP =====
        if (status) {
            Message msg = new Message();
            System.out.println("\nWelcome to QuickChat");

            boolean keepRunning = true;
            while (keepRunning) {
                System.out.println("\n===== QUICKCHAT OPERATIONS =====");
                System.out.println("1. Send / Process Message Management");
                System.out.println("2. Show Recently Sent Messages");
                System.out.println("3. Quit Application Run");
                System.out.println("4. Stored Message Analytical Sub-Menu");
                System.out.print("Select choice execution: ");
                
                int choice = Integer.parseInt(input.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();
                        System.out.println(msg.checkRecipientCell(recipient));

                        System.out.print("Enter message: ");
                        String text = input.nextLine();
                        System.out.println(msg.checkMessageLength(text));

                        System.out.println("\n1. Send");
                        System.out.println("2. Disregard");
                        System.out.println("3. Store");
                        System.out.print("Enter processing strategy: ");
                        int option = Integer.parseInt(input.nextLine());

                        System.out.println(msg.SentMessage(option));

                        if (option == 1) {
                            msg.processMessage(recipient, text, msg.returnTotalMessages());
                        }
                        break;

                    case 2:
                        System.out.println("\n--- Sent Messages Report Summary ---");
                        System.out.println(Message.displaySentMessagesReport());
                        break;

                    case 3:
                        System.out.println("Exiting Application system workspace.");
                        keepRunning = false;
                        break;

                    case 4:
                        System.out.println("\n--- STORED DATA ACTIONS (PART 3) ---");
                        System.out.println("x. Read & Display JSON File Source Directly");
                        System.out.println("a. Display Stored Senders & Recipients");
                        System.out.println("b. Display Longest Stored Message Text");
                        System.out.println("c. Search by Unique Message ID Tracking");
                        System.out.println("d. Search All Message History per Target Recipient");
                        System.out.println("e. Delete Data Field using Target Entry Hash");
                        System.out.println("f. Output Detailed Activity Metric Report");
                        System.out.print("Select Target Option (x, a-f): ");
                        String taskSubSelection = input.nextLine().trim().toLowerCase();

                        switch (taskSubSelection) {
                            case "x":
                                System.out.println("\n--- RAW JSON DATASET READ ---");
                                System.out.println(rawJsonData);
                                break;
                            case "a":
                                System.out.println("\n--- STORED SENDER & RECIPIENT DETAILS ---");
                                System.out.println(Message.displayStoredSendersAndRecipients());
                                break;
                            case "b":
                                System.out.println("Longest Entry Found: " + Message.getLongestStoredMessage());
                                break;
                            case "c":
                                System.out.print("Provide lookup Message ID: ");
                                String searchId = input.nextLine();
                                System.out.println("Payload: " + Message.searchByMessageId(searchId));
                                break;
                            case "d":
                                System.out.print("Provide lookup Recipient number string: ");
                                String searchRec = input.nextLine();
                                System.out.println("Payload Match Collection: " + Message.searchAllMessagesForRecipient(searchRec));
                                break;
                            case "e":
                                System.out.print("Provide delete authorization Hash key: ");
                                String matchHash = input.nextLine();
                                System.out.println(Message.deleteMessageByHash(matchHash));
                                break;
                            case "f":
                                System.out.println("\n--- COMPLETE LOG REPORT ---");
                                System.out.println(Message.displaySentMessagesReport());
                                break;
                            default:
                                System.out.println("Invalid selection action argument.");
                        }
                        break;

                    default:
                        System.out.println("Selection outside bound choices.");
                }
            }
        }
        input.close();
    }
}