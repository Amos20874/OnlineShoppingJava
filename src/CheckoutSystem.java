/**
 * Interface for handling checkout and payment processes.
 */
public interface CheckoutSystem {

    /**
     * Completes the checkout process and displays the order summary.
     */
    void checkout();

    /**
     * Default method to display a thank-you message after checkout.
     */
    default void thankCustomer() {
        System.out.println("Thank you for shopping with us!");
}
}