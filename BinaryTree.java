/*
 * Implementación de la clase BinaryTree del libro Java Structures: Data Structures for the Principled Programmer
 * Link: https://www.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
 * en la pág: 284 The BinaryTreeImplementation adaptado a la estructura de <K, V>
 */
public class BinaryTree<K extends Comparable<K>, V> {

    protected K key;
    protected V value;
    protected BinaryTree<K, V> parent;
    protected BinaryTree<K, V> left, right;

    /*
     * Constructor vacío para un árbol vacío
     */

    public BinaryTree() {
        key = null;
        value = null;
        parent = null;
        left = right = this;
    }

    /*
     * Constructor con clave y con valor
     */
    public BinaryTree(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = new BinaryTree<>();
        this.right = new BinaryTree<>();
        setLeft(left);
        setRight(right);
    }

    public boolean isEmpty() {
        return key == null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BinaryTree<K, V> left() {
        return left;
    }

    public BinaryTree<K, V> right() {
        return right;
    }

    public BinaryTree<K, V> parent() {
        return parent;
    }

    /*
     * Crea un subárbol derecho
     */

    public void setLeft(BinaryTree<K, V> newLeft) {
        if (isEmpty())
            return;
        if (left != null && left.parent() == this)
            left.setParent(null);
        left = newLeft;
        if (left != null)
            left.setParent(this);
    }

    /*
     * Crea un subárbol izquierdo
     */

    public void setRight(BinaryTree<K, V> newRight) {
        if (isEmpty())
            return;
        if (right != null && right.parent() == this)
            right.setParent(null);
        right = newRight;
        if (right != null)
            right.setParent(this);
    }

    protected void setParent(BinaryTree<K, V> newParent) {
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    /*
     * Inserta un nuevo árbol de estructura <K, V>
     */
    public void insert(K key, V value) {
        if (isEmpty()) {
            this.key = key;
            this.value = value;
            this.left = new BinaryTree<>();
            this.right = new BinaryTree<>();
            setLeft(left);
            setRight(right);
        } else {
            int compare = key.compareTo(this.key);
            if (compare < 0) {
                left.insert(key, value);
            } else if (compare > 0) {
                right.insert(key, value);
            } else {
                this.value = value;
            }
        }
    }

    /*
     * Busca la llave dentro del arbol y retorna los valores
     */

    public V search(K key) {
        if (isEmpty())
            return null;
        int compare = key.compareTo(this.key);
        if (compare == 0) {
            return this.value;
        } else if (compare < 0) {
            return left.search(key);
        } else {
            return right.search(key);
        }
    }

}
