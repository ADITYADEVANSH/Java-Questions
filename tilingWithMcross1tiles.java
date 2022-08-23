import java.io.*;
import java.util.*;

public class tilingWithMcross1tiles {

    public static void main(String[] args) throws Exception {

        // if geting confused, see the video for previous question i.e. tiling with 2*1 tiles
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        int[]dp = new int[n+1];
        dp[0] = 1;

        for(int i=1 ; i<=n ; i++)
        {
            if(i < m)
            {
                dp[i] = 1;  //jab tak n, m se chota hai tab tak sirf ek hi tareekw se kar sakte hai i.e. virtically place karke kyoki laterally ke liye n ko atleast m ke equal hona padega
            }
            else
            {
                dp[i] = dp[i-1] + dp[i-m];    //virtically rakh kar backe huye n ke tareeke + jab laterally rakhenge to n-1 space bachegi to uske tareeke 
            }
        }

        System.out.println(dp[n]);
    }
    
}
