class Solution {
    public void bfs(char[][] grid, int i, int j) {
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{i,j});
        while(!s.isEmpty()){
        int[] pair = s.pop();
        if(pair[1]+1< grid[0].length&&grid[pair[0]][pair[1]+1]=='1'){
            s.push(new int[]{pair[0],pair[1]+1});
            grid[pair[0]][pair[1]+1]= '0';
        }
        if(pair[1]-1>=0 &&grid[pair[0]][pair[1]-1]=='1'){
            s.push(new int[]{pair[0],pair[1]-1});
            grid[pair[0]][pair[1]-1]= '0';
        }
        if(pair[0]+1<grid.length&& grid[pair[0]+1][pair[1]]=='1'){
            s.push(new int[]{pair[0]+1,pair[1]});
            grid[pair[0]+1][pair[1]]= '0';
        }
        if(pair[0]-1>=0&& grid[pair[0]-1][pair[1]]=='1'){
            s.push(new int[]{pair[0]-1,pair[1]});
            grid[pair[0]-1][pair[1]]= '0';
        }
    }
    }

    // public void dfs(char[][] grid, int i, int j) {

    // }


    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
}
