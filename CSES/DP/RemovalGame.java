import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RemovalGame {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String aS[] = br.readLine().split(" ");

    int arr[] = new int[n];

    long sum  = 0;

    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS[i]);
      sum += arr[i];
    }

    long dp[][] = new long[n][n];
    for(long d[] : dp) Arrays.fill(d,-1);

    long d = helper(0,n-1,dp,arr);

    long ans = (d + sum)/2;

    System.out.println(ans);

  }

  public static long helper(int i , int j , long dp[][] , int arr[]){
    if(i > j) return 0;
    // choose first

    if(dp[i][j] != -1) return dp[i][j];

    long f = arr[i] - helper(i+1,j,dp,arr);
    long l = arr[j] - helper(i,j-1,dp,arr);

    return dp[i][j] = Math.max(f,l);
  }
}

// x + y = sum of array
// x - y = diff i got

// 2x = sum of array + diff