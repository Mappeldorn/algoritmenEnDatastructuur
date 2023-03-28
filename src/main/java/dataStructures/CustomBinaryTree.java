package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBinaryTree <E> {

    public static class Node <E>{
        E data;
        Node left;
        Node right;

        Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public Node root;
    public CustomBinaryTree(){
        root = null;

    }

    public void insert(E data){

        if(this.root == null){
            this.root = new Node(data);
            return;
        }

        Node newNode = new Node(data);
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

    public static void main(String[] args) {
        CustomBinaryTree map = new CustomBinaryTree();
        map.insert(1);
        map.insert(3);
        map.insert(5);
        map.insert(2);
        map.insert(7);
        map.insert(11);

    }
}
