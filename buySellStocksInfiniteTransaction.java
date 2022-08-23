import java.io.*;
import java.util.*;

public class buySellStocksInfiniteTransaction {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        } 

        int buy = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0 ; i<n ; i++)
        {
            if(arr[i] < buy)
            {
                buy = arr[i];
            }

            if(i == n-1)
            {
               if( (arr[i] - buy) > 0)
               {
                   profit = profit + arr[i] - buy;
               }
               continue;
            }

            if(arr[i+1] > arr[i])
            {
               // we will continue holding if the price is icreasing
            }
            else
            {
                profit = profit + arr[i] - buy;
                buy = arr[i];
            }    
        }

        System.out.println(profit);

    }
    
}
