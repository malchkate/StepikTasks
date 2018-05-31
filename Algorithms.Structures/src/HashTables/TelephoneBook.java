package HashTables;

import java.util.Scanner;

/**
 * Created by Katerina on 31.05.2018.
 */
public class TelephoneBook {
    public void run(){
        Scanner scIn = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int n = scIn.nextInt();
        String[] telephoneBook = new String[10000000];
        for (int i = 0; i < n; i++){
            String command = scIn.next();
            int num = scIn.nextInt();
            switch (command){
                case "add":
                    String name = scIn.next();
                    telephoneBook[num] = name;
                    break;
                case "del":
                    telephoneBook[num] = null;
                    break;
                case "find":
                    String str = telephoneBook[num];
                    if (str != null){
                        result.append(str + "\n");
                    } else{
                        result.append("not found \n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(result.toString());
    }
    public static void main(String[] args) {
        new TelephoneBook().run();
    }
}
