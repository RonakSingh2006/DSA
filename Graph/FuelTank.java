package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FuelTank {

  public static List<List<int[]>> adjList(int n , int graph[][]){
    List<List<int[]>> adj = new ArrayList<>();
    for(int i=0 ; i<n ; i++){
      adj.add(new ArrayList<>());
    }

    for(int g[] : graph){
      adj.get(g[0]).add(new int[]{g[1],g[2]});
      adj.get(g[1]).add(new int[]{g[0],g[2]});
    }

    return adj;
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nm[] = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    String priceOfFuel[] = br.readLine().split(" ");
    int fuel[] = new int[n];
    for(int i=0 ; i<n ; i++){
      fuel[i] = Integer.parseInt(priceOfFuel[i]);
    }

    int graph[][] = new int[m][3];

    for(int i=0 ; i<m ; i++){
      String uvw[] = br.readLine().split(" ");
      graph[i][0] = Integer.parseInt(uvw[0]);
      graph[i][1] = Integer.parseInt(uvw[1]);
      graph[i][2] = Integer.parseInt(uvw[2]);
    }

    int q = Integer.parseInt(br.readLine());

    List<List<int[]>> adj = adjList(n, graph);

    while(q-- > 0){
      String cst[] = br.readLine().split(" ");
      int maxCapacity = Integer.parseInt(cst[0]);
      int source = Integer.parseInt(cst[1]);
      int target = Integer.parseInt(cst[2]);


      int dist[][] = new int[n][maxCapacity+1];
      for(int d[] : dist){
        Arrays.fill(d,Integer.MAX_VALUE);
      }


      // node cpacity cost
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
        if(a[2] == b[2]) return b[1] - a[1];
        
        return a[2] - b[2];
      });

      pq.offer(new int[]{source,0,0});
      dist[source][0] = 0;


      while(!pq.isEmpty()){
        int curr[] = pq.poll();

        int currNode = curr[0];
        int currFuel = curr[1];
        int currCost = curr[2];

        if(currCost != dist[currNode][currFuel]) continue;

        for(int next[] : adj.get(currNode)){
          int nextNode = next[0];
          int fuelCost = next[1];

          if(fuelCost > maxCapacity){
            continue;
          }

          for(int c=Math.max(currFuel,fuelCost) ; c<=maxCapacity ; c++){
            int nextCost = currCost + (c-currFuel)*fuel[currNode];
            int nextCapacity = c - fuelCost;

            if(dist[nextNode][nextCapacity] > nextCost){
              dist[nextNode][nextCapacity] = nextCost;
              pq.offer(new int[]{nextNode,nextCapacity,nextCost});
            }
          }
        }
      }


      int ans = Integer.MAX_VALUE;

      for(int i=0 ; i<=maxCapacity ; i++){
        ans = Math.min(ans,dist[target][i]);
      }

      if(ans == Integer.MAX_VALUE) System.out.println("impossible");
      else System.out.println(ans);

    }
  }
}
