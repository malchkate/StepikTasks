package BasicStructures;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Katerina on 03.05.2018.
 */
public class NetworkPackets {

    class Packet{
        private int arr;
        private int dur;
        private int fin;

        Packet(int arr, int dur){
            this.arr = arr;
            this.dur = dur;
            this.fin = arr + dur;
        }

        public int getArr() {
            return arr;
        }

        public int getFin() {
            return fin;
        }

        public int getDur() {
            return dur;
        }
    }

    public void processing(){
        Scanner scIn = new Scanner(System.in);
        int size = scIn.nextInt();
        int n = scIn.nextInt();
        Queue<Integer> queue = new PriorityQueue<>();
        int max = -1;
        for (int i = 0; i < n; i++){
            int arr = scIn.nextInt();
            int durr = scIn.nextInt();
            if (queue.size() < size){
                if (queue.size() == 0){
                    System.out.println(arr);
                } else{
                    System.out.println(Math.max(arr, max));
                }
                queue.add(Math.max(arr, max)+durr);
                max = Math.max(max + durr, arr+durr);
            } else{
                int top = queue.peek();
                if (top <= arr){
                    queue.poll();
                    queue.add(Math.max(arr, max)+durr);
                    System.out.println(Math.max(arr, max) );
                    max = Math.max(max + durr, arr+durr);
                } else {
                    System.out.println(-1);
                }
            }
        }

    }

    public static void main(String[] args) {
        new NetworkPackets().processing();
    }
}
