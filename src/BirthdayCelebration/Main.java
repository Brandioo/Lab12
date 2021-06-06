package BirthdayCelebration;

import java.util.Scanner;

public class Main
{
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
        int[] nums=new int[500];


        for(int i=0;i<n;i++)
        {
            sc.next();
            sc.next();
            nums[computeHash(sc.next())]++;
            sc.next();
        }

        System.out.println(nums[computeHash(sc.next())]);

    }

}
