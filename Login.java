public class Login {

    private String username;
    private String password;
    private String phoneNumber;

    // Check username
    public boolean checkUserName(String username) {

        if (username.contains("_") && username.length() <= 5) {
            this.username = username;
            return true;
        }

        return false;
    }

    // Check password complexity
    public boolean checkPasswordComplexity(String password) {

        boolean capital = false;
        boolean number = false;
        boolean special = false;

        if (password.length() < 8) {
            return false;
        }

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)) {
                capital = true;
            }

            if (Character.isDigit(c)) {
                number = true;
            }

            if (!Character.isLetterOrDigit(c)) {
                special = true;
            }
        }

        if (capital && number && special) {
            this.password = password;
            return true;
        }

        return false;
    }

    // Check phone number
    public boolean checkCellPhoneNumber(String phoneNumber) {

        if (phoneNumber.startsWith("+27") && phoneNumber.length() <= 12) {
            this.phoneNumber = phoneNumber;
            return true;
        }

        return false;
    }

    // Register user
    public String registerUser(String username, String password, String phoneNumber) {

        if (checkUserName(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(phoneNumber)) {

            return "User registered successfully.";

        } else {

            return "Registration failed. Please check your details.";
        }
    }

    // Login check
    public boolean loginUser(String username, String password) {

        if (this.username.equals(username) && this.password.equals(password)) {
            return true;
        }

        return false;
    }

    // Login message
    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {
            return "Welcome user, it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}