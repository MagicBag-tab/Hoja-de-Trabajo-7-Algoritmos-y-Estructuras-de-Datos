/*
 * Implementación de la clase Iterator del libro Java Structures: Data Structures for the Principled Programmer
 * Link: https://www.cs.williams.edu/~bailey/JavaStructures/Book_files/JavaStructures.pdf
 * en la pág: 293 In-Order Traversal adaptado a la estructura de <K, V>
 */

import java.util.Iterator;
import java.util.Stack;

public class InOrderIterator<K extends Comparable<K>, V> implements Iterator<K> {
    private Stack<BinaryTree<K, V>> stack;

    public InOrderIterator(BinaryTree<K, V> root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(BinaryTree<K, V> node) {
        while (!node.isEmpty()) {
            stack.push(node);
            node = node.left();
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public K next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();
        BinaryTree<K, V> node = stack.pop();
        K key = node.getKey();
        pushLeft(node.right());
        return key;
    }
}