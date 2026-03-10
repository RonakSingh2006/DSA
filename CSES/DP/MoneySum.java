import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MoneySum {
  static HashSet<Integer> set = new HashSet<>();
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String aS[] = br.readLine().split(" ");

    int arr[] = new int[n];

    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS[i]);
    }

    boolean dp[][] = new boolean[n][100001];

    helper(0, 0, arr,dp);

    System.out.println(set.size());
    List<Integer> list = new ArrayList<Integer>(set);
    Collections.sort(list);
    StringBuilder sb = new StringBuilder();
    for(int x : list){
      sb.append(x+" ");
    }

    System.out.println(sb);
    
  }

  public static void helper(int idx , int sum , int nums[] , boolean dp[][]){
    if(idx == nums.length){
      if(sum != 0)set.add(sum);
      return;
    }

    if(dp[idx][sum]) return;

    dp[idx][sum] = true;

    // Take
    helper(idx+1,sum+nums[idx],nums,dp);

    // noTake
    helper(idx+1,sum,nums,dp);
  }
}
