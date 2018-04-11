package Solutions.NonComparesSort;

import java.util.*;
import java.util.Scanner;

/**
 * Created by Katerina on 10.04.2018.
 */
public class CountSearch {
    public void run(){
        Scanner scIn = new Scanner(System.in);
        int[] list = new int[11];
        int n = scIn.nextInt();
        for (int i = 0; i < n; i++){
            int num = scIn.nextInt();
            list[num]++;
        }
        for (int i = 0; i < 11; i++){
            if (list[i] > 0){
                for (int j = 0; j < list[i]; j++){
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args){
        CountSearch cs = new CountSearch();
        cs.run();
    }
}
