import java.io.*;
import java.util.*;

public class TargetSumSubsetOwn {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

                                  // NOT SURE IF IT IS DP but it is not brute force recursive (pepcoding one is probable better)
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        }
        int val = sc.nextInt();
        ArrayList<Integer> al = new ArrayList<>();

        al.add(arr[n-1]);
        al.add(0);

        boolean check = false;

        for(int i=n-2 ; i>0 && check == false ; i--)
        {
            ArrayList<Integer> nl = new ArrayList<>();
            for(int ss : al)
            {
                int num = ss + arr[i];
                nl.add(num);
                if(num == val)
                {
                    check = true;
                    break;
                }
            }

            for( int ss : al)
            {
                nl.add(ss);
                if(ss == val)
                {
                    check = true;
                    break;
                }
            }

            al = nl;
        }

        System.out.println(check);
    }
    
}
