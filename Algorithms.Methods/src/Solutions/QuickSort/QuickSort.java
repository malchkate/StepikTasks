package Solutions.QuickSort;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 10.04.2018.
 */
public class QuickSort {

    static List<SegmentAB> listOfSegments = new ArrayList<SegmentAB>();

    static class SegmentAB{
        int beginning;
        int end;
        SegmentAB(int b, int e){
            this.beginning = b;
            this.end = e;
        }

        public static void change(int i, int j){
            int tempBeginning = listOfSegments.get(i).beginning;
            int tempEnd = listOfSegments.get(i).end;
            listOfSegments.get(i).beginning = listOfSegments.get(j).beginning;
            listOfSegments.get(i).end = listOfSegments.get(j).end;
            listOfSegments.get(j).beginning = tempBeginning;
            listOfSegments.get(j).end = tempEnd;
        }
        @Override
        public String toString(){
            return "" +this.beginning + " " + this.end;
        }
    }

    public static void quickSort(int l, int r, Comparator<SegmentAB> comparator){
        if(l >= r){
            return;
        }
        Pair<Integer, Integer> pair = partitionEQ(l,r, comparator);
        quickSort(l, pair.getKey()-1, comparator);
        quickSort(pair.getValue() + 1, r, comparator);
    }

    public static Pair<Integer, Integer> partitionEQ(int l, int r, Comparator<SegmentAB> comparator){
        double rand = Math.random();
        int baseIndex = r + (int) ((l-r) *rand) ;
       // System.out.println(baseIndex);
        SegmentAB.change(l,baseIndex);
        SegmentAB x = listOfSegments.get(l);
        int e = l;
        int j = l;
        for (int i = l+1; i <= r; i++){
            if (comparator.compare(listOfSegments.get(i), x) == 0){
                e++;
                SegmentAB.change(i,e);
            } else if (comparator.compare(listOfSegments.get(i), x) < 0){
                j++;
                e++;
                SegmentAB.change(i,e);
                SegmentAB.change(j,e);
            }
        }
        SegmentAB.change(l,j);
        return  new Pair<Integer, Integer>(j,e);
    }

    public static void printList(){
        for (SegmentAB segment: listOfSegments) {
            System.out.println(segment);
        }
    }

    public static  int binSearchFirstInd(int x, List<Integer> list){
        int l = -1;
        int r = list.size();
        //list[l] < x ENDS
        //list[r] >= x
        while (r > l + 1){
            int m = (l+r) >> 1;
            if (list.get(m) < x ){
                l = m;
            }else{
                r = m;
            }
        }
            return r + 1; // +1
    }

    public static  int binSearchLastInd(int x, List<Integer> list){
        int l = -1;
        int r = list.size();
        //list[l] <= x BEGINNINGS
        //list[r] > x
        while (r > l + 1){
            int m = (l+r) >> 1;
            if (list.get(m) <= x ){
                l = m;
            }else{
                r = m;
            }
        }
        return l + 1; // +1
    }

    public void run(){
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        int m = scIn.nextInt();
        for (int i = 0; i < n; i++) {
            listOfSegments.add(new SegmentAB(scIn.nextInt(), scIn.nextInt()));
        }
        Comparator<SegmentAB> comparatorBeginnings = new Comparator<SegmentAB>() {
            @Override
            public int compare(SegmentAB o1, SegmentAB o2) {
                return Integer.compare(o1.beginning, o2.beginning);
            }
        };
        Comparator<SegmentAB> comparatorEnds = new Comparator<SegmentAB>() {
            @Override
            public int compare(SegmentAB o1, SegmentAB o2) {
                return Integer.compare(o1.end, o2.end);
            }
        };
        int l = 0;
        int r = n-1;

        quickSort(l, r, comparatorBeginnings);
        List<Integer> beginningsList = new ArrayList<Integer>();
        List<Integer> endiingsList = new ArrayList<Integer>();
        for (SegmentAB segm:listOfSegments) {
            beginningsList.add(segm.beginning);
        }

        quickSort(l, r, comparatorEnds);
        for (SegmentAB segm:listOfSegments) {
            endiingsList.add(segm.end);
        }

        for (int j = 0; j < m; j++) {
            int maxIndexForPoint = n-1;
            int amountOfRightSegments = 0;
            int point = scIn.nextInt();

            maxIndexForPoint = binSearchLastInd(point, beginningsList);
            amountOfRightSegments = maxIndexForPoint - (binSearchFirstInd(point, endiingsList) - 1);

            System.out.print(amountOfRightSegments + " ");
        }
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        obj.run();
    }
}

