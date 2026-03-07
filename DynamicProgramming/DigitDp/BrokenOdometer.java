package DynamicProgramming.DigitDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BrokenOdometer {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while(t-- > 0){
      int n = Integer.parseInt(br.readLine());

      // Number containing 3
      int x = helper(n+"");

      System.out.println(n-x);
    }

    
  }

  public static int helper(String s){
    int dp[][][] = new int[10][2][2];

    for(int a2d[][] : dp){
      for(int d[] : a2d) Arrays.fill(d,-1);
    }

    return solve(0, s, 1, 0,dp);
  }

  public static int solve(int idx , String s , int tight , int flag , int dp[][][]){

    if(idx == s.length()) return flag;

    if(dp[idx][tight][flag] != -1) return dp[idx][tight][flag];


    int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;

    int ans = 0;

    for(int i=0 ; i<=limit ; i++){
      int nextTight = (tight == 0 || i!=limit) ? 0 : 1;

      int nextFlag = (flag == 1 || i==3) ? 1 : 0;
      
      ans += solve(idx+1,s,nextTight,nextFlag,dp);

    }

    return dp[idx][tight][flag] = ans;
  }
}