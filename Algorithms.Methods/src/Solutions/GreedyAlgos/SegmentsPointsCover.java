package Solutions.GreedyAlgos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


/**
 * Created by Katerina on 10.04.2018.
 */

class Pair implements Comparable<Pair> {
    private int first;
    private int second;

    Pair(int First, int Second) {
        this.first = First;
        this.second = Second;
    }

    public void setFirst(int f) {
        this.first = f;
    }

    public int getFirst() {
        return this.first;
    }

    public void setSecond(int s) {
        this.second = s;
    }

    public int getSecond() {
        return this.second;
    }

    public boolean containsPoint(int p) {
        return (p >= this.first && p <= this.second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public int compareTo(Pair o) {
        return o.getFirst();
    }
}
public class SegmentsPointsCover {

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        ArrayList<Pair> listOfPairs = new ArrayList<Pair>();
        ArrayList<Integer> listOfPoints = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            listOfPairs.add(new Pair(scIn.nextInt(), scIn.nextInt()));
        }
        listOfPairs.sort(Comparator.comparing(Pair::getSecond));

        int point = listOfPairs.get(0).getSecond();

        listOfPoints.add(point);
        for (Pair pair : listOfPairs) {
            if (!pair.containsPoint(point)) {
                point = pair.getSecond();
                listOfPoints.add(point);
            }
        }

        System.out.println(listOfPoints.size());
        for (int i : listOfPoints) {
            System.out.print(i + " ");
        }

    }
}

