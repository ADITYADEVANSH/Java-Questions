import java.io.*;
import java.util.*;

public class arrangeBuildings {

public static void main(String[] args) throws Exception {
        // same as countBinaryStrings dp question just need to square th result for both sides of road thing
       //here 0 means buildings and 1 means spaces
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();

int[][]dp = new int[2][n+1]; // 0 row for n means how many posiblities following the rules for arrangements such that they end with 0 and vice versa for row 1

dp[0][1] = 1;                          
dp[1][1] = 1;

for(int i=2 ; i<=n ; i++)
{
    dp[0][i] = dp[1][i-1];
    dp[1][i] = dp[0][i-1] + dp[1][i-1];
}

long total = dp[0][n] + dp[1][n];
total = total * total;
System.out.println( total );
}
    
}
