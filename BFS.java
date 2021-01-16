// Initial Template for Java
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
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.bfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean []visited =new boolean[V];
        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        visisted[0]=true;
        queue.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){     //This for loop is for handling all nodes at same distance from start.  
                int curr=queue.poll();
                result.add(curr);
                for(Integer neighbour:adj.get(curr)){
                    if(!visited[neighbour]){
                        visited[neighbour]=true;
                        queue.add(neighbour);
                        result.add(neighbour);
                    }
                }
            }
        }
        return result;
    }
}
