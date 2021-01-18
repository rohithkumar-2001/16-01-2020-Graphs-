class Solution {
    private int m;
    private int n;
    public boolean issafe(int r,int c,int[][] grid){
        if(r<0 || c<0 || r>m-1 || c>n-1)
            return false;
        if(grid[r][c]!=1)
            return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int rowstep[]={0,0,-1,1};
        int colstep[]={-1,1,0,0};
        m=grid.length;
        n=grid[0].length;
        Queue<int []> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    int temp[]={i,j};
                    queue.add(temp);
                }
            }
        }
        int time=-1;
        while(queue.size()!=0){
            time++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                int pair[]=queue.poll();
                for(int j=0;j<4;j++){
                    int row=pair[0]+rowstep[j];
                    int col=pair[1]+colstep[j];
                    if(issafe(row,col,grid)){
                        grid[row][col]=2;
                        int newpair[]={row,col};
                        queue.add(newpair);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        if(time==-1)
            return 0;
        return time;
    }
}