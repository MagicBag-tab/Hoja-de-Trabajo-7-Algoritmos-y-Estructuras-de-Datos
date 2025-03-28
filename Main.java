/*
 * Menú que ve el usuario, donde puede elegir lo que desea realizar
 * Si buscar por sku o nombre, o si listar por sku o nombre
 */

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         * Crea los arboles para cada caso
         */
        BinaryTree<String, Products> byName = Factory.createBinaryTree("name");
        BinaryTree<String, Products> bySKU = Factory.createBinaryTree("sku");

        ProductReader.loadProductsFromCSV("inventario_ropa_deportiva_100.csv", byName, bySKU);

        Scanner scanner = new Scanner(System.in);

        int option = 0;

        while (option != 5) {
            System.out.println("\n1. Buscar por SKU");
            System.out.println("2. Buscar por Nombre");
            System.out.println("3. Listar por Nombre");
            System.out.println("4. Listar por SKU");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese SKU: ");
                    String sku = scanner.nextLine();
                    Products productBySKU = bySKU.search(sku);
                    System.out.println(productBySKU != null ? productBySKU : "Producto no encontrado");
                    break;
                case 2:
                    System.out.print("Ingrese Nombre: ");
                    String name = scanner.nextLine();
                    Products productByName = byName.search(name);
                    System.out.println(productByName != null ? productByName : "Producto no encontrado");
                    break;
                case 3:
                    System.out.println("Listado por Nombre:");
                    Iterator<String> nameIt = byName.iterator();
                    while (nameIt.hasNext()) {
                        String key = nameIt.next();
                        System.out.println(byName.search(key));
                    }
                    break;
                case 4:
                    System.out.println("Listado por SKU:");
                    Iterator<String> skuIt = bySKU.iterator();
                    while (skuIt.hasNext()) {
                        String key = skuIt.next();
                        System.out.println(bySKU.search(key));
                    }
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
}