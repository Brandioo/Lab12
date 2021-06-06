package BuyTheCheapest;

import java.util.Scanner;

public class Main
{
    static int tableSize = 1000;

    public static int computeHash (int id)
    {
        return id % tableSize;
    }

    public static void main (String args[])
    {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(), m = input.nextInt();

        int prices[] = new int[1000];

        for (int i = 0; i < n; i++) {
            prices[computeHash(input.nextInt())] = Math.min(input.nextInt(), input.nextInt());
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += prices[computeHash(input.nextInt())];
        }

        System.out.println(sum);
    }
}
