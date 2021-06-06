package GroupAverage;

import java.util.Scanner;

public class Main
{

    class Node
    {
        int num;
        int info;
        double avg;
    }

    public static int computeHash(String s)
    {
        int tableSize=1000;
        int hash = 0;

        for (int i = 0; i < s.length(); i++)
        {
            hash += s.charAt(i);
        }
        return hash % tableSize;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n= sc.nextInt();
        int m= sc.nextInt();
        int[] nodes=new int[1000];

        for(int i=0;i<n;i++)
        {
            sc.next();
            nodes[computeHash(sc.next())]++;
        }


        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += nodes[computeHash(sc.next())];
        }

        System.out.println(sum);

    }


}
