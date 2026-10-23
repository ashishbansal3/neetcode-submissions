class Solution {
    public void bfs(char[][] grid, int i, int j) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[] {i, j});
        while (!s.isEmpty()) {
            int[] pair = s.pop();
            if (pair[1] + 1 < grid[0].length && grid[pair[0]][pair[1] + 1] == '1') {
                s.push(new int[] {pair[0], pair[1] + 1});
                grid[pair[0]][pair[1] + 1] = '0';
            }
            if (pair[1] - 1 >= 0 && grid[pair[0]][pair[1] - 1] == '1') {
                s.push(new int[] {pair[0], pair[1] - 1});
                grid[pair[0]][pair[1] - 1] = '0';
            }
            if (pair[0] + 1 < grid.length && grid[pair[0] + 1][pair[1]] == '1') {
                s.push(new int[] {pair[0] + 1, pair[1]});
                grid[pair[0] + 1][pair[1]] = '0';
            }
            if (pair[0] - 1 >= 0 && grid[pair[0] - 1][pair[1]] == '1') {
                s.push(new int[] {pair[0] - 1, pair[1]});
                grid[pair[0] - 1][pair[1]] = '0';
            }
        }
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = '0';
            dfs(grid, i - 1, j);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            grid[i + 1][j] = '0';
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = '0';
            dfs(grid, i, j - 1);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            grid[i][j + 1] = '0';
            dfs(grid, i, j + 1);
        }
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
}
