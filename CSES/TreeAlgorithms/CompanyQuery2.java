import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CompanyQuery2 {
  static int level[];
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer nq = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(nq.nextToken());
    int q = Integer.parseInt(nq.nextToken());

    
    int par[] = new int[n];
    StringTokenizer relation = new StringTokenizer(br.readLine());
    
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0 ; i<n ; i++) adj.add(new ArrayList<>());

    for(int i=1 ; i<n ; i++){
      int p = Integer.parseInt(relation.nextToken())-1;
      par[i] = p;
      adj.get(p).add(i);
    }

    level = new int[n];
    dfs(0,-1,level,0,adj);

    
    int dp[][] = new int[n][32];

    build(par,dp,n);

    StringBuilder sb = new StringBuilder();
    for(int i=0 ; i<q ; i++){
      StringTokenizer ab = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(ab.nextToken())-1;
      int b = Integer.parseInt(ab.nextToken())-1;

      sb.append(LCA(a,b,dp)).append("\n");
    }

    System.out.println(sb);

  }
  public static void dfs(int node , int par , int level[] , int lvl , List<List<Integer>> adj){
    level[node] = lvl;

    for(int next : adj.get(node)){
      if(next == par) continue;

      dfs(next,node,level,lvl+1,adj);
    }
  }

  public static void build(int par[] , int dp[][] , int n){
    for(int i=0; i<32 ; i++){
      dp[0][i] = 0;
    }

    for(int i=1 ; i<n ; i++){
      dp[i][0] = par[i];

      for(int j=1 ; j<32 ; j++){
        int p = dp[i][j-1];

        dp[i][j] = dp[p][j-1];
      }
    }
  }

  public static int LCA(int node1 , int node2 , int dp[][]){

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

    if(node1 == node2) return node1 + 1;

    // we try to make highest jump to above such that par of both node are not same

    for(int i=31 ; i>=0 ; i--){
      if(dp[node1][i] != dp[node2][i]){
        node1 = dp[node1][i];
        node2 = dp[node2][i];
      }
    }

    return dp[node1][0]+1;
  }
}
