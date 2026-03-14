import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompanyQuery1 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer nk = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(nk.nextToken());
    int k = Integer.parseInt(nk.nextToken());

    int par[] = new int[n];
    par[0] = -1;

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i=1 ; i<n ; i++){
      int p = Integer.parseInt(st.nextToken())-1;
      par[i] = p;
    }

    int dp[][] = new int[n][32];

    build(dp,par,n);

    StringBuilder sb = new StringBuilder();


    for(int i=0 ; i<k ; i++){
      StringTokenizer q = new StringTokenizer(br.readLine());
      int node = Integer.parseInt(q.nextToken())-1;
      int step = Integer.parseInt(q.nextToken());

      int ans = node;

      for(int j=31 ; j>=0 ; j--){
        if((step & (1<<j)) != 0){
          if(ans != -1) ans = dp[ans][j];
        }
      }

      if(ans != -1) ans++;

      sb.append(ans).append("\n");
    }

    System.out.println(sb);

  }

  public static void build(int dp[][] , int par[] , int n){
    // fill root
    for(int i=0 ; i<32 ; i++){
      dp[0][i] = -1;
    }

    for(int i=1 ; i<n ; i++){
      dp[i][0] = par[i];
      for(int j=1 ; j<32 ; j++){
        int m = dp[i][j-1];
        if(m != -1) dp[i][j] = dp[m][j-1];
        else dp[i][j] = -1;
      }
    }
  }
}
