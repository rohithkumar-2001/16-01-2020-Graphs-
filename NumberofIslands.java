class Solution {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        int count=0;
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isSafe(int i,int j,char[][] grid){
        if(i<0 || j<0 || i>m-1 || j>n-1)
                return false;
        if(grid[i][j]!='1')
            return false;
        return true;
    }
    public void dfs(char[][] grid,int i,int j){
        if(isSafe(i,j,grid)){
            int rowstep[]={0,0,-1,1};
            int colstep[]={-1,1,0,0};
            for(int k=0;k<4;k++){
                grid[i][j]='2';
                int row=i+rowstep[k];
                int col=j+colstep[k];
                dfs(grid,row,col);
            }
        }
    }
    
}
