import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountTiling {

  static final int MOD = (int)(1e9 + 7);
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String nm[] = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    int N = (1<<n)-1;

    long dp[][] = new long[m+1][N+1];
    for(long d[] : dp) Arrays.fill(d,-1);
    

    long ans = helper(n, m, 0,dp);

    System.out.println(ans);
  }

  public static long helper(int n , int m , int currMask , long dp[][]){
    if(m==0){
      return currMask == 0 ? 1 : 0;
    }

    if(dp[m][currMask] != -1) return dp[m][currMask];

    // Generate all possible next Mask using currMask we can have

    List<Integer> next = new ArrayList<>();
    generate(0,n,currMask,next,0);

    long ans = 0;

    for(int nextMask : next){
      ans = (ans + helper(n,m-1,nextMask,dp))%MOD;
    } 

    return dp[m][currMask] = ans;
  }

  public static void generate(int idx , int n , int currMask , List<Integer> list , int nextMask){
    if(idx == n){
      list.add(nextMask);
      return;
    }

    if((currMask & (1<<idx)) != 0){
      generate(idx+1, n, currMask, list, nextMask);
      return;
    }

    // 1*2

    int newNextMask = nextMask | (1<<idx);
    generate(idx+1, n, currMask, list, newNextMask);

    // 2*1

    if(idx+1 < n && (currMask & (1<<(idx+1))) == 0){
      generate(idx+2, n, currMask, list, nextMask);
    }
  }
}
