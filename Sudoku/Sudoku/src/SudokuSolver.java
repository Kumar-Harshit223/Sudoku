
public class SudokuSolver {

	static char[][] board = new char[][] { { '7', '.', '.', '.', '.', '.', '2', '.', '.' },   
        { '4', '.', '2', '.', '.', '.', '.', '.', '3' },   
        { '.', '.', '.', '2', '.', '1', '.', '.', '.' },   
        { '3', '.', '.', '1', '8', '.', '.', '9', '7' },   
        { '.', '.', '9', '.', '7', '.', '6', '.', '.' },   
        { '6', '5', '.', '.', '3', '2', '.', '.', '1' },   
        { '.', '.', '.', '4', '.', '9', '.', '.', '.' },   
        { '5', '.', '.', '.', '.', '.', '1', '.', '6' },   
        { '.', '.', '6', '.', '.', '.', '.', '.', '8' }   
     } ;
     
     static int n=board.length;
	public boolean isSafe(char[][] board, int row ,int col, int number) {
		
		//column
		for(int i=0;i<board.length;i++) {
			if(board[i][col]==(char)(number+'0')) {
				return false;
		}}
		
		//row
		for(int j=0;j<board.length;j++) {
			if(board[row][j]==(char)(number+'0')) {
				return false;
		}}
		
		//grid
		int sr=3*(row/3);
		int sc=3*(col/3);
		for(int i=sr;i<sr+3;i++) {
			for(int j=sc;j<sc+3;j++) {
				if(board[i][j]==(char)(number+'0')) {
					return false;
			}}
		}
		return true;
	}
	
	public boolean helper(char[][] board, int row, int col) {
		if(row==board.length) {
			return true;
		}
		int  nrow=0;
		int ncol=0;
		if(col==board.length-1) {
			nrow=row+1;
			ncol=0;
		}
		else {
			nrow=row;
			ncol=col+1;
		}
		if(board[row][col]!='.') {
			if(helper(board,nrow,ncol)) {
				return true;
			}}
			else {
				for(int i=1;i<=9;i++) {
					if(isSafe(board,row,col,i)) {
						board[row][col]=(char)(i+'0');
						if(helper(board,nrow,ncol))
							return true;
						else
							board[row][col]='.';
					}
				}
			}
		return false;
	}
	public void solveSuduko(char[][] board) {
		helper(board,0,0);
	}
	
	public void display(int n, char[][] board) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		
         SudokuSolver obj=new SudokuSolver();
         System.out.println("Grid is : ");
         for(int i=0;i<n;i++) {
 			for(int j=0;j<n;j++) {
 				System.out.print(board[i][j]+" ");
 			}
 			System.out.println();
 		}
         System.out.println();
         System.out.println();
         System.out.println("solution is : ");
         obj.solveSuduko(board);
         obj.display(n, board);
         
	}
}
