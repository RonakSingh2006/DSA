package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Flight {

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

    String nm[] = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

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

    pq.offer(new long[] { 0, 0, 1 });

    long dist[][] = new long[n][2];
    for (long d[] : dist) {
      Arrays.fill(d, Long.MAX_VALUE);
    }
    dist[0][0] = 0;
    dist[0][1] = 0;

    while (!pq.isEmpty()) {
      long curr[] = pq.poll();
      int node = (int)curr[0];
      long weight = curr[1];
      int k = (int)curr[2];

      if(dist[node][k] < weight) continue;

      for (int[] edge : adj.get(node)) {
        int nextNode = edge[0];
        int nextWeight = edge[1];

        if (dist[nextNode][k] > weight + nextWeight) {
          dist[nextNode][k] = weight + nextWeight;

          pq.offer(new long[] { nextNode, dist[nextNode][k], k });
        }

        if (k == 1) {
          nextWeight /= 2;

          if (dist[nextNode][0] > weight + nextWeight) {
            dist[nextNode][0] = weight + nextWeight;

            pq.offer(new long[] { nextNode, dist[nextNode][0], 0 });
          }
        }
      }
    }

    System.out.println(Math.min(dist[n - 1][0], dist[n - 1][1]));
  }
}