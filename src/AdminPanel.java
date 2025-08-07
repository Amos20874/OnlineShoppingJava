/**
 * Interface for administrative tasks such as removing products.
 */
public interface AdminPanel {

    /**
     * Removes a product from the catalog.
     * @param productId the ID of the product
     */
    void removeProduct(int productId);

    /**
     * Default method to show an unauthorized access message.
     */
    default void unauthorizedMessage() {
        System.out.println("Access denied. Admin privileges required.");
}
}