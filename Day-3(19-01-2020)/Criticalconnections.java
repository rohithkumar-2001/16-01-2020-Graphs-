class Solution {
    private List<List<Integer>> result=new ArrayList<>();;
    private int[] discover;
    private int[] low;
    ArrayList<ArrayList<Integer>> adjlist=new ArrayList<ArrayList<Integer>>();
    boolean[] visited;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        for(int i=0;i<connections.size();i++){
            adjlist.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adjlist.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        discover=new int[n];
        visited=new boolean[n];
        low=new int[n];
        dfs(0,0,-1);
        return result;
    }
    public void dfs(int src,int time,int parent){
        visited[src]=true;
        time++;
        discover[src]=time;
        low[src]=time;
        for(Integer neighbour:adjlist.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour,time,src);
                low[src]=Math.min(low[neighbour],low[src]);
            }
            else if(visited[neighbour] && neighbour!=parent){
                low[src]=Math.min(low[src],discover[neighbour]);
            }
            if(low[neighbour]>discover[src])
            {
                ArrayList<Integer> l=new ArrayList<>();
                l.add(neighbour);
                l.add(src);
                result.add(l);
            }
        }
    }
}