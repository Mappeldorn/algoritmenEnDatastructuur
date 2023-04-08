package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBinaryTree <E> {

    /**
     * A node from the binary tree
     * @param <E>
     */
    public static class Node <E>{
        E value;
        Node left;
        Node right;

        Node(E value){
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node root;
    public CustomBinaryTree(){
        root = null;

    }

    public void insert(E value){

        if(this.root == null){
            this.root = new Node(value);
            return;
        }

        Node newNode = new Node(value);
        Queue<Node> q = new LinkedList<>();
        q.add(this.root);

        while (!q.isEmpty()){
            Node currentRoot = q.peek();
            q.remove();

            if (currentRoot.left == null) {
                currentRoot.left = newNode;
                break;
            }
            else
                q.add(currentRoot.left);

            if (currentRoot.right == null) {
                currentRoot.right = newNode;
                break;
            }
            else
                q.add(currentRoot.right);
        }
    }
}
