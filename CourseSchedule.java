class Solution {
    private ArrayList<ArrayList<Integer>> adjlist=new ArrayList<ArrayList<Integer>>();
    private boolean[] visited;
    private boolean[] ancestors;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        visited=new boolean[numCourses];
        ancestors=new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            //Loop to make our adjacency list
            adjlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(isCycle(i))
                    return false;
            }
        }
        return true;
    }
    public boolean isCycle(int num){
        visited[num]=true;
        ancestors[num]=true;
        for(Integer neighbour:adjlist.get(num)){
            if(!visited[neighbour]){
                if(isCycle(neighbour))
                    return true;
            }
            else if(visited[neighbour] && ancestors[neighbour]==true){
                return true;
            }
        }
        ancestors[num]=false;
        return false;
    }
}
