package PriorityQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 09.05.2018.
 */
public class ParallelProcessing {
    static class Pair implements Comparable{
        private int procNum;
        private long time;
        Pair(int num, long time){
            this.procNum = num;
            this.time = time;
        }

        public int getProcNum() {
            return procNum;
        }

        public long getTime() {
            return time;
        }

        public void setProcNum(int procNum) {
            this.procNum = procNum;
        }

        public void setTime(long time) {
            this.time = time;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;
            int result = Long.compare(this.time, p.time);
            if (result == 0){
                result = Long.compare(this.getProcNum(), p.getProcNum());
            }
            return result;
        }
    }

    static class Queue{
        Pair[] minQueue;
        int lastInd;

        Queue(int n){
            minQueue = new Pair[n];
            lastInd = -1;
        }
        public Pair getMin(){
            return minQueue[0];
        }
        public void insert(Pair pair){
            lastInd++;
            minQueue[lastInd] = pair;
            swiftUp(lastInd);
        }
        public Pair extractMin(){
            Pair temp = minQueue[0];
            minQueue[0] = minQueue[lastInd--];
            swiftDown(0);
            return temp;
        }
        public void swiftUp(int index){
            int prev = (index - 1) / 2;
            if ( index > 0 && minQueue[prev].compareTo(minQueue[index]) > 0){
                Pair temp = minQueue[prev];
                minQueue[prev] = minQueue[index];
                minQueue[index] = temp;
                swiftUp(prev);
            }
        }
        public void swiftDown(int index){
            boolean isNormalized = false;
            while (index * 2 < lastInd && !isNormalized){
                int compareInd = index*2 +1;
                if (compareInd + 1 <= lastInd && minQueue[compareInd].compareTo(minQueue[compareInd + 1]) > 0){
                    compareInd++;
                }
                if (compareInd <= lastInd && minQueue[index].compareTo(minQueue[compareInd]) > 0){
                    Pair temp = minQueue[compareInd];
                    minQueue[compareInd] = minQueue[index];
                    minQueue[index] = temp;
                    index = compareInd;
                } else {
                    isNormalized = true;
                }
            }
        }
        public void printQueue(){
            System.out.println("QUEUE:");
            for (int i = 0; i < lastInd+1; i++){
                System.out.println("" + minQueue[i].getProcNum() + " " + minQueue[i].getTime());;
            }
            System.out.println("-----------------------------------");
        }
    }
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        int m = scIn.nextInt();
        Queue queue = new Queue(n);

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < m; i++){
           // queue.printQueue();
            long taskTime = scIn.nextInt();
            if (i >= n){
                Pair minPair = queue.extractMin();
                long newTime = minPair.getTime() + taskTime;
                result.append("" + minPair.getProcNum() + " " + minPair.getTime()+ " \n");
                minPair.setTime(newTime);
                queue.insert(minPair);
            } else{
                queue.insert(new Pair(i, taskTime));
                result.append("" + i + " " + 0 + " \n");
            }
        }

        System.out.println(result.toString());
    }
}
