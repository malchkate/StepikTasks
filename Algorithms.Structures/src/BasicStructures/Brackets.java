package BasicStructures;

import java.util.Scanner;

/**
 * Created by Katerina on 02.05.2018.
 */
public class Brackets {
    class Pair{
        private int index;
        private char aChar;

        Pair(int index, char aChar){
            this.index = index;
            this.aChar = aChar;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setaChar(char aChar) {
            this.aChar = aChar;
        }

        public int getIndex() {
            return index;
        }

        public char getaChar() {
            return aChar;
        }
    }

    public class Stack{
        int topElem = -1;
        Pair[] pairs;

        Stack(int size){
            pairs = new Pair[size];
        }

        public void push(Pair pair){
            topElem++;
            pairs[topElem] = pair;
        }

        public Pair top(){
            return pairs[topElem];
        }

        public Pair pop(){
            return pairs[topElem--];
        }

        public boolean isEmpty(){
            return (topElem  < 0);
        }

    }

    public  String go(){
        Scanner scIn = new Scanner(System.in);
        String str = scIn.next();
        char[] chars = str.toCharArray();
        int length = chars.length;
        Stack stack = new Stack(length);
        boolean hasMistake = false;
        for (int i = 0; i < length; i++){
            char elem = chars[i];
            switch (elem){
                case '(':
                    stack.push(new Pair(i, elem));
                    break;
                case '{':
                    stack.push(new Pair(i, elem));
                    break;
                case '[':
                    stack.push(new Pair(i, elem));
                    break;
                case ')':
                    if (stack.isEmpty() || stack.top().getaChar() != '('){
                        return "" +(i + 1);
                    } else{
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.top().getaChar() != '{'){
                        return "" +(i + 1);
                    } else{
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.top().getaChar() != '['){
                        return "" +(i + 1);
                    } else{
                        stack.pop();
                    }
                    break;
                default:
                    break;
            }
            if(hasMistake){
                break;
            }
        }
        if (!stack.isEmpty()){
            Pair pair = stack.pop();
            while (!stack.isEmpty()){
                pair = stack.pop();
            }
            return "" +(pair.getIndex()+1);
        }
        return "Success";
    }
    public static void main(String[] args) {
        System.out.println(new Brackets().go());
    }
}
