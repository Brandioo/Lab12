package BuyTheCheapest;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class TreeMain {

    public static void main(String[] args) {
        AVL tree = new AVL();
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> packs = new ArrayList<>();

        int[] array = new int[n];
        int [] sum=new int[n/2];

        for (int i = 0; i < n; i++)
        {
            packs.add(input.next());
            array[i] = input.nextInt();
        }

        int cnt=0;

        for (int i = 0; i < n; i++)
        {
            int c=0;
            for (int j = i + 1; j < n; j++) {
                if (packs.get(i).equals(packs.get(j)))
                {
                    int res = array[i] + array[j];
                    sum[cnt] = res;
                    cnt++;
                }
            }
        }
        LinkedHashSet<String> hashSet = new LinkedHashSet<>(packs);

        ArrayList<String> listWithoutDuplicates = new ArrayList<>(hashSet);


        for(int i=0;i<sum.length;i++)
        {
            tree.insert(sum[i]/2,listWithoutDuplicates.get(i));
        }

        String [] print=tree.print(m);
        for(int i=m-1;i>=0;i--)
        {
            System.out.println(print[i]);
        }
    }
}
