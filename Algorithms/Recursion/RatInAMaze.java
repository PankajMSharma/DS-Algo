import java.util.*;

class RatInAMaze {
	public static void main(String[] args) {
		int[][] maze = { { 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1 } };
		
		ArrayList<String> solutions = findPath(maze, maze.length);
		
		// Print all possible paths
		for(int i = 0; i < solutions.size(); i++)
			System.out.print(solutions.get(i) + " ");
	}

    public static ArrayList<String> findPath(int[][] m, int n) {
        
        ArrayList<String> solutions = new ArrayList<>();
        
        if (m[0][0] == 0) { // If start itself is 0
            return solutions;
        }
        
        int[][] visited = new int[n][n]; // would be initialized with 0 as default value
        
        solveMaze(m, n, solutions, visited, 0, 0, new StringBuilder(""));
        
        // sort solutions in lexical order
        Collections.sort(solutions);
        return solutions;
    }
    
    private static void solveMaze(int[][] m, int n, ArrayList<String> solutions, 
                                int[][] visited, int posX, int posY, StringBuilder currentPath) {
        if (posX == n-1 && posY == n-1) {
            solutions.add(currentPath.toString());
            return;
        }
        
        // mark current position as visited
        visited[posX][posY] = 1;
        
		// Below checks looks if new positions should be within maze, should not be visited and should not be blocked in maze
        // For Down (x+1, y)
        if (posX+1 < n && posX+1 >= 0 && visited[posX+1][posY] == 0 && m[posX+1][posY] == 1) {
            solveMaze(m, n, solutions, visited, posX+1, posY, currentPath.append("D"));
            currentPath.deleteCharAt(currentPath.length()-1);
        }
        // For Left
        if (posY-1 < n && posY-1 >= 0 &&  visited[posX][posY-1] == 0 && m[posX][posY-1] == 1) {
            solveMaze(m, n, solutions, visited, posX, posY-1, currentPath.append("L"));
            currentPath.deleteCharAt(currentPath.length()-1);
        }
        // For Right
        if (posY+1 < n && posY+1 >= 0 && visited[posX][posY+1] == 0 && m[posX][posY+1] == 1) {
            solveMaze(m, n, solutions, visited, posX, posY+1, currentPath.append("R"));
            currentPath.deleteCharAt(currentPath.length()-1);
        }
        // For Up
        if (posX-1 < n && posX-1 >= 0 &&  visited[posX-1][posY] == 0 && m[posX-1][posY] == 1) {
            solveMaze(m, n, solutions, visited, posX-1, posY, currentPath.append("U"));
            currentPath.deleteCharAt(currentPath.length()-1);
        }
        // backtrack visited
        visited[posX][posY] = 0;
    }
}