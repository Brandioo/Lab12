package ConfusionMatrix;

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
        Scanner input=new Scanner(System.in);

        int n= input.nextInt(), m= input.nextInt();
        String[] words=new String[n];
        int[][] nums=new int[10000][10000];

        for(int i=0;i<n;i++)
        {
            words[i]= input.next();
        }

        for(int i=0;i<m;i++)
        {
            String word= input.next();
            String word1= input.next();
            nums[computeHash(word)][computeHash(word1)]++;
        }

        for(int i=0;i< n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(nums[computeHash(words[i])][computeHash(words[j])]+" ");
            }
            System.out.println();
        }
    }



}
