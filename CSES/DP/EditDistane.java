import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistane {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String t = br.readLine();

    int n = s.length() , m = t.length();

    int dp[][] = new int[n+1][m+1];

    for(int i=n ; i>=0 ; i--){
      for(int j=m ; j>=0 ; j--){

        if(i==n || j==m){
          if(i==n) dp[i][j] = m-j;
          if(j==m) dp[i][j] = n-i;

          continue;
        }

        if(s.charAt(i) == t.charAt(j)){
          dp[i][j] = dp[i+1][j+1];
        }
        else{
          int add = dp[i][j+1];
          int remove = dp[i+1][j];
          int replace = dp[i+1][j+1];

          dp[i][j] = Math.min(Math.min(add,remove),replace) + 1;
        }
      }
    }

    System.out.println(dp[0][0]);

  }
}
