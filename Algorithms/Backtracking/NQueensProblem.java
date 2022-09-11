public class NQueensProblem {
	private static int solutionCount = 0;
	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[][] board = new int[N][N];
		
		System.out.println("Solving for " + N + " queens problem");

		solve(board, N, 0);
		
		System.out.println("No. of solutions are: " + solutionCount);
	}
	
	private static void solve(int[][] board, int N, int row) {
		if (row == N) {
            ++solutionCount;
            System.out.println("Board solution " + solutionCount + ":");
            printBoard(board, N);
			return;
		}
		
		// loop for each column in a row and place queen on safe pos
		for (int col = 0; col < N; ++col) {
			if (isSafe(board, N, row, col) == true) {
				board[row][col] = 1;
				solve(board, N, row+1);
				
				// backtrack board position
				board[row][col] = 0;
			}
		}
	}
	
	private static boolean isSafe(int[][] board, int N, int posX, int posY) {
		// check horizontal safe
		for (int i=0; i<N; ++i) {
			if (board[i][posY] == 1)
				return false;
		}
		// check vertical safe
		for (int i=0; i<N; ++i) {
			if (board[posX][i] == 1)
				return false;
		}
		// check diagonal safe
		// check for diagonal starting from lower left corner
		for (int i=0; i<N; ++i) {
			int x = posX-i;
			int y = posY-i;
			if (x >= 0 && y >= 0 && x < N && y < N && board[x][y] == 1)
				return false;
		}
		// check upper part of diagonal
		// check for diagonal starting from lower right corner
		for(int i = 0; i < N; ++i) {
			int x = posX+i;
			int y = posY-i;
			if (x >= 0 && y >= 0 && x < N && y < N && board[x][y] == 1)
				return false;
			x = posX-i;
			y = posY+i;
			if (x >= 0 && y >= 0 && x < N && y < N && board[x][y] == 1)
				return false;
		}

		return true;
	}
	
	private static void printBoard(int[][] board, int N) {
		for(int i=0; i<N; ++i) {
			for (int j=0; j<N; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}