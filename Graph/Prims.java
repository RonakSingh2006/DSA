package Graph;

import java.util.List;
import java.util.PriorityQueue;

class Prims {
  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    // Code Here.
    boolean visited[] = new boolean[V];

    // node , edgWeight
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[] { 0, 0 });

    int sum = 0;

    while (!pq.isEmpty()) {
      int a[] = pq.poll();

      int node = a[0];
      int w = a[1];

      if (visited[node])
        continue;

      visited[node] = true;
      sum += w;

      for (int arr[] : adj.get(node)) {
        if (!visited[arr[0]])
          pq.offer(arr);
      }
    }

    return sum;
  }
}