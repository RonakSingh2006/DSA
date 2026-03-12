import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeMatching {

  static List<List<Integer>> adj;
  static int dp[][];
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    adj = new ArrayList<>();
    
    for(int i=0 ; i<n ; i++){
      adj.add(new ArrayList<>());
    }

    for(int i=0 ; i<n-1 ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      int u = Integer.parseInt(st.nextToken())-1;
      int v = Integer.parseInt(st.nextToken())-1;

      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    dp = new int[n][2];

    dfs(0,-1);

    System.out.println(Math.max(dp[0][0],dp[0][1]));

  }

  public static void dfs(int node , int par){
    int sum = 0;

    for(int next : adj.get(node)){
      if(next == par) continue;

      dfs(next,node);
      int nt = Math.max(dp[next][0],dp[next][1]);

      sum += nt;
    }

    dp[node][0] = sum;

    for(int next : adj.get(node)){
      if(next == par) continue;

      int nextVal = Math.max(dp[next][0], dp[next][1]);

      int take = 1 + dp[next][0] + (sum - nextVal);

      dp[node][1] = Math.max(dp[node][1], take);
    }
  }
}
