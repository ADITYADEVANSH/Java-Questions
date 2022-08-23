import java.io.*;
import java.util.*;

public class countABCsubsequences {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
             //HAVENT TESTED THIS CODE YET   //MAY CONTAIN SOME LOGICAL ERRORS
        String str = sc.next();
        int[][] dp = new int[str.length() + 1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;
        
        for(int i=1 ; i<=str.length() ; i++)
        {
            
            if(str.charAt(i-1) == 'a')
            {
               if(dp[i-1][0] == 0)
               {
                   dp[i][0] = 1;
               }
               else{
                   dp[i][0] = dp[i-1][0] * 2;
               }
               
               dp[i][1] = dp[i-1][1];
               dp[i][2] = dp[i-1][2];
            }
            else if(str.charAt(i-1) == 'b')
            {
               dp[i][0] = dp[i-1][0];
               dp[i][1] = (dp[i-1][1] * 2) + dp[i][0];
               dp[i][2] = dp[i-1][2];
            }
            else if(str.charAt(i-1) == 'c')
            {
               dp[i][0] = dp[i-1][0];
               dp[i][1] = dp[i-1][1];
               dp[i][2] = (dp[i-1][2] * 2) + dp[i][1];
            }
            
        }
 
        System.out.println(dp[str.length()][2]);
     }
    
}
