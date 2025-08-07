/**
 * Interface for managing and displaying products in the catalog.
 */
public interface ProductCatalog {

    /**
     * Adds a new product to the catalog.
     * @param name  the name of the product
     * @param price the price of the product
     */
    void addProduct(String name, double price);

    /**
     * Displays all products available in the catalog.
     */
    void viewProducts();

    /**
     * Default method to display a message if no products exist.
     */
    default void emptyCatalogMessage() {
        System.out.println("No products available in the catalog.");
}
}
