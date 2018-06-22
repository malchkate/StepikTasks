package HashTables;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Katerina on 01.06.2018.
 */
public class RabinKarpAlgorithm {
    public static class HashChain{
        private int patternLength;
        private int textLength;
        private int p = 1000000007;
        private int x = 263;
        private long[] hashes;
        private String text;
        private String pattern;
        private long[] xPowArray;
        private char[] textChars;
        private char[] patternChars;
        private long patternHash;

        HashChain(String pattern, String text){
            this.pattern = pattern;
            this.text = text;

            this.patternLength = pattern.length();
            this.textLength = text.length();

            this.hashes = new long[textLength - patternLength + 1];
            this.xPowArray = new long[patternLength];

            this.textChars = text.toCharArray();
            this.patternChars = pattern.toCharArray();

            xPowArray[0] = 1;
            for (int i = 1; i< patternLength; i++){
                xPowArray[i] = modP(xPowArray[i-1] * x);
            }

            patternHash = stringHash(pattern);

            calculateHashes();
        }
        public void calculateHashes(){
            List<Integer> listRes = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            hashes[textLength - patternLength] = stringHash(text.substring(textLength - patternLength, textLength));
            if (hashes[textLength-patternLength] == patternHash){
                if(compareSubstrings(textLength-patternLength)){
                    listRes.add(textLength-patternLength);
                }
            }
            for (int i = textLength - patternLength - 1; i >= 0; i--){
                hashes[i] = modP(modP(modP(hashes[i+1] -
                        modP((long)textChars[i + patternLength]* xPowArray[patternLength-1])) * x) + textChars[i]);
                if (hashes[i] == patternHash){
                    if(compareSubstrings(i)){
                        listRes.add(i);
                    }
                }
            }
            for (int i = listRes.size()-1; i >= 0; i--){
                    result.append(listRes.get(i) + " ");
            }
            System.out.println(result.toString());
        }
        public long stringHash(String string){
            long hashSum = 0;
            char[] strChars = string.toCharArray();
            int strLength = string.length();
            for (int i = 0; i < strLength; i++){
                long charCode = modP((long) strChars[i]);
                hashSum += modP(charCode * xPowArray[i]);
            }
            return modP(hashSum);
        }
        public long modP(long a) {
            return ((a % p) + p) % p;
        }
        public boolean compareSubstrings(int startIndex) {
            return text.substring(startIndex, startIndex + patternLength).equals(pattern);
        }
    }

    public void findPatternEntries(){
        Scanner scIn = new Scanner(System.in);
        String pattern = scIn.next();
        String text = scIn.next();
        new HashChain(pattern,text);

    }
    public static void main(String[] args) {
        new RabinKarpAlgorithm().findPatternEntries();
    }
}
