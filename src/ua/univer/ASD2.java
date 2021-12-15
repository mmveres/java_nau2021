package ua.univer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Node {
    char value;
    Node left;
    Node right;

    Node(char value) {
        this.value = value;
        right = null;
        left = null;
    }
}

class BinaryTree {
    Node root;
    boolean stop = false;

    public BinaryTree() {
        root = new Node(' ');
    }

    private Node addRecursive(Node current, String value, int i) {
        if (value.length() == 1) {
            current.value = value.charAt(0);
        } else if (value.length() == i)
            if (current == null) {
                return new Node(value.charAt(0));
            } else {
                current.value = value.charAt(0);
            }
        else if (current == null)
            current = new Node(' ');


        if (i < value.length()) {
            if (value.charAt(i) == 'L')
                current.left = addRecursive(current.left, value, i + 1);
            else if (value.charAt(i) == 'R') {
                current.right = addRecursive(current.right, value, i + 1);
            } else {
                return current;
            }
        }
        return current;
    }

    public void add(String value) {
        root = addRecursive(root, value, 2);
    }

    public void print(){
        traverseInOrderABC(root);
    }

    public void traverseInOrder(Node node){
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
    public void traverseInOrderABC(Node node){
        if (node == null) stop = true;
        if (node != null) {

            if (node.left != null && node.value < node.left.value&&!stop)
                if (node.right == null || (node.right != null && node.left.value < node.right.value))
            traverseInOrderABC(node.left);
            if(!stop)System.out.print(" " + node.value);

            if (node.right != null && node.value < node.right.value&&!stop)
                if (node.left == null || (node.left != null && node.right.value < node.left.value))
            traverseInOrderABC(node.right);


        }
    }
}

public class ASD2 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        BinaryTree bt = new BinaryTree();

        Scanner sc = new Scanner(new File(args[0]));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(s);
            bt.add(s);
        }
        bt.print();
        System.out.println();
    }
}
