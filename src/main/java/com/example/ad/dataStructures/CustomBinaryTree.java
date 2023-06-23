package com.example.ad.dataStructures;

import com.example.ad.datasource.Car;
import com.example.ad.sorting.SelectionSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CustomBinaryTree <T extends Comparable<T>> {

    /**
     * Node for binary tree
     * @param <T>
     */
    public static class Node <T>{
        T value;
        Node left;
        Node right;
        int height;

        Node(T value){
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    public Node root;
    public CustomBinaryTree(){
        root = null;
    }

    /**
     * Insert a value into the binary tree
     * @param value T
     */
    public void insert(T value){

        //Check if root is null and set root node
        if(this.root == null){
            this.root = new Node(value);
            return;
        }

        //Create new node
        Node newNode = new Node(value);
        //Create queue to loop through the binary tree
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        //Loop through binary tree until last node has been reached
        while (!q.isEmpty()){
            //Get current root and remove it from th queue
            Node currentRoot = q.peek();
            q.remove();

            //Check if left root is empty else set left root in queue
            if (currentRoot.left == null) {
                currentRoot.left = newNode;
                break;
            }
            else
                q.add(currentRoot.left);

            //Check if right root is empty else set right root in queue
            if (currentRoot.right == null) {
                currentRoot.right = newNode;
                break;
            }
            else
                q.add(currentRoot.right);
        }
    }

    public boolean depthFirstSearch(T value){
        return depthFirstSearchHelper(this.root, value);
    };

    /**
     * Checks if value is present in the binary tree
     * @param root Node
     * @param value T target
     * @return boolean
     */
    public boolean depthFirstSearchHelper(Node root, T value){
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

    public T get(T value) {
        Node result = getHelper(root, value);
        return (result != null) ? (T) result.value : null;
    }

    private Node getHelper(Node node, T value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        Node leftSearch = getHelper(node.left, value);
        if (leftSearch != null) {
            return leftSearch;
        }
        Node rightSearch = getHelper(node.right, value);
        if (rightSearch != null) {
            return rightSearch;
        }
        return null;
    }


    public List<T> toList(){
        List<T> list = new ArrayList<T>();
        traverse(root, list);
        return list;
    }
    /**
     * Sort binary tree
     */

    public void rebuild(List<T> list){
        rebuildHelper(root, list);
    }

    /**
     * Rebuild the binary tree with the sorted values
     * @param node
     * @param list
     */
    private void rebuildHelper(Node node, List<T> list) {
        if (node != null) {
            rebuildHelper(node.left, list);
            node.value = list.remove(0);
            rebuildHelper(node.right, list);
        }
    }

    /**
     * Gets all elements of the binary tree and sets it in a List
     * @param node
     * @param list
     */
    private void traverse(Node<T> node, List<T> list) {
        if (node != null) {
            traverse(node.left, list);
            list.add(node.value);
            traverse(node.right, list);
        }
    }


    public String printTree(){
        return printNode(this.root, "", false);
    }
    public String printNode(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(isLeft ? "├──" : "└──");
        sb.append(node.value);
        sb.append("\n");
        sb.append(printNode(node.left, prefix + (isLeft ? "│   " : "    "), true));
        sb.append(printNode(node.right, prefix + (isLeft ? "│   " : "    "), false));
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomBinaryTree tree = new CustomBinaryTree();
        SelectionSort selectionSort = new SelectionSort();
        Car audi = new Car("Audi", "rs3", 5, 360);
        Car mercedes = new Car("Mercedes", "c63 amg", 4,510);
        Car fiat = new Car("Fiat", "multipla", 4, 103);
        tree.insert(audi);
        tree.insert(mercedes);
        tree.insert(fiat);
        tree.rebuild(selectionSort.selectionSort(tree.toList()));

        System.out.println(tree.depthFirstSearch(4));
    }
}
