package AVLtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Katerina on 04.06.2018.
 */
public class BinTreeTraversal {
    public static class TempNode{
        long val;
        int left;
        int right;
        TempNode(long val, int left, int right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public long getVal() {
            return val;
        }
    }
    public static class Node{
        long value;
        Node left;
        Node right;

        Node(long value){
            this.value = value;
        }
        Node(long value, Node left, Node right){
            this.left = left;
            this.right = right;
            this.value = value;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public void setValue(long value) {
            this.value = value;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public long getValue() {
            return value;
        }
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
    }
    public static class BinaryTree{
        private Node root;
        private TempNode[] nodeArray;
        private int nodesNum;
        private List<Long> array;
        boolean isCorrect = true;

        BinaryTree(){
            Scanner scIn = new Scanner(System.in);
            nodesNum = scIn.nextInt();
            nodeArray = new TempNode[nodesNum];
            for (int i = 0; i < nodesNum; i++){
                int val = scIn.nextInt();
                int left = scIn.nextInt();
                int right = scIn.nextInt();
                nodeArray[i] = new TempNode(val, left, right);
            }
            if( nodesNum > 0){
                root = arrayToTree(0);
            }
            array = new ArrayList<>();
        }
        public Node arrayToTree(int i){
            int leftValue = nodeArray[i].getLeft();
            int rightValue = nodeArray[i].getRight();
            Node node = new Node(nodeArray[i].getVal());

            if(leftValue != -1){
                node.setLeft(arrayToTree(leftValue));
            }
            if(rightValue != -1){
                node.setRight(arrayToTree(rightValue));
            }
            return node;
        }
        public  void makeTraversals(){
            inOrder(root);
            System.out.println();
            preOrder(root);
            System.out.println();
            postOrder(root);
        }

        public Node getRoot() {
            return root;
        }

        public void inOrder(Node i){
            if(i.getLeft() != null){
                inOrder(i.getLeft());
            }
            System.out.print(i.getValue() + " ");
            if(i.getRight() != null){
                inOrder(i.getRight());
            }
        }
        public void preOrder(Node i){
            System.out.print(i.getValue() + " ");
            if(i.getLeft() != null){
                preOrder(i.getLeft());
            }
            if(i.getRight() != null){
                preOrder(i.getRight());
            }
        }
        public void postOrder(Node i){
            if(i.getLeft() != null){
                postOrder(i.getLeft());
            }
            if(i.getRight() != null){
                postOrder(i.getRight());
            }
            System.out.print(i.getValue() + " ");
        }
        public void traversal(Node node){
            if(node.getLeft() != null){
                traversal(node.getLeft());
            }
            array.add(node.getValue());
            if(node.getRight() != null){
                traversal(node.getRight());
            }
        }
        public void traversalCheck(Node node){
            if(node.getLeft() != null){
                traversalCheck(node.getLeft());
            }
            array.add(node.getValue());
            if (array.size() > 1){
                long prev = array.get(array.size()-2);
                if (prev >= node.getValue()){
                    this.isCorrect = false;
                }
            }
            if(node.getRight() != null){
                traversalCheck(node.getRight());
            }
        }
        public void correctnessCheck(){
            if( nodesNum > 0){
                this.traversal(root);
            }
            boolean isCorrect = true;
            if(nodesNum > 1){
                for (int i = 1; i < nodesNum; i++){
                    if (array.get(i-1) > array.get(i)){
                       isCorrect = false;
                        break;
                    }
                }
            }
            if(isCorrect){
                System.out.println("CORRECT");
            } else{
                System.out.println("INCORRECT");
            }
        }

    }

    public void run(){
        BinaryTree binaryTree = new BinaryTree();
        //binaryTree.makeTraversals();
        //binaryTree.correctnessCheck();
        binaryTree.traversalCheck(binaryTree.getRoot());
        if (binaryTree.isCorrect){
            System.out.println("CORRECT");
        } else{
            System.out.println("INCORRECT");
        }
    }
    public static void main(String[] args) {
        new BinTreeTraversal().run();
    }
}
