import java.io.*;
import java.util.*;

public class paintFence {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        long[][] dp = new long[2][n];
        dp[0][0] = 0;
        dp[1][0] = k;

        for(int i=1 ; i<n ; i++)
        {
           dp[0][i] = dp[1][i-1];
           dp[1][i] = dp[0][i-1]*(k-1) + dp[1][i-1]*(k-1);
        }
        
        System.out.println(dp[0][n-1] + dp[1][n-1]);
    }
    
}
