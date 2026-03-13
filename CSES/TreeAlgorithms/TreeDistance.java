import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDistance {

  static List<List<Integer>> adj;
  static int depth[];
  static int ans[];
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

    depth = new int[n];
    ans = new int[n];

    fillDepth(0, -1);
    for(int i=0 ; i<n ; i++){
      depth[i]--;
    }

    solve(0,-1,0);

    StringBuilder sb = new StringBuilder();
    for(int x : ans){
      sb.append(x+" ");
    }

    System.out.println(sb);
    
  }
  public static int fillDepth(int node , int par){
    int ans = 0;

    for(int next : adj.get(node)){
      if(next == par) continue;

      int d = fillDepth(next, node);

      ans = Math.max(ans,d);
    }

    return depth[node] = 1 + ans;
  }

  public static void solve(int node , int par , int parDis){
    ans[node] = Math.max(depth[node],parDis);

    // Now we have to find par Dis fro child nodes

    int max1 = -1 , max2 = -1;

    for(int next : adj.get(node)){
      if(next == par) continue;

      int d = depth[next];

      if(d >= max1){
        max2 = max1;
        max1 = d;
      }
      else if(d > max2){
        max2 = d;
      }
    }


    for(int next : adj.get(node)){
      if(next == par) continue;

      int use = max1;

      if(depth[next] == use){
        use = max2;
      }

      solve(next,node,Math.max(2+use,1+parDis));
    }
  }
}
