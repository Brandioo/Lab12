package Ques1_Censored;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Censored {
    //Array
    static boolean find(String[] List, String text){
        for(String s: List){
            if(s.equals(text)){
                return true;
            }
        }
        return false;
    }
    static boolean binarySearch(String[] arr, String x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = x.compareTo(arr[m]);

            // Check if x is present at mid
            if (res == 0)
                return true;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub


        Scanner fin = new Scanner(new FileReader("src/Ques1_Censored/input1.txt"));

        int n = fin.nextInt();

        String text;
        String[] List = new String[n];


        for (int i = 0; i < n; i++) {
            text = fin.next();
            List[i] = text.toLowerCase();
        }


        long startTime = System.currentTimeMillis();
//        Arrays.sort(List);

        while (fin.hasNext()) {
            text = fin.next();
           if (find(List,text.toLowerCase())) {  // It took    1 milliseconds
//                if(binarySearch(List,text.toLowerCase())) // It took      3 milliseconds
                System.out.print("**** ");
            }
            else
                System.out.print(text + " ");

        }
        System.out.println();

        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println(String.format("\nIt took %7d milliseconds", elapsed));


    }
}

