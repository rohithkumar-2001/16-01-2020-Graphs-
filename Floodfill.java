class Solution {
    private int m;
    private int n;
    private int strtpxl;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m=image.length;
        n=image[0].length;
        strtpxl=image[sr][sc];
        replaceColor(sr,sc,image,newColor);
        return image;
    }
    private boolean issafe(int i,int j,int[][] image,int newColor){
        if(i<0 || j<0 || i>m-1 || j>n-1)
            return false;
        if(image[i][j]!=strtpxl || image[i][j]==newColor)
            return false;
        return true;
    }
    public void replaceColor(int sr,int sc,int[][] image,int newColor){
        int[] rowstep={0,0,-1,1};
        int[] colstep={-1,1,0,0};
        if(issafe(sr,sc,image,newColor)){
            image[sr][sc]=newColor;
            for(int i=0;i<4;i++){
                int row=sr+rowstep[i];
                int col=sc+colstep[i];
                replaceColor(row,col,image,newColor);
            }
        }
    }
}
