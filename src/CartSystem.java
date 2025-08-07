/**
 * Interface for handling shopping cart operations.
 */
public interface CartSystem {

    /**
     * Adds a product to the cart by its ID.
     * @param productId the ID of the product
     */
    void addToCart(int productId);

    /**
     * Removes a product from the cart by its ID.
     * @param productId the ID of the product
     */
    void removeFromCart(int productId);

    /**
     * Displays all products currently in the cart.
     */
    void viewCart();

    /**
     * Default helper method to show an empty cart message.
     */
    default void emptyCartMessage() {
        System.out.println("Your cart is empty.");
}
}
