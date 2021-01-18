class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue=new LinkedList<>();
        int[] color=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(color[i]==0){
                color[i]=1;
                queue.add(i);
                while(queue.size()!=0){
                    int size=queue.size();
                    for(int j=0;j<size;j++){
                        int num=queue.poll();
                        for(Integer neighbour:graph[num]){
                            if(color[neighbour]==0){
                                queue.add(neighbour);
                                if(color[num]==1){
                                    color[neighbour]=2;
                                }
                                else
                                    color[neighbour]=1;
                            }
                            else if(color[neighbour]==color[num]){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
