package HashTables;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Katerina on 31.05.2018.
 */
public class ChainHashing {
    public static class Element{
        private String string;
        private Element element;
        Element(String str){
            string = str;
            element = null;
        }
        Element(String str, Element elem){
            string = str;
            element = elem;
        }
        public Element getElement(){
            return element;
        }
        public String getString(){
            return string;
        }
        public void setElement(Element element) {
            this.element = element;
        }
        public void setString(String string) {
            this.string = string;
        }
    }
    public static class HashChain{
        private Element[] chain;
        private int p = 1000000007;
        private int x = 263;
        private long[] xPowArray;
        private int m;

        HashChain(int m){
            this.m = m;
            chain = new Element[m];
            xPowArray = new long[15];
            xPowArray[0] = 1;
            for (int i = 1; i< 15; i++){
                xPowArray[i] = modP(xPowArray[i-1] * x, p);
            }
        }
        public void add(String string){
            if (!find(string)){
                int stringHashCode = (int) stringHash(string);
                if (chain[stringHashCode] == null){
                    chain[stringHashCode] = new Element(string);
                } else{
                    Element temp = new Element(string, chain[stringHashCode]);
                    chain[stringHashCode] = temp;
                }
            }
        }
        public void del(String string){
            if (find(string)){
                int stringHashCode = (int) stringHash(string);
                Element prev = chain[stringHashCode];
                Element curr = chain[stringHashCode].getElement();
                if (prev.getString().equals(string)){
                    chain[stringHashCode] = curr;
                } else{
                    while (!curr.getString().equals(string)){
                        prev = curr;
                        curr = curr.getElement();
                    }
                    prev.setElement(curr.getElement());
                }
            }
        }
        public boolean find(String string){
            int stringHashCode = (int) stringHash(string);
            Element curr = chain[stringHashCode];
            while (curr != null){
                if (curr.getString().equals(string)){
                    break;
                }
                curr = curr.getElement();
            }
            return (curr != null);
        }
        public void check(int i){
            StringBuilder result = new StringBuilder();
            if (chain[i] == null){
                result.append("");
            } else{
                Element curr = chain[i];
                while (curr != null){
                    result.append(curr.getString() + " ");
                    curr = curr.getElement();
                }
            }
            System.out.println(result.toString());
        }
        public long stringHash(String string){
            long hashSum = 0;
            char[] strChars = string.toCharArray();
            int strLength = string.length();
            for (int i = 0; i < strLength; i++){
                long charCode = modP((long) strChars[i], p);
                hashSum += modP(charCode*xPowArray[i], p);
            }
            hashSum = modP(hashSum, p);
            return modP(hashSum, m);
        }
        public long modP(long a, long module) {
            if (a < module) {
                if (a <= 0) {
                    return modP(a + module, module);
                }
                return a;
            }
            return a % module;
        }
    }
    public void run(){
        Scanner scIn = new Scanner(System.in);
        int m = scIn.nextInt();
        int n = scIn.nextInt();
        HashChain hashChain = new HashChain(m);
        for (int i = 0; i<n; i++){
            String command = scIn.next();
            String str;
            switch (command){
                case "add":
                    str = scIn.next();
                    hashChain.add(str);
                    break;
                case "del":
                    str = scIn.next();
                    hashChain.del(str);
                    break;
                case "find":
                    str = scIn.next();
                    if(hashChain.find(str)){
                        System.out.println("yes");
                    } else{
                        System.out.println("no");
                    }
                    break;
                case "check":
                    int num = scIn.nextInt();
                    hashChain.check(num);
                    break;
                default:
                    break;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        new ChainHashing().run();
    }
}
