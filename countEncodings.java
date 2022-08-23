import java.io.*;
import java.util.*;

public class countEncodings {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] dp = new int[str.length()];
        dp[0] = 1; 
        boolean fail = false;

        for(int i=1 ; i<str.length() ; i++)
        {
           if(str.charAt(i) == '0')
           {
               if(str.charAt(i-1) > '0' && str.charAt(i-1) <= '2')
               {
                   if(i==1)
                   {
                      dp[i] = 1;
                   }
                   else
                   {
                      dp[i] = dp[i-2];
                   }
               }
               else
               {
                  fail = true;
                  break;
               }
           }
           else
           {
               dp[i] = dp[i-1];

               if( i==1 && str.charAt(i-1) > '0' && str.charAt(i-1) <= '2' && str.charAt(i) <= '6' )
               {
                  dp[i]++;
               }
               else if(str.charAt(i-1) > '0' && str.charAt(i-1) <='2' && str.charAt(i) <= '6')
               {
                  dp[i] = dp[i] + dp[i-2];
               }
           }
        }

        if( !fail && str.charAt(0) != '0' )
        {
            System.out.println(dp[str.length() -1]);
        }
        else
        {
            System.out.println(0);
        }
    }
    
}
