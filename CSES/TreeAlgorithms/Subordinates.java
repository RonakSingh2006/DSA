import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Subordinates{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String aS[] = br.readLine().split(" ");
    
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0 ; i<n ; i++){
      adj.add(new ArrayList<>());
    }

    for(int i=0 ; i<aS.length ; i++){
      int x = Integer.parseInt(aS[i]);

      adj.get(x-1).add(i+1);
    }

    int dp[] = new int[n];
    
    solve(0,adj,dp);

    StringBuilder sb = new StringBuilder();
    for(int x : dp){
      sb.append((x-1)+" ");
    }

    System.out.println(sb);

  }

  public static int solve(int node , List<List<Integer>> adj , int dp[]){

    int sum = 1;
    for(int x : adj.get(node)){
      sum += solve(x,adj,dp);
    }

    return dp[node] = sum;
  }


}