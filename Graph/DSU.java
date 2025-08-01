package Graph;

public class DSU {
  int par[], rank[];

  DSU(int n) {
    par = new int[n];

    for (int i = 0; i < n; i++) {

      par[i] = i;
    }

    rank = new int[n];
  }

  public void union(int x, int y) {
    int parX = findPar(x);
    int parY = findPar(y);

    if (parX == parY)
      return;

    if (rank[parX] >= rank[parY]) {
      par[parY] = parX;
      rank[parX]++;
    } else {
      par[parX] = parY;
      rank[parY]++;
    }

  }

  public int findPar(int x) {
    if (par[x] == x)
      return x;

    return par[x] = findPar(par[x]);
  }
}