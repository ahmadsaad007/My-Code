/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion.games;

/**
 *
 * @author Ahmad Saad
 */
public class Chess {
    
    static int board[][];
    static int len;

    public void setBoard(int n) {
        board = new int[n][n];
        len = n;
        fillBoard();
    }
    public void fillBoard(){
        for(int i=0; i<len;i++){
            for(int j=0; j < len; j++){
                board[i][j] = 0;
            }
        }
    }
    public boolean solve( int col){
        int l = board.length;
        
        if(col >= l){
            return true;
        }
        for(int i = 0; i< l; i++ ){
            
            if(valid(i, col)){
                board[i][col] = 1;
                if(solve(col+1)==true){
                    return true;
                }
                board[i][col]=0;
            }
        }
        return false;
    }
    public boolean valid( int row, int col ){
        
        for(int i =0; i < len; i++){
            if(board[i][col]==1||board[row][i]==1)
                return false;
        }
         
        for(int i= row, j = col; i >= 0 && j >= 0 ; i--, j--){
            if(board[i][j]==1)
                return false;
        }    
        for(int i = row, j = col; j >= 0 && i< len; i++, j--){
            if(board[i][j]==1)
                return false;
        }
        return true;
    }
    public void print(){
        for(int i = 0; i< len; i++){
            for(int j = 0; j < len; j++){
                System.out.print(board[i][j]+" ");
            } 
            System.out.println("");
        }
    }
}
