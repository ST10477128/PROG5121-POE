import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Automated JUnit test suite for verifying the authentication logic.
 * Validates registration criteria, password complexity requirements, 
 * and international cell phone formats.
 */
public class LoginTest {

    // Instance of the Login class to be tested
    Login login = new Login();

    /**
     * Test case to verify that a correctly formatted username returns true.
     * Criteria: Contains an underscore and is under 5 characters.
     */
    @Test
    public void testUsernameCorrect() {
        boolean result = login.checkUserName("kyl_1");
        assertTrue(result);
    }

    /**
     * Test case to verify that an incorrectly formatted username returns false.
     * Criteria: Fails if it does not contain an underscore or exceeds length limits.
     */
    @Test
    public void testUsernameIncorrect() {
        boolean result = login.checkUserName("kyle123");
        assertFalse(result);
    }

    /**
     * Test case to verify that a password meeting all complexity rules returns true.
     * Criteria: Contains uppercase, lowercase, numbers, and special characters.
     */
    @Test
    public void testPasswordCorrect() {
        boolean result = login.checkPasswordComplexity("Ch&k&e@ke9!");
        assertTrue(result);
    }

    /**
     * Test case to verify that a simple password fails complexity verification.
     */
    @Test
    public void testPasswordIncorrect() {
        boolean result = login.checkPasswordComplexity("password");
        assertFalse(result);
    }

    /**
     * Test case to verify that a valid South African cell phone number 
     * with the proper international prefix (+27) returns true.
     */
    @Test
    public void testCellNumberCorrect() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertTrue(result);
    }

    /**
     * Test case to verify that an improperly formatted cell phone number 
     * missing the international prefix or correct digit count returns false.
     */
    @Test
    public void testCellNumberIncorrect() {
        boolean result = login.checkCellPhoneNumber("0896653");
        assertFalse(result);
    }
}