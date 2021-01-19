import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    private static boolean visited[];
    private static int discover[];
    private static int low[];
    private static int source;
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        visited=new boolean[V];
        discover=new int[V];
        low=new int[V];
        source=c;
        if(dfs(c,d,0,-1,adj,c))
            return 1;
        return 0;
    }
    public static boolean dfs(int src,int d,int time,int parent,ArrayList<ArrayList<Integer>> adj,int c){
        visited[src]=true;
        time++;
        low[src]=time;
        discover[src]=time;
        for(Integer neighbour:adj.get(src)){
            if(!visited[neighbour]){
                if(dfs(neighbour,d,time,src,adj,c))
                    return true;
                low[src]=Math.min(low[src],low[neighbour]);
            }
            else if(visited[neighbour] && neighbour!=parent){
                low[src]=Math.min(low[src],discover[neighbour]);
            }
            if(low[neighbour]>discover[src]){
                if((neighbour==c && src==d) || (neighbour==d && src==c)){
                    return true;
                }
            }
        }
        return false;
    }
}
