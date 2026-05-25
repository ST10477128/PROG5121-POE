import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login login = new Login();

        // REGISTER
        System.out.println("===== REGISTER =====");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter cellphone number: ");
        String phone = input.nextLine();

        System.out.println(login.registerUser(username, password, phone));

        // LOGIN
        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String loginUser = input.nextLine();

        System.out.print("Password: ");
        String loginPass = input.nextLine();

        boolean status = login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus(status));

        // QUICKCHAT
        if (status) {

            Message msg = new Message();

            System.out.println("\nWelcome to QuickChat");

            System.out.print("How many messages would you like to send? ");

            int totalMessages =
                    Integer.parseInt(input.nextLine());

            for (int i = 0; i < totalMessages; i++) {

                System.out.println("\n===== MESSAGE " + (i + 1) + " =====");

                System.out.println("1. Send Message");
                System.out.println("2. Show recently sent messages");
                System.out.println("3. Quit");

                int choice =
                        Integer.parseInt(input.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("Enter recipient number: ");

                        String recipient =
                                input.nextLine();

                        System.out.println(
                                msg.checkRecipientCell(recipient)
                        );

                        System.out.print("Enter message: ");

                        String text =
                                input.nextLine();

                        System.out.println(
                                msg.checkMessageLength(text)
                        );

                        System.out.println("\n1. Send");
                        System.out.println("2. Disregard");
                        System.out.println("3. Store");

                        int option =
                                Integer.parseInt(input.nextLine());

                        System.out.println(
                                msg.SentMessage(option)
                        );

                        if (option == 1) {

                            msg.processMessage(
                                    recipient,
                                    text,
                                    i
                            );
                        }

                        break;

                    case 2:

                        System.out.println("Coming Soon.");

                        break;

                    case 3:

                        System.out.println("Goodbye!");

                        System.exit(0);

                    default:

                        System.out.println("Invalid option.");
                }
            }

            System.out.println(
                    "\nTotal messages sent: "
                    + msg.returnTotalMessages()
            );
        }
    }
}