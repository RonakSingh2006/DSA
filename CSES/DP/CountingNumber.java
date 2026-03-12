import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CountingNumber{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String ab[] = br.readLine().split(" ");
    long a = Long.parseLong(ab[0]);
    long b = Long.parseLong(ab[1]);

    System.out.println(solve(b) - solve(a-1));
  }

  public static long solve(long a){
    long dp[][][][] = new long[20][2][11][2];
    for(long d3d[][][] : dp){
      for(long d2d[][] : d3d){
        for(long d[] : d2d) Arrays.fill(d,-1);
      }
    }

    return helper(a+"",0,1,10,dp,0);
  }

  public static long helper(String s , int idx , int tight , int prev , long dp[][][][] , int started){
    if(idx == s.length()){
      return 1;
    }

    if(dp[idx][tight][prev][started] != -1) return dp[idx][tight][prev][started];

    int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;

    long ans = 0;

    for(int i=0 ; i<=limit ; i++){
      if(i!=prev || started == 0){

        int nextTight = (tight == 0 || i!=limit) ? 0 : 1;
        int nextStarted = (i!=0 || started == 1) ? 1 : 0;
  
        long val = helper(s, idx+1, nextTight, i,dp ,nextStarted);

        ans = ans + val;
      }
    }

    return dp[idx][tight][prev][started] = ans;
  }
}