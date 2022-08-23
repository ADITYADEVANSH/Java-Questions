import java.io.*;
import java.util.*;

public class solveSudoku {

    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
      }
    
      public static boolean valid( int[][] board , int row , int col , int num )
      {
        for(int j = 0 ; j<board[0].length ; j++)   // checking vertically
        {
          if(board[row][j] == num)
          {
            return false;
          }
        }
    
        for(int i = 0 ; i<board.length ; i++)   //checking horizontally
        {
          if(board[i][col] == num)
          {
            return false;
          }
        }
    
        int localRow = (row/3) * 3;
        int localCol = (col/3) * 3;
    
        for(int i=localRow ; i<localRow+3 ; i++) // checking in mini square
        {
          for( int j=localCol ; j<localCol+3 ; j++)
          {
            if( board[localRow][localCol] == num )
            {
              return false;
            }
          }
        }
    
        return true;
      }
    
      public static void solveSudoku(int[][] board, int row, int col) {
        
        if( row == board.length )
        {
          display(board);
          System.out.println("\n");
          return;
        }
    
        if( col == board[0].length )
        {
          solveSudoku(board , row+1 , 0);
          return;
        }
        
        if(board[row][col] != 0)
        {
          solveSudoku(board , row , col+1);
          return;
        }
    
          for(int i=1 ; i<=9 ; i++)
          {
            if( valid(board , row , col , i) )
            {
              board[row][col] = i;
              solveSudoku( board , row , col+1 );
              board[row][col] = 0;
            }  
          }
    
      }
    
      public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            arr[i][j] = scn.nextInt();
          }
        }
    
        solveSudoku(arr, 0, 0);
      }
    
}
