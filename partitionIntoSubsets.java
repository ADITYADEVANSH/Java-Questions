import java.io.*;
import java.util.*;

public class partitionIntoSubsets {

    public static long partitionKSubset(int n, int k) {
        // write your code here

        long[][] dp = new long[n+1][k+1];

        for(int i=1 ; i<=n ; i++)
        {
            for(int j=1 ; j<=k ; j++)
            {
                if(j==1 || i==j)
                {
                   dp[i][j] = 1;
                }
                else if(j>i)
                {
                    dp[i][j] = 0;
                }
                else
                {
                    dp[i][j] = (dp[i-1][j] * j) + dp[i-1][j-1];
                }
            }
        }

        return dp[n][k];
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        long res = partitionKSubset(n, k);
        System.out.println(res);


    }
    
}
