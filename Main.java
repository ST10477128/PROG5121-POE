import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("Enter Username:");
        String username = input.nextLine();

        if (login.checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted.");
        }

        System.out.println("Enter Password:");
        String password = input.nextLine();

        if (login.checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password does not meet complexity requirements.");
        }

        System.out.println("Enter Cell Phone Number:");
        String phone = input.nextLine();

        if (login.checkCellPhoneNumber(phone)) {
            System.out.println("Cell phone number successfully captured.");
        } else {
            System.out.println("Cell phone number incorrectly formatted.");
        }

        System.out.println(login.registerUser(username, password, phone));

        // Login section
        System.out.println("\nLogin");

        System.out.println("Enter Username:");
        String loginUser = input.nextLine();

        System.out.println("Enter Password:");
        String loginPass = input.nextLine();

        boolean status = login.loginUser(loginUser, loginPass);

        System.out.println(login.returnLoginStatus(status));
    }
}