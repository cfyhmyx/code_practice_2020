// https://leetcode.com/problems/number-of-islands/

public class Cp200 {

    public static void main(String args[]) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int result = numIslands(grid);
        System.out.println(result);
    }

    // Main idea: DFS.
    // Time: O(m*n), need to visit every node once.
    // Space: O(m*n).
    public static int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        if(m == 0) return result;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    getIsland(i, j, m, n, grid, visited);
                    result++;
                }
            }
        }
        return result;
    }

    public static void getIsland(int row, int col, int m, int n, char[][] grid, boolean[][] visited) {
        if(row<0 || col<0 || row>=m || col>= n || visited[row][col] || grid[row][col] != '1') return;
        visited[row][col] = true;
        getIsland(row-1, col, m, n, grid, visited);
        getIsland(row+1, col, m, n, grid, visited);
        getIsland(row, col-1, m, n, grid, visited);
        getIsland(row, col+1, m, n, grid, visited);
    }
}
