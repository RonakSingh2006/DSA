import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PhonePayProblem {

  public static List<List<int[]>> adjList(int n, int graph[][]) {
    List<List<int[]>> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < graph.length; i++) {
      int u = graph[i][0] - 1;
      int v = graph[i][1] - 1;
      int w = graph[i][2];

      adj.get(u).add(new int[] { v, w });
    }

    return adj;
  }

  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nmk[] = br.readLine().split(" ");
    int n = Integer.parseInt(nmk[0]);
    int m = Integer.parseInt(nmk[1]);
    int k = Integer.parseInt(nmk[2]);

    String st[] = br.readLine().split(" ");
    int source = Integer.parseInt(st[0]);
    int target = Integer.parseInt(st[1]);

    int graph[][] = new int[m][3];

    for (int i = 0; i < m; i++) {
      String uvw[] = br.readLine().split(" ");
      graph[i][0] = Integer.parseInt(uvw[0]);
      graph[i][1] = Integer.parseInt(uvw[1]);
      graph[i][2] = Integer.parseInt(uvw[2]);
    }

    List<List<int[]>> adj = adjList(n, graph);

    // node weight k
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
      if (a[1] == b[1]) {
        return Long.compare(b[2] , a[2]);
      }
      return Long.compare(a[1] , b[1]);
    });

    pq.offer(new long[] { source-1, 0, k });

    long dist[][] = new long[n][k+1];
    for (long d[] : dist) {
      Arrays.fill(d, Long.MAX_VALUE);
    }
    dist[source][k] = 0;

    while (!pq.isEmpty()) {
      long curr[] = pq.poll();
      int node = (int)curr[0];
      long weight = curr[1];
      int currK = (int)curr[2];

      if(dist[node][currK] < weight) continue;

      for (int[] edge : adj.get(node)) {
        int nextNode = edge[0];
        int nextWeight = edge[1];

        if (dist[nextNode][currK] > weight + nextWeight) {
          dist[nextNode][currK] = weight + nextWeight;

          pq.offer(new long[] { nextNode, dist[nextNode][currK], currK });
        }

        if (currK > 0) {

          if (dist[nextNode][currK-1] > weight) {
            dist[nextNode][currK-1] = weight;

            pq.offer(new long[] { nextNode, dist[nextNode][currK-1], currK-1 });
          }
        }
      }
    }

    long ans = Long.MAX_VALUE;

    for(int i=0 ; i<=k ; i++){
      ans = Math.min(ans,dist[target-1][i]);
    }

    System.out.println(ans);
  }
}