import java.io.*;
import java.util.*;

public class buySellStocksInfiniteTransactionWithFee {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int fee = sc.nextInt();

        // int[][] dp = new int[n][2];     this a way too buy I am using more optimized way
        // dp[0][0] = -arr[0];
        // dp[1][0] = 0;

        int endingBuy = -arr[0];      // to take note of best situation ending with a buy
        int endingSell = 0;           // to take note of best situation ending with a sell        

        for(int i=1 ; i<n ; i++)
        {
            int buy = Math.max(endingBuy , endingSell -arr[i]);  // jo bhi less negative hai vo aayega   // jo jitna bada hota hai, uska negative utna hi chota hota hai
            // negative signifies 'loan'(not technically) here we have to pay for buying stock so we are miniizing it by taking max of the negative values of stock prices
            
            int sell = Math.max(endingSell , arr[i] + endingBuy - fee); 
            // maximizing our profit buy comparing last sold to if we sold at ith point
            // reason for '+ endingSell' : because endingBuy is already negative in most case, (NOT ALL) if it is positive matlab ki loan nahi lena pada, pahele ke profit se hi arrange ho gaya

            endingBuy = buy;
            endingSell = sell;
        }

        System.out.println( Math.max(endingBuy , endingSell) );

    }
    
}
