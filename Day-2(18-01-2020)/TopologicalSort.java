class Solution {
    private ArrayList<ArrayList<Integer>> adjlist=new ArrayList<ArrayList<Integer>>();
    private boolean visited[];
    private boolean ancestors[];
    private Stack<Integer> stk=new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited=new boolean[numCourses];
        ancestors=new boolean[numCourses];
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adjlist.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(isCycle(i))
                    return new int[0];
            }
        }
        for(int i=0;i<numCourses;i++){
            result[i]=stk.pop();
        }
        return result;
    }
    public boolean isCycle(int num){
        visited[num]=true;
        ancestors[num]=true;
        for(Integer neighbour:adjlist.get(num)){
            if(!visited[neighbour]){
                if(isCycle(neighbour))
                    return true;
            }
            else if(visited[neighbour] && ancestors[neighbour]){
                return true;
            }
        }
        ancestors[num]=false;
        stk.push(num);
        return false;
    }
}
