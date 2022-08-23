import java.io.*;
import java.util.*;

public class coinChangeCombintion {

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
        Arrays.fill(dp,0);
        dp[0] = 1; 

        for(int num : arr)
        {
            for(int i=1 ; i<=val ; i++)
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
