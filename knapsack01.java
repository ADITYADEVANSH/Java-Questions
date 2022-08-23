import java.io.*;
import java.util.*;

public class knapsack01 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] value = new int[n];
        int[] wt = new int[n];

        for(int i=0 ; i<n ; i++)
        {
            value[i] = sc.nextInt();
        }

        for(int i=0 ; i<n ; i++)
        {
            wt[i] = sc.nextInt();
        }

        int sack = sc.nextInt();

        System.out.println( knapSack(value , wt , n , sack) );

    }

    public static int knapSack(int[] value , int[] wt , int n , int sack)
    {
       int[][] dp = new int[n+1][sack +1];

       for(int i=0 ; i<=n ; i++)
       {
           for(int j=0 ; j<=sack ; j++)
           {
               if(i == 0)
               {
                   dp[i][j] = 0;
               }
               else if( j == 0)
               {
                  dp[i][j] = 0;
               }
               else if(wt[i-1] <= j)
               {
                   dp[i][j] = Math.max( dp[i-1][j] , value[i-1] + dp[i-1][j - wt[i-1]] );
               }
               else{
                   dp[i][j] = dp[i-1][j];               // this is the important prt, that I missed earlier. IMP!!!!!
               }
           }
       }
       return dp[n][sack];
    }
    
}
