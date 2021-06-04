package CensoredTreeMap;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Censored_TreeMap {
    static Scanner inp;
    static StringTokenizer stok;
    static TreeMap<String, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        inp = new Scanner(System.in);
        int n = inp.nextInt();
        String tmp;
        int a;
        for (int i = 0; i < n; i++) {
            tmp = inp.next();
            map.put(tmp.toLowerCase(), 1);
        }
        int cnt = 0;

        long startTime = System.currentTimeMillis();
        while (inp.hasNext()) {
            cnt++;
            tmp = inp.next();
            if (map.containsKey(tmp.toLowerCase())) {
                System.out.print("**** ");
            } else {
                System.out.print(tmp + " ");
            }
        }
    }
}
