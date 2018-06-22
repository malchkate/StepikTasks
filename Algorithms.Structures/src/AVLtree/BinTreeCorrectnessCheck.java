package AVLtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 05.06.2018.
 */
public class BinTreeCorrectnessCheck {
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
        public Interval traversalCheck(Node node){
            Interval leftInt = null;
            Interval rightInt = null;
            if (node.getLeft() != null) {
                leftInt = traversalCheck(node.getLeft());
            }
            if (node.getRight() != null) {
                rightInt = traversalCheck(node.getRight());
            }

            long currVal = node.getValue();
            if (leftInt == null && rightInt == null){
                return new Interval(currVal, currVal);
            } else if (leftInt == null){
                if (currVal > rightInt.getMin()){
                    isCorrect = false;
                }
                rightInt.setMin(currVal);
                return rightInt;
            } else if (rightInt == null){
                if (currVal <= leftInt.getMax()){
                    isCorrect = false;
                }
                leftInt.setMax(currVal);
                return leftInt;
            } else{
                if (currVal > rightInt.getMin()){
                    isCorrect = false;
                }
                if (currVal <= leftInt.getMax()){
                    isCorrect = false;
                }
                return new Interval(leftInt.getMin(), rightInt.getMax());
            }
        }

    }
    public static class Interval {
        private long min;
        private long max;
        Interval(long min, long max){
            this.max = max;
            this.min = min;
        }
        public long getMax() {
            return max;
        }
        public long getMin() {
            return min;
        }
        public void setMax(long max) {
            this.max = max;
        }
        public void setMin(long min) {
            this.min = min;
        }
    }

    public void run(){
        BinTreeCorrectnessCheck.BinaryTree binaryTree = new BinTreeCorrectnessCheck.BinaryTree();
        Node root = binaryTree.getRoot();
        if(binaryTree.nodesNum >0){
            binaryTree.traversalCheck(root);
        }
        if (binaryTree.isCorrect){
            System.out.println("CORRECT");
        } else{
            System.out.println("INCORRECT");
        }
    }
    public static void main(String[] args) {
       new BinTreeCorrectnessCheck().run();
    }
}
