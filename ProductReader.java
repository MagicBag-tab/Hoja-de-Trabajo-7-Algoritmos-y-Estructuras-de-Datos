/*
 * Clase que lee el csv de los productos
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductReader {
    public static void loadProductsFromCSV(String filePath, BinaryTree<String, Products> byName,
            BinaryTree<String, Products> bySKU) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int sku = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    String cantPerSize = parts[3].trim();

                    Products product = new Products(sku, name, description, cantPerSize);
                    byName.insert(name, product);
                    bySKU.insert(String.valueOf(sku), product);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear un número en el archivo CSV: " + e.getMessage());
        }
    }
}