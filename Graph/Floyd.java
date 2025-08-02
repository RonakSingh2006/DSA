package Graph;

class Floyd {
  public void floydWarshall(int[][] dist) {
    // Code here
    int MAX = (int) (1e8);
    int V = dist.length;

    for (int i = 0; i < V; i++) {

      for (int j = 0; j < V; j++) {
        for (int k = 0; k < V; k++) {
          if (j == k || j == i || k == i)
            continue;

          if (dist[j][i] == MAX || dist[i][k] == MAX)
            continue;
          dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
        }
      }

    }
  }
}
