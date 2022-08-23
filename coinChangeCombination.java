import java.io.*;
import java.util.*;

public class coinChangeCombination {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        }

        int val = sc.nextInt();

        System.out.println( coinChange(arr , n , val) );

    }

    public static int coinChange(int[] arr , int n , int val)
    {
        int[] dp = new int[val+1];
        dp[0] = 1;

        for(int i=1 ; i<=val ; i++)
        {
            dp[i] = 0;
            for( int num : arr )
            {
                if(num <= i)
                {
                   dp[i] = dp[i] + dp[i-num];
                }
            }
        }
        return dp[val];
    }
    
}
