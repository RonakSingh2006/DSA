import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDistance2 {
  static class Pair{
    int cnt;
    long sum;

    Pair(int c , long s){
      this.cnt = c;
      this.sum  = s;
    }
  }

  static List<List<Integer>> adj;
  static Pair data[];
  static long ans[];

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

    data = new Pair[n];
    dfs(0, -1);

    ans = new long[n];

    solve(0,-1,0,0);


    StringBuilder sb = new StringBuilder();
    for(long x : ans) sb.append(x+" ");

    System.out.println(sb);
  }

  public static void dfs(int node , int par){
    int cnt = 0;
    long sum = 0;

    for(int next : adj.get(node)){
      if(next == par) continue;

      dfs(next,node);

      sum += (data[next].sum + data[next].cnt);
      cnt += data[next].cnt;
    }

    data[node] = new Pair(cnt+1,sum);
  }
  public static void solve(int node , int par , int cnt , long sum){

    long val = cnt + sum;

    ans[node] = data[node].sum + val;


    long s = 0;
    int c = 0;

    for(int next : adj.get(node)){
      if(next == par) continue;

      s += data[next].sum + data[next].cnt;
      c += data[next].cnt;
    }

    for(int next : adj.get(node)){
      if(next == par) continue;

      int newCnt = c - data[next].cnt + cnt + 1;
      long newSum = s - (data[next].sum + data[next].cnt) + val;

      solve(next,node,newCnt,newSum);
    }
  }
}
