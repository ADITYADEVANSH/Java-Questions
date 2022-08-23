import java.io.*;
import java.util.*;

public class maximunSumNonAdjacentElements {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;     
        dp[0][1] = 0;        
        
        for(int i=1 ; i<=n ; i++)
        {
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]);  // 0 means ith element is not included in the sum
            dp[i][1] = arr[i-1] + dp[i-1][0];                // 1 means ith element is included in the sum
                    //here we are doing arr[i-1] because out dp size is n+1;
        }
        System.out.println( Math.max(dp[n][0] , dp[n][1]) );
    }
    
}
