package Solutions.DynamicCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 18.04.2018.
 */
public class Calculator {

    public static void calculatorDyn(int n){
        StringBuilder str = new StringBuilder();
        int[] costs = new int[n+1];
        costs[0] = 0;
        for (int i = 1; i <= n; i++){
            int temp = costs[i-1];
            if (i/3 > 0 && i%3 == 0 && costs[i/3] < temp){
                temp = costs[i/3];
            } else if (i/2 > 0 && i%2 == 0 && costs[i/2] < temp) {
                temp = costs[i / 2];
            }
            costs[i] = temp + 1;
        }
        System.out.println(costs[n] - 1);
        List<Integer> list = new ArrayList<Integer>();
        int res = costs[n];
        int j = n;
        while (res > 0){
            list.add(n);
            if (n % 3 == 0 && costs[n/3] == res -1){
                n /= 3;

            }else if (n % 2 == 0 && costs[n/2] == res -1){
                n /= 2;
            }else{
                n -= 1;
            }
            res = costs[n];
        }
        for (int i = list.size()-1; i>=0; i--){
            System.out.print(list.get(i) +" ");
        }
    }


    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        calculatorDyn(n);
    }
}
