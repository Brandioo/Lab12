package Censored_Hash;



import java.util.ArrayList;
import java.util.Scanner;

class Node1 {
    public String name;
    int val;

    Node1(){
        name="";
        val=0;
    }
    Node1(String n){
        name=n;
        val=1;
    }
}
public class Censored_UDHash {
    static int pKey = 31, tableSize, Max;

    public static int hash(String key) {
        int res = 0, len = Math.min(key.length(), 6);
        for (int i = 0; i < len; i++) {
            res = (pKey * res + key.charAt(i)) % tableSize;

            if (res < 0) {
                res += tableSize;

            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();

        tableSize = firstPrime(n);

        System.out.println("tableSize= " + tableSize + "\n");

        ArrayList<Node1>[] words = new ArrayList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            words[i] = new ArrayList();
        }
        for (int i = 0; i < n; i++) {
            String key = fin.next().toLowerCase();
            int pos = hash(key);
            int j = contains(words, key, pos);
            if (j == -1) {
                words[pos].add(new Node1(key));
            }
        }
        while (fin.hasNext()) {
            String key = fin.next();
            int pos = hash(key.toLowerCase());
            int j = contains(words, key.toLowerCase(), pos);
            if (j >= 0) {
                System.out.println("**** ");
            } else {
                System.out.println(key + " ");
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2)
            return false;
        if (n < 4)
            return false;
        if (n % 2 == 0)
            return false;
        int sqn = (int) Math.sqrt(n);
        for (int i = 3; i <= sqn; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    static int firstPrime(int n) {
        if (isPrime(n))
            return n;
        if (n % 2 == 0)
            n++;
        for (int i = n; i <= 2 * n; i += 2)
            if (isPrime(i))
                return i;
        return 2 * n;
    }

    static int contains(ArrayList<Node1>[] words, String key, int pos){
        if(words[pos].size()==0)
            return -1;
        int len=words[pos].size();
        for(int i=0;i<len;i++){
            Node1 tmp=words[pos].get(i);
            if(tmp.name.equals(key))
                return i;
        }
        return -1;
    }
}
