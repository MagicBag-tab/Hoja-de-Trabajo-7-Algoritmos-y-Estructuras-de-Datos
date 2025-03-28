/*
 * Crea el árbol según lo que eliga el usuario.
 */

public class Factory {
    public static BinaryTree<String, Products> createBinaryTree(String keyType) {
        switch (keyType.toLowerCase()) {
            case "SKU":
                return new BinaryTree<>();
            case "Name":
                return new BinaryTree<>();
            default:
                throw new IllegalArgumentException("Ingrese una opción correcta");
        }
    }
}