   public class NQueenSolution { 
    final int boardSize = 10; 
  
    void printSolution(int board[][]){ 
        for (int i = 0; i < boardSize; i++) { 
            for (int j = 0; j < boardSize; j++) 
                System.out.print(" " + board[i][j] + " "); 
            System.out.println(); 
        } 
    }
  
    boolean isSafe(int board[][], int row, int col){ 
        int i, j; 
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) {
                return false; 
            }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (i = row, j = col; j >= 0 && i < boardSize; i++, j--) {
            if (board[i][j] == 1){
                return false; 
            }
        }
        return true; 
    } 

    boolean solveNQUtil(int board[][], int col){
        if (col >= boardSize){
            return true; 
        }
        for (int i = 0; i < boardSize; i++){ 
            if (isSafe(board, i, col)){ 
                board[i][col] = 1; 
                if (solveNQUtil(board, col + 1) == true){
                    return true; 
                } 
                board[i][col] = 0;
            } 
        } 
        return false; 
    } 

    boolean solveNQ(){ 
        int[][] matrix = new int[boardSize][boardSize];
  
        if (solveNQUtil(matrix, 0) == false){ 
            System.out.print("Solution does not exist"); 
            return false; 
        } 
  
        printSolution(matrix); 
        return true; 
    } 

    public static void main(String args[]){ 
        NQueenSolution Queen = new NQueenSolution(); 
        Queen.solveNQ(); 
    } 
} 