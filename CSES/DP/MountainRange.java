import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MountainRange {
  static class Pair{
    int val,idx;

    Pair(int v , int i){
      this.val = v;
      this.idx = i;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String aS[] = br.readLine().split(" ");

    int arr[] = new int[n];

    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS[i]);
    }

    int nge[] = NGE(arr);
    int pge[] = PGE(arr);

    int dp[] = new int[n];
    Arrays.fill(dp,1);

    Pair par[] = new Pair[n];

    for(int i=0 ; i<n ; i++){
      par[i] = new Pair(arr[i],i);
    }

    Arrays.sort(par,(a,b)->a.val-b.val);

    int ans = 1;

    for(Pair p : par){
      int ng = nge[p.idx];
      if(ng != -1){
        dp[ng] = Math.max(dp[ng],1+dp[p.idx]);
        ans = Math.max(ans,dp[ng]);
      }

      int pg = pge[p.idx];

      if(pg != -1){
        dp[pg] = Math.max(dp[pg],1+dp[p.idx]);
        ans = Math.max(ans,dp[pg]);
      }

      
    }
    
    System.out.println(ans);

    
  }

  public static int[] NGE(int arr[]){
    int n = arr.length;
    Stack<Integer> stack = new Stack<>();
    stack.push(n-1);

    int next[] = new int[n];
    next[n-1] = -1;

    for(int i=n-2 ; i>=0 ; i--){

      while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
        stack.pop();
      }

      if(stack.isEmpty()){
        next[i] = -1;
      }
      else{
        next[i] = stack.peek();
      }

      stack.push(i);
    }

    return next;
  }

  public static int[] PGE(int arr[]){
    int n = arr.length;
    Stack<Integer> stack = new Stack<>();
    stack.push(0);

    int next[] = new int[n];
    next[0] = -1;

    for(int i=1 ; i<n ; i++){

      while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
        stack.pop();
      }

      if(stack.isEmpty()){
        next[i] = -1;
      }
      else{
        next[i] = stack.peek();
      }

      stack.push(i);
    }

    return next;
  }
}
