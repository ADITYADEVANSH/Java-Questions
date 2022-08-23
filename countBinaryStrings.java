import java.io.*;
import java.util.*;

public class countBinaryStrings {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    
        int[][]dp = new int[2][n+1]; // i ade it n+1 for just simplyfing value of i in the below 'for loop'
                                  // we dont need dp[0][0] and dp[1][0]
        dp[0][1] = 1;
        dp[1][1] = 1;
    
        for(int i=2 ; i<=n ; i++)
        {
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1] + dp[1][i-1];
        }
        System.out.println(dp[0][n] + dp[1][n]);
     }
    
}
