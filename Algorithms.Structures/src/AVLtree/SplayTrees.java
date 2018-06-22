package AVLtree;

import com.sun.scenario.effect.Merge;

/**
 * Created by Katerina on 06.06.2018.
 */
public class SplayTrees {
    public static class SplayNode{
        private int key;
        private SplayNode parent;
        private SplayNode left;
        private SplayNode right;

        SplayNode(int key, SplayNode parent){
            this.key = key;
            this.parent = parent;
        }
        SplayNode(int key, SplayNode left, SplayNode right){
            this.key = key;
            this.left = left;
            this.right = right;
        }
        public int getKey() {
            return key;
        }
        public SplayNode getLeft() {
            return left;
        }
        public SplayNode getParent() {
            return parent;
        }
        public SplayNode getRight() {
            return right;
        }
        public void setKey(int key) {
            this.key = key;
        }
        public void setLeft(SplayNode left) {
            this.left = left;
        }
        public void setParent(SplayNode parent) {
            this.parent = parent;
        }
        public void setRight(SplayNode right) {
            this.right = right;
        }
    }
    public static class SplayTree{
        SplayNode root;

        SplayTree(){

        }
        public void splay(SplayNode u){

        }
        private void zig(){

        }
        private void zigzig(){

        }
        private void zigzag(){

        }
        public SplayNode search(SplayNode tree, int key){
            while (tree != null){
                if (key>= tree.getKey())
            }
            splay(tree);
        }
        public void insert(SplayNode tree, int key){

        }
        public void split(SplayNode tree, int key){

        }
        public void merge(SplayNode v1, SplayNode v2){

        }
        public void remove(SplayNode tree, int key){

        }
        public void sum(int lKey, int rKey){

        }
        public void printTree(SplayNode tree){

        }
    }

    public void run(){

    }
    public static void main(String[] args) {

    }
}
