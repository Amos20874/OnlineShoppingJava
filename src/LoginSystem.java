/**
 * Interface for handling user registration and login operations.
 * Part of the Online Shopping Management System.
 */
public interface LoginSystem {

    // Constants
    String ROLE_CUSTOMER = "CUSTOMER";
    String ROLE_ADMIN = "ADMIN";

    /**
     * Registers a new user into the system.
     * @param username the username for the account
     * @param password the password for the account
     */
    void register(String username, String password);

    /**
     * Logs in an existing user.
     * @param username the username of the account
     * @param password the password of the account
     * @return true if login is successful, false otherwise
     */
    boolean login(String username, String password);

    /**
     * Default helper method to log logout message.
     */
    default void logout() {
        System.out.println("User logged out successfully.");
}
}
