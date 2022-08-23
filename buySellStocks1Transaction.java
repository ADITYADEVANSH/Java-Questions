import java.io.*;
import java.util.*;

public class buySellStocks1Transaction {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0 ; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int maxProfit = Integer.MIN_VALUE;
        int lowest = arr[0];
        
        for(int i=0 ; i<n ; i++)
        {
            if(arr[i] < lowest)
            {
                lowest = arr[i];
            }

            int curProfit = arr[i] - lowest;

            if(curProfit > maxProfit)
            {
                maxProfit = curProfit;
            }
        }

        System.out.println(maxProfit);
    }
    
}
