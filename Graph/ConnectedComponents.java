package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {
    public static ArrayList<ArrayList<Integer>> adjList(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0 ; i<v ; i++){
            ans.add(new ArrayList<>());
        }
        
        for(int a[] : edges){
            ans.get(a[0]).add(a[1]);
            ans.get(a[1]).add(a[0]);
        }
        
        return ans;
    }
    // we can do any one bfs or dfs
    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj , int node , boolean visited[]){
        ArrayList<Integer> list = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        list.add(node);
        visited[node] = true;
        
        while(!q.isEmpty()){
            int val = q.poll();
            
            for(int x : adj.get(val)){
                if(!visited[x]){
                    visited[x] = true;
                    q.offer(x);
                    list.add(x);
                }
            }
            
        }
        
        return list;
        
    }
    
    public static ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = adjList(v,edges);
        
        boolean visited[] = new boolean[v];
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i=0 ; i<v ; i++){
            if(!visited[i]){
                ans.add(bfs(adj,i,visited));
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        int [][]edges = {{0, 1},{2, 1},{3, 4}};
        int v = 5;
        System.out.println(connectedcomponents(v, edges));
    }
}