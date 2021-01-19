class Solution {
    private int m;
    private int n;
    boolean visited[][];
    private String result="";
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j,result,board,word))
                    return true;
            }
        }
        return false;
    }
    private boolean issafe(int i,int j,char[][] board){
        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        return true;
    }
    private boolean dfs(int i,int j,String result,char[][]board,String word){
        if(issafe(i,j,board)){
            visited[i][j]=true;
            result=result+board[i][j];
            System.out.println(result);
            if(result.equals(word)){
                return true;
            }
            if(board[i][j]==word.charAt(result.length()-1)){
                int []rowstep={-1,1,0,0};
                int []colstep={0,0,-1,1};
                for(int k=0;k<4;k++){
                    int row=i+rowstep[k];
                    int col=j+colstep[k];
                    if(dfs(row,col,result,board,word))
                        return true;
                }
            }
            visited[i][j]=false;
        }
        return false;
    }
}
