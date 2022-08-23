import java.io.*;
import java.util.*;

public class unboundedKnapsack {
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
       int[] dp = new int[sack+1];
       dp[0] = 0;

       for(int i=1 ; i<=sack ; i++)  // iterating for all i kgs of wt or sacks
       {
           dp[i] = dp[i-1];     // if we do not include any object in this iteration for i kgs sack, i.e. maximum value for i kgs sack is kept the same as i-1 kgs of sack
           for(int j=0 ; j<n ; j++)  //seeing if we can put any of the objects again in this ith iteration that increases our maximum value in ith kg sack
           {
               if( wt[j] <= i )
               {
                   dp[i] = Math.max(dp[i] , dp[ i - wt[j] ] + value[j]); // only put if it is more
               }
           }
       }
       return dp[sack];
	}
}
