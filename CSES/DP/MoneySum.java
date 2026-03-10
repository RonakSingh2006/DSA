import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoneySum {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String aS[] = br.readLine().split(" ");

    int arr[] = new int[n];

    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS[i]);
    }

    boolean dp[] = new boolean[100001];
    for(int x : arr){
      for(int i=100000-x ; i>=0 ; i--){
        if(dp[i]) dp[i+x] = true;
      }

      dp[x] = true;
    }

    int cnt = 0;
    StringBuilder sb = new StringBuilder();

    for(int i=0 ; i<100001 ; i++){
      if(dp[i]){
        cnt++;
        sb.append(i+" ");
      }
    }

    System.out.println(cnt);
    System.out.println(sb);
    
  }
}
