package BasicStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Katerina on 28.05.2018.
 */
public class MaxWindow {
    static class MyStack{
        private List<Integer> stack;
        private List<Integer> maxStack;
        private int size;

        MyStack(){
            stack = new ArrayList<Integer>();
            maxStack = new ArrayList<Integer>();
            size = 0;
        }
        public void push(int elem){
            stack.add(elem);
            if (size == 0){
                maxStack.add(elem);
            } else{
                int prevMax = maxStack.get(size-1);
                maxStack.add(Math.max(prevMax, elem));
            }
            size++;
        }
        public int top(){
            return stack.get(size-1);
        }
        public int topMax(){
            return maxStack.get(size-1);
        }
        public int pop(){
            size--;
            maxStack.remove(size);
            return stack.remove(size);
        }
        public int popMax(){
            size--;
            stack.remove(size);
            return maxStack.remove(size);
        }
        public boolean isEmpty(){
            return (size == 0);
        }
    }

    static class MyQueue{
        private MyStack stack1;
        private MyStack stack2;

        MyQueue(){
            stack1 = new MyStack();
            stack2 = new MyStack();
        }
        public void enqueue(int elem){
            stack1.push(elem);
        }
        public int dequeue(){
            if(!stack2.isEmpty()){
                return stack2.pop();
            } else{
                relocate();
                return stack2.pop();
            }
        }
        public int dequeueMax(){
            if(!stack2.isEmpty()){
                if (!stack1.isEmpty()){
                    int max = stack2.popMax();
                    if (stack1.topMax() > max){
                        max = stack1.topMax();
                    }
                    return max;
                }else{
                    return stack2.pop();
                }
            } else{
                relocate();
                return stack2.popMax();
            }
        }
        private void relocate(){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        public boolean isEmpty(){
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    public void run(){
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scIn.nextInt();
        }
        int m = scIn.nextInt();
        MyQueue queue = new MyQueue();

        for (int i = 0; i < n; i++){
            queue.enqueue(arr[i]);
            if(i >= m - 1){
                System.out.println(queue.dequeueMax());
            }
        }
    }

    public static void main(String[] args) {
        new MaxWindow().run();
    }

}
