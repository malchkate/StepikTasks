package Solutions.FibNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by Katerina on 09.04.2018.
 */
public class SmallFibNumber {

    public static long fibNum_D (int n){
        List<Long> list = new ArrayList<Long>();
        list.add((long)1);
        list.add((long)1);
        for (int i = 0; i < n - 1; i++){
            int lastInd = list.size() - 1;
            list.add(list.get(lastInd) + list.get(lastInd - 1));
        }
        return list.get(list.size()-1);

    }
    public static void main(String[] args) {
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        long res = fibNum_D(n-1);
        System.out.println(res);
    }
}


