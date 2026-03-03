import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class RemoveDigit {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    int MAX = (int)(1e9);

    int dp[] = new int[n+1];
    Arrays.fill(dp,MAX);

    dp[0] = 0;

    for(int i=1 ; i<=n ; i++){
      int temp = i;

      while(temp > 0){
        int d = temp%10;
        temp/=10;

        dp[i] = Math.min(dp[i],1+dp[i-d]);
      }

    }

    System.out.println(dp[n]);
  }
}
