package PriorityQueues;

import java.util.Scanner;

/**
 * Created by Katerina on 05.05.2018.
 */
public class MinHeap {
    public static StringBuffer output;

    static class Heap{
        int[] heap;
        static int changes = 0;

        Heap(int[]arr){
            heap = arr;
            makeHeapRight();
        }
        public void makeHeapRight(){
            for(int i = heap.length / 2 -1; i >=0; i--){
                swiftDown(i);
            }
        }

        public void makeHeap(){
            for(int i = 1;i < heap.length; i++){
                swiftUp(i);
            }
        }

        public void swiftDown(int i){
            boolean isNormalized = false;
            while (i < heap.length && !isNormalized){
                int index = i*2 +1;
                if (index + 1 < heap.length && heap[index] > heap[index + 1]){
                    index++;
                }
                if (index < heap.length && heap[i] > heap[index]){
                    changes++;
                    output.append(i + " " + index + "\n");
                    int temp = heap[index];
                    heap[index] = heap[i];
                    heap[i] = temp;
                    i = index;
                } else {
                    isNormalized = true;
                }
            }
        }
        public void swiftUp(int i){
            boolean isNormalized = false;
            while (i > 0 || !isNormalized){
                if (heap[i] < heap[i/2]){
                    System.out.println(heap[i]+ " " + heap[i/2]);
                    int temp = heap[i/2];
                    heap[i/2] = heap[i];
                    heap[i] = temp;
                    i /= 2;
                } else {
                    isNormalized = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scIn.nextInt();
        }
        output = new StringBuffer();
        Heap heap = new Heap(arr);
        System.out.println(Heap.changes);
        System.out.println(output.toString());
    }
}
