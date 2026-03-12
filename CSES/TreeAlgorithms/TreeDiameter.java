import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class TreeDiameter {

  static List<List<Integer>> adj;
  static int diameter;
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

    diameter = 0;

    dfs(0,-1);

    System.out.println(Math.max(0,diameter-1));
 
  }

  public static int dfs(int node , int par){
    int max1 = 0;
    int max2 = 0;

    for(int next : adj.get(node)){
      if(next != par){
        int val = dfs(next,node);

        if(val >= max1){
          max2 = max1;
          max1 = val;
        }
        else if(val > max2){
          max2 = val;
        }
      }
    }

    diameter = Math.max(diameter,1+max1+max2);

    return 1 + Math.max(max1,max2);
  }
}