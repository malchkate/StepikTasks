package BasicStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Katerina on 03.05.2018.
 */
public class StackMax {

    public class Stack{
        int topElem = -1;
        int[] maxStack;

        Stack(int size){
            maxStack = new int[size];
        }

        public void push(int elem){
            topElem++;
            if (topElem > 0){
                maxStack[topElem] = Math.max(elem, maxStack[topElem -1]);
            } else{
                maxStack[topElem] = elem;
            }
        }

        public void pop(){
            topElem--;
        }

        public int max(){
            return maxStack[topElem];
        }
    }

    public void go() throws IOException {
        BufferedReader buffIn = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        n = Integer.parseInt(buffIn.readLine());
        Stack stack = new Stack(n);
        for (int i = 0; i < n; i++){
            String str = buffIn.readLine();
            switch (str){
                case "pop":
                    stack.pop();
                    break;
                case "max":
                    System.out.println(stack.max());
                    break;
                default:
                    String[] parts = str.split(" ");
                    stack.push(Integer.parseInt(parts[1]));
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new StackMax().go();
    }
}
