package SystemsOfDisjointSets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 30.05.2018.
 */
public class AutomaticProgramAnalysis {
    public static class Set{
        List<Integer> rank;
        int[] parents;
        int n;

        Set(int n){
            this.n = n;
            this.rank = new ArrayList<>();
            parents = new int[n];
        }
        public void makeSet(int i){
            parents[i] = i;
            rank.add(i,0);
        }
        public int find(int i){
            if (parents[i] != i){
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }
        public void union(int i, int j){
            int i_id = find(i);
            int j_id = find(j);
            if (i_id == j_id) return;
            if (rank.get(i_id) > rank.get(j_id)){
                parents[j_id] = i_id;
            } else{
                parents[i_id] = j_id;
                if (rank.get(i_id) == rank.get(j_id)){
                    int r = rank.get(j_id);
                    rank.set(j_id, r+1);
                }
            }
        }
        public boolean check(int i, int j){
            int i_id = find(i);
            int j_id = find(j);
            return  !(i_id == j_id);
        }
    }

    public void run(){
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        int e = scIn.nextInt();
        int d = scIn.nextInt();
        Set set = new Set(n);
        int result = 1;
        for (int k = 0; k < n; k++){
            set.makeSet(k);
        }
        for (int i = 0; i < e; i++){
            int a1 = scIn.nextInt()-1;
            int a2 = scIn.nextInt()-1;
            set.union(a1, a2);
        }
        for (int j = 0; j < d && (result != 0); j++){
            int a1 = scIn.nextInt()-1;
            int a2 = scIn.nextInt()-1;
            if (!set.check(a1, a2)){
                result = 0;
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        new AutomaticProgramAnalysis().run();
    }
}
