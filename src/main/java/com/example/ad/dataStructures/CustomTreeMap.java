package com.example.ad.dataStructures;

/**
 * A custom tree map implementation
 * @param <K>
 * @param <V>
 */
public class CustomTreeMap<K extends Comparable<K>, V> {

    private Node<K, V> root;
    int size;

    /**
     * A node in the tree
     * @param <K> key
     * @param <V> value
     */
    private static class Node<K extends Comparable<K>, V> {
        private K key;
        private V value;
        private Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Add a key-value pair to the tree
     * @param key key
     * @param value value
     */
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * Add a key-value pair to the tree
     * @param node current node
     * @param key key
     * @param value value
     * @return the node
     */
    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    /**
     * Get the value of a key
     * @param key key
     * @return value
     */
    public V get(K key) {
        Node<K, V> node = get(root, key);
        return node == null ? null : node.value;
    }

    /**
     * Get the node of a key
     * @param node current node
     * @param key key
     * @return node
     */
    private Node<K, V> get(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    /**
     * Remove a key-value pair from the tree
     * @param key key
     */
    public void remove(K key) {
        root = remove(root, key);
    }

    /**
     * Remove a key-value pair from the tree
     * @param node current node
     * @param key key
     * @return the node
     */
    private Node<K, V> remove(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            // If the key is smaller than the current node, go left
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            // If the key is greater than the current node, go right
            node.right = remove(node.right, key);
        } else {
            // If the key is equal to the current node, remove it
            size--;
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // If the node has two children, replace it with the minimum node in the right subtree
                Node<K, V> minNode = min(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = remove(node.right, minNode.key);
            }
        }
        return node;
    }

    /**
     * Get the minimum node
     * @param node current node
     * @return the minimum node
     */
    private Node<K, V> min(Node<K, V> node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    /**
     * Get the size of the tree
     * @return size
     */
    public int getSize() {
        return size;
    }

    public boolean depthFirstSearch(V value){
        return depthFirstSearchHelper(this.root, value);
    }

    /**
     * Checks if value is present in the tree map
     * @param root Node
     * @param value V target
     * @return boolean
     */
    private boolean depthFirstSearchHelper(Node root, V value){
        //Check if root is empty
        if (root == null) {
            return false;
        }
        //Check if root value the target
        if (root.value == value) {
            return true;
        }

        //Search in the left part of the binary tree
        boolean leftSearch = depthFirstSearchHelper(root.left, value);
        //Search in the right part of the binary tree
        boolean rightSearch = depthFirstSearchHelper(root.right, value);
        return leftSearch || rightSearch;
    }

    // Code for testing to make sure it works
    public static void main(String[] args) {
        CustomTreeMap<Integer, String> map = new CustomTreeMap<>();
        map.put(6, "six");
        map.put(3, "three");
        map.put(0, "zero");
        map.put(5, "five");

        System.out.println(map.depthFirstSearch("sixxx"));
    }
}
