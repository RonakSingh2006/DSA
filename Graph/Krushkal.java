package Graph;

import java.util.Arrays;

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here

        // sort edge according to weiht

        Arrays.sort(edges,(a,b)->a[2]-b[2]);

        DSU dsu = new DSU(V);

        int sum = 0;
        for(int e[] : edges){
          int x = e[0];
          int y = e[1];
          int w = e[2];

          if(dsu.findPar(x) != dsu.findPar(y)){
            dsu.union(x, y);
            sum += w;
          }
        }
        


        return sum;
    }
}