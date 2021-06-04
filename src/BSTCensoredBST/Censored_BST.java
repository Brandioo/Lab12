package BSTCensoredBST;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

class Node {
    public String val;
    public Node left, right;

    public Node(String x) {
        val = x;
        left = right = null;
    }
}

public class Censored_BST {
    public static Node insert(String x, Node T) {
        if (T == null) {
            T = new Node(x);
        } else if (T.val.compareTo(x) > 0) {
            T.left = insert(x, T.left);
        } else if (T.val.compareTo(x) < 0) {
            T.right = insert(x, T.right);
        }
        return T;
    }

    public static void print(Node T) {
        if (T.left != null)
            print(T.left);
        System.out.println(T.val + ", ");
        if (T.right != null)
            print(T.right);
    }

    public static boolean find(String t, Node T) {
        if (T == null)
            return false;
        if (T.val.compareTo(t) == 0)
            return true;
        if (T.val.compareTo(t) < 0)
            return find(t, T.right);
        return find(t, T.left);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fin = new Scanner(System.in);
        Node T = null;

        int n = fin.nextInt();
        String text;

        for (int i = 0; i < n; i++) {
            text = fin.next();
            T = insert(text.toLowerCase(), T);
        }
        long startTime = System.currentTimeMillis();


        while (fin.hasNext()) {
            text = fin.next();
            if (find(text.toLowerCase(), T)) {  // It took    1 milliseconds
//                if(binarySearch(List,text.toLowerCase())) // It took      3 milliseconds
                System.out.print("**** ");
            }
            else {
                System.out.print(text + " ");
            }

        }

        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println(String.format("\nIt took %7d milliseconds", elapsed));
    }
}
