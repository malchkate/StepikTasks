package SystemsOfDisjointSets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Katerina on 30.05.2018.
 */
public class TablesJoin {

    public static class Set{
        List<Integer> records;
        List<Integer> rank;
        int[] parents;
        int n;
        int max = -1;

        Set(int n){
            this.n = n;
            this.records = new ArrayList<>();
            this.rank = new ArrayList<>();
            parents = new int[n];
        }
        public void makeSet(int i, int recordsAmount){
            parents[i] = i;
            records.add(i, recordsAmount);
            rank.add(i,0);
            if (recordsAmount > max){
                max = recordsAmount;
            }
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
                int temp = records.get(j_id) + records.get(i_id);
                records.set(j_id, 0);
                records.set(i_id, temp);
                if (max < temp){
                    max = temp;
                }
            } else{
                parents[i_id] = j_id;
                int temp = records.get(j_id) + records.get(i_id);
                records.set(i_id, 0);
                records.set(j_id, temp);
                if (max < temp){
                    max = temp;
                }
                if (rank.get(i_id) == rank.get(j_id)){
                    int r = rank.get(j_id);
                    rank.set(j_id, r+1);
                }
            }
        }
        public int max(){
            return this.max;
        }

    }

    public void run(){
        Scanner scIn = new Scanner(System.in);
        int n = scIn.nextInt();
        int m = scIn.nextInt();
        Set set = new Set(n);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++){
            set.makeSet(i, scIn.nextInt());
        }
        for (int j = 0; j < m; j++){
            int destination = scIn.nextInt()-1;
            int source = scIn.nextInt()-1;
            set.union(destination, source);
            result.append("" + set.max() + "\n");
        }
        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        new TablesJoin().run();
    }
}
