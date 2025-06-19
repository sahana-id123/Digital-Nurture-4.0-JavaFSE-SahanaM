/*
 * Big O Notation:
 * - Describes the upper bound of an algorithm's runtime.
 * - It helps predict how the algorithm will perform as the input size grows.
 * 
 * Common cases:
 * - Best Case: When the target is found at the beginning (e.g., O(1) for linear).
 * - Average Case: When the target is somewhere in the middle (e.g., O(n/2) → O(n)).
 * - Worst Case: When the target is not present or at the end (e.g., O(n) for linear, O(log n) for binary).
 */
import java.util.Arrays;

class Product implements Comparable<Product> {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public int compareTo(Product p) {
        return this.productId - p.productId;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class ECommerce {

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (requires sorted array)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Big O Notation:");
        System.out.println("- Describes performance in terms of input size (n).");
        System.out.println("- Linear Search: O(n) - Worst case checks all items.");
        System.out.println("- Binary Search: O(log n) - Efficient but needs sorted data.\n");

        Product[] products = {
            new Product(104, "Keyboard", "Electronics"),
            new Product(102, "Mouse", "Electronics"),
            new Product(101, "Laptop", "Electronics"),
            new Product(103, "Monitor", "Electronics"),
            new Product(105, "Chair", "Furniture")
        };

        int searchId = 103;

        System.out.println(" Performing Linear Search...");
        Product resultLinear = linearSearch(products, searchId);
        if (resultLinear != null)
            System.out.println(" Product Found (Linear): " + resultLinear);
        else
            System.out.println(" Product Not Found (Linear)");

        // Sort array for Binary Search
        Arrays.sort(products);

        System.out.println("\n Performing Binary Search...");
        Product resultBinary = binarySearch(products, searchId);
        if (resultBinary != null)
            System.out.println("Product Found (Binary): " + resultBinary);
        else
            System.out.println(" Product Not Found (Binary)");

        // Summary
        System.out.println("\n Comparison:");
        System.out.println("Linear Search:");
        System.out.println(" - Time Complexity: O(n)");
        System.out.println(" - No sorting needed, slower for large data");

        System.out.println("Binary Search:");
        System.out.println(" - Time Complexity: O(log n)");
        System.out.println(" - Needs sorted data, faster for large data");

        System.out.println("\n Recommendation: Use Binary Search if product list is sorted and large.");
    }
}
