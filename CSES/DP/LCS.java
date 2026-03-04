import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nm[] = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    String aS[] = br.readLine().split(" ");
    String bS[] = br.readLine().split(" ");

    int a[] = new int[n];
    int b[] = new int[m];
    
    for(int i=0 ; i<n ; i++){
      a[i] = Integer.parseInt(aS[i]);
    }

    for(int j=0 ; j<m ; j++){
      b[j] = Integer.parseInt(bS[j]);
    }

    int dp[][] = new int[n+1][m+1];

    for(int i=n-1 ; i>=0 ; i--){
      for(int j=m-1 ; j>=0 ; j--){
        if(a[i] == b[j]){
          dp[i][j] = 1 + dp[i+1][j+1];
        }
        else{
          dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    int i=0 , j=0;

    while(i < n && j<m){
      if(a[i] == b[j]){
        sb.append(a[i]+" ");
        i++;
        j++;
      }
      else{
        if(dp[i][j+1] <= dp[i+1][j]){
          i++;
        }
        else{
          j++;
        }
      }
    }

    System.out.println(dp[0][0]);
    System.out.println(sb);

  }
}
