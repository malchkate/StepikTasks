package Solutions.DynamicStaircase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 18.04.2018.
 */
public class Staircase {
    public static int staircaseSum(List<Integer> listW){
        int n = listW.size();
        int[] optim = new int[n+1];
        if (n == 0){
            return 0;
        }
        optim[0] = 0;
        optim[1] = listW.get(0);
        for (int i = 2; i <= n; i++){
            int prev = optim[i-1] + listW.get(i-1);
            int prevprev = optim[i-2] + listW.get(i-1);
            optim[i] = Math.max(prev, prevprev);
        }
        return optim[n];
    }

    public static int staircaseSumRec(List<Integer> listW, int n){
        if (n == 0){
            return 0;
        } else if (n == 1){
            return listW.get(0);
        }
        return Math.max(staircaseSumRec(listW, n-1) + listW.get(n-1), staircaseSumRec(listW, n-2) + listW.get(n-1));

    }

    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        List<Integer> listW = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            listW.add(scIn.nextInt());
        }
        System.out.println(staircaseSumRec(listW, n));
    }
}
