import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution
{   
    private int m;
    private int n;
    private boolean flag=false;
    public boolean is_Possible(int[][] grid)
    {
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return dfs(i,j,grid);
                }
            }
        }
        return false;
    }
    public boolean issafe(int i,int j,int[][] grid){
        if(i<0 || j<0 || i>m-1 || j>n-1){
            return false;
        }
        if(grid[i][j]==0){
            return false;
        }
        return true;
    }
    public boolean dfs(int i,int j,int[][] grid){
        if(issafe(i,j,grid)){
            int rowstep[]={0,0,-1,1};
            int colstep[]={-1,1,0,0};
            if(grid[i][j]==2){
                flag=true;
            }
            for(int k=0;k<4;k++){
                grid[i][j]=0;
                int row=i+rowstep[k];
                int col=j+colstep[k];
                dfs(row,col,grid);
            }
            if(flag)
                return true;
        }
        return false;
    }
}
