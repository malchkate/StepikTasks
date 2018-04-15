package Solutions.LargestIncreasingSubsequence;


import java.util.*;
import java.util.Scanner;

/**
 * Created by Katerina on 12.04.2018.
 */
public class LISBottomUp {

    public void run(){
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        List<Integer> listElem = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            listElem.add(scIn.nextInt());
        }
        System.out.println(LIS(listElem));
    }

    public int LIS(List<Integer> list){
        List<Integer> posElem = new ArrayList<>();
        int n = list.size();
        for (int i = 0; i < n; i++){
            posElem.add(i, 1);
            for (int j = 0; j < i; j++){
                if (list.get(i) % list.get(j) == 0 && posElem.get(j) + 1 > posElem.get(i)){
                    posElem.set(i, posElem.get(j) + 1);
                }
            }
        }
        int max = -1;
        for (Integer i :posElem) {
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        new LISBottomUp().run();
        long end = System.currentTimeMillis();

    }
}
