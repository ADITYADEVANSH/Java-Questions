import java.io.*;
import java.util.*;

public class shortestPathStairs {

    public static void print(int[] arr , int n)
    {
        System.out.println();
        for( int i=0 ; i<=n ; i++)
        {
           System.out.print(arr[i]); // 
        }
    }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    
    for( int i=0 ; i<n ; i++)
    {
        arr[i] = sc.nextInt();
    }
    
    int[] ansArr = new int[n+1];
    Arrays.fill(ansArr, Integer.MAX_VALUE - 1);
    ansArr[n] = 0;
    
    
    
    for( int i = n-1 ; i>=0 ; i--)
    {
 
        for(int j=1 ; i+j < ansArr.length && j<=arr[i] ; j++ )
        {
           //     System.out.println("comparing for: " + i + " at: " + (i+j));
           ansArr[i] = Math.min(ansArr[i] , ansArr[i+j]);
           
        }
        ansArr[i] = ansArr[i] + 1;
        //     System.out.println("minimum steps at " + i + " = " + ansArr[i]);
    }
    
    System.out.println(ansArr[0]);
  }
    
}
