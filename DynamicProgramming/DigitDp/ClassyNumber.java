package DynamicProgramming.DigitDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClassyNumber {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while(t-- > 0){
      String lr[] = br.readLine().split(" ");

      long l = Long.parseLong(lr[0]);
      long r = Long.parseLong(lr[1]);

      

      long right = helper(r+"");
      long left = helper((l-1)+"");

      System.out.println(right-left);
    }

    
  }

  public static long helper(String s){
    long dp[][][] = new long[20][2][4];

    for(long a2d[][] : dp){
      for(long d[] : a2d) Arrays.fill(d,-1);
    }

    return solve(0, s, 1, 0,dp);
  }

  public static long solve(int idx , String s , int tight , int cnt , long dp[][][]){
    if(cnt > 3) return 0;

    if(idx == s.length()) return 1;

    if(dp[idx][tight][cnt] != -1) return dp[idx][tight][cnt];


    int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;

    long ans = 0;

    for(int i=0 ; i<=limit ; i++){
      int nextTight = (tight == 0 || i!=limit) ? 0 : 1;

      int nextCnt = cnt + ((i!=0) ? 1 : 0);
      
      ans += solve(idx+1,s,nextTight,nextCnt,dp);

    }

    return dp[idx][tight][cnt] = ans;
  }
}