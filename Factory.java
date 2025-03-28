/*
 * Crea el árbol según lo que eliga el usuario.
 */

public class Factory {
    public static BinaryTree<String, Products> createBinaryTree(String keyType) {
        switch (keyType.toLowerCase()) {
            case "sku":
                return new BinaryTree<>();
            case "name":
                return new BinaryTree<>();
            default:
                throw new IllegalArgumentException("Ingrese una opción correcta");
        }
    }
}