package BirthdayCelebration;

import java.util.Scanner;

public class TreeMain {

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        AVL tree=new AVL();

        for( int i=0;i<n;i++){
            input.next();
            input.next();
            String month=input.next();
            input.next();
            tree.insert(month);
        }

        String givenMonth=input.next();

        System.out.println(tree.search(givenMonth));
    }


}
