import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingTowers {
  static final int MOD = (int)(1e9 + 7);
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    int N = (int)(1e6);

    long dp[][] = new long[N][2];
    dp[0][0] = 1;
    dp[0][1] = 1;

    for(int i=1 ; i<N ; i++){
      dp[i][0] = ((2*dp[i-1][0])%MOD + dp[i-1][1])%MOD;
      dp[i][1] = ((4*dp[i-1][1])%MOD + dp[i-1][0])%MOD;
    }

    while(t-- > 0){
      int n = Integer.parseInt(br.readLine());
      System.out.println((dp[n-1][0] + dp[n-1][1])%MOD);
    }
  }
}


// if we have 2 blocks then at ith if have possiblities

// end and start new 2 block
// end and start a single block of 2 unit
// continue both
// continue 1 and end 2 and start new
// continuie 2 and end 1 and start 1 

// dp[i][1] = 4*dp[i+1][1] + dp[i+1][0]


// if we have a 1 block of 2 unit

// we can choose

// continue blocks
// end and strart new a single block
// end and stat 2 blocks

// dp[i][0] = 2*dp[i+1][0] + dp[i+1][1];
