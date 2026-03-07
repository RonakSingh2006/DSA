package DynamicProgramming.DigitDp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lucifer {

  static boolean isPrime[] = new boolean[100];
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    seive();

    while(t-- > 0){
      String lr[] = br.readLine().split(" ");

      int l = Integer.parseInt(lr[0]);
      int r = Integer.parseInt(lr[1]);
      

      int right = helper(r+"");
      int left = helper((l-1)+"");

      System.out.println(right-left);
    }
    
  }

  private static void seive(){
    Arrays.fill(isPrime,true);

    isPrime[0] = isPrime[1] = false;

    for(int i=2 ; i<100 ; i++){
      if(isPrime[i]){
        int j=2;

        while(i*j < 100){
          isPrime[i*j] = false;
          j++;
        }
      }
    }
  }

  public static int helper(String s){
    // max digits 10 so max sum = 10*9

    int dp[][][] = new int[10][2][100];

    for(int a2d[][] : dp){
      for(int d[] : a2d) Arrays.fill(d,-1);
    }

    return solve(0, s, 1, 0,dp);
  }

  public static int solve(int idx , String s , int tight , int sum , int dp[][][]){
    int n = s.length();

    if(idx == n) return (sum < 0 || !isPrime[sum]) ? 0 : 1;

    if(dp[idx][tight][sum+50] != -1) return dp[idx][tight][sum+50];


    int limit = (tight == 1) ? s.charAt(idx) - '0' : 9;

    int ans = 0;

    for(int i=0 ; i<=limit ; i++){
      int nextTight = (tight == 0 || i!=limit) ? 0 : 1;

      int nextSum = sum;

      if((n - idx)%2 == 0) nextSum += i;
      else nextSum -= i;
      
      ans += solve(idx+1,s,nextTight,nextSum,dp);

    }

    return dp[idx][tight][sum+50] = ans;
  }
}