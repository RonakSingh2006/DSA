import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DistanceQuery {
  static int level[];
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer nq = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(nq.nextToken());
    int q = Integer.parseInt(nq.nextToken());

    
    int par[] = new int[n];
    
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());


    for(int i=1 ; i<n ; i++){
      StringTokenizer uv = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(uv.nextToken())-1;
      int v = Integer.parseInt(uv.nextToken())-1;
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    level = new int[n];
    bfs(0,level,adj,par);

    
    int dp[][] = new int[n][32];

    build(par,dp,n);

    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<q ; i++){
      StringTokenizer ab = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(ab.nextToken())-1;
      int b = Integer.parseInt(ab.nextToken())-1;

      sb.append(distance(a,b,dp)).append("\n");
    }

    System.out.println(sb);

  }
  public static void bfs(int node , int level[] , List<List<Integer>> adj , int par[]){
    Queue<Integer> q = new LinkedList<>();
    q.offer(node);
    par[node] = 0;
    int l = 0;

    while(!q.isEmpty()){
      int n = q.size();

      for(int i=0 ; i<n ; i++){
        int curr = q.poll();
        level[curr] = l;
        for(int next : adj.get(curr)){
          if(next != par[curr]){
            par[next] = curr;
            q.offer(next);
          }
        }
      }

      l++;
    }

  }

  public static void build(int par[] , int dp[][] , int n){
    for(int i=0; i<32 ; i++){
      dp[0][i] = 0;
    }

    for(int j=0 ; j<32 ; j++){
      for(int i=1 ; i<n ; i++){
        if(j==0){
          dp[i][0] = par[i];
          continue;
        }

        int p = dp[i][j-1];

        dp[i][j] = dp[p][j-1];
      }
    }
  }

  public static int distance(int node1 , int node2 , int dp[][]){

    int l1 = level[node1];
    int l2 = level[node2];

    // first we get them on same level
    int diff = Math.abs(level[node1]-level[node2]);

    if(level[node1] < level[node2]){
      for(int i=31 ; i>=0 ; i--){
        if((diff & (1<<i)) != 0){
          node2 = dp[node2][i];
        }
      }
    }
    else{
      for(int i=31 ; i>=0 ; i--){
        if((diff & (1<<i)) != 0){
          node1 = dp[node1][i];
        }
      }
    }

    if(node1 == node2) return diff;

    // we try to make highest jump to above such that par of both node are not same


    for(int i=31 ; i>=0 ; i--){
      if(dp[node1][i] != dp[node2][i]){
        node1 = dp[node1][i];
        node2 = dp[node2][i];
      }
    }

    int lca = dp[node1][0];

    return l1 + l2 - 2*level[lca];
  }
}