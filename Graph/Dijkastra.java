package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {
    public List<List<int[]>> adjList(int V, int[][] edges){
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0 ; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int a[] : edges){
            adj.get(a[0]).add(new int[]{a[1],a[2]});
            adj.get(a[1]).add(new int[]{a[0],a[2]});
        }
        
        return adj;
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> adj = adjList(V,edges);
        int distance[] = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        // node,distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        distance[src] = 0;
        pq.offer(new int[]{src,0});
        
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int dis = curr[1];
            
            for(int arr[] : adj.get(node)){
                int edgWeight = arr[1];
                int adjNode = arr[0];
                
                if(distance[adjNode] > dis + edgWeight){

                    distance[adjNode] = dis + edgWeight;
                    
                    pq.offer(new int[]{adjNode,dis + edgWeight});
                }
            }
        }
        
        return distance;
    
        
    }
}