import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DistanceTree{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer nk = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(nk.nextToken());
    int k = Integer.parseInt(nk.nextToken());

    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());

    for(int i=0 ; i<n-1 ; i++){
      StringTokenizer uv = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(uv.nextToken()) - 1;
      int v = Integer.parseInt(uv.nextToken()) - 1;

      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    long dp[][] = new long[n][k+1];
    dfs(0,-1,k,dp,adj);

    long ans[][] = new long[n][k+1];

    for(int i=0 ; i<n ; i++){
      for(int j=0 ; j<=k ; j++){
        ans[i][j] = dp[i][j];
      }
    }

    solve(0,-1,k,dp,ans,adj);

    long cnt = 0;
    for(int i=0 ; i<n ; i++){
      cnt += ans[i][k];
    }

    System.out.println(cnt/2);
    
  }

  public static void dfs(int node , int par , int k , long dp[][] , List<List<Integer>> adj){
    dp[node][0] = 1;

    for(int next : adj.get(node)){
      if(next == par) continue;

      dfs(next,node,k,dp,adj);

      for(int i=1;i<=k;i++){
          dp[node][i] += dp[next][i-1];
      }
    }
  }

  public static void solve(int node , int par , int k , long dp[][] , long ans[][] , List<List<Integer>> adj){
    if(par != -1){

      for(int i=1 ; i<=k ; i++){
        ans[node][i] += ans[par][i-1];

        if(i > 1) ans[node][i] -= dp[node][i-2];
      }
    }


    for(int next : adj.get(node)){
      if(next != par){
        solve(next,node,k,dp,ans,adj);
      }
    }
  }
}