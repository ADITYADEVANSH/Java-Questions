import java.io.*;
import java.util.*;

public class paintHouseManyColors {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<m ; j++)
            {
               arr[i][j] = sc.nextInt();
            }
        }

       int[][]dp = new int[n][m];
       int min1 = Integer.MAX_VALUE;
       int min2 = Integer.MAX_VALUE;

       for(int i=0 ; i<m ; i++)
       {
           dp[0][i] = arr[0][i];
           if( dp[0][i] < min1)
           {
              min2 = min1;
              min1 = dp[0][i];
           }
           else if( dp[0][i] < min2 )
           {
               min2 = dp[0][i];
           } 
           
       }

       for(int i=1 ; i<n ; i++)
       {
           int newMin1 = Integer.MAX_VALUE;
           int newMin2 = Integer.MAX_VALUE;

           for(int j=0 ; j<m ; j++)
           {
               if( dp[i-1][j] == min1)      // if they are same than chances are we might be painting two houses with same colour in a row
               {
                  dp[i][j] = arr[i][j] + min2;
               }
               else{
                  dp[i][j] = arr[i][j] + min1;
               }

               if( dp[i][j] < newMin1)             // updating min1 and min2 for next house to paint
               {
                  newMin2 = newMin1;
                  newMin1 = dp[i][j];
               }
               else if( dp[i][j] < newMin2 )
               {
                  newMin2 = dp[i][j];
               }
           }

           min1 = newMin1;
           min2 = newMin2;
       }
       
       int sol = Integer.MAX_VALUE;
       for(int i=0 ; i<m ; i++)
       {
          sol = Math.min(sol , dp[n-1][i]);
       }

       System.out.println(sol);
       
    }
    
}
