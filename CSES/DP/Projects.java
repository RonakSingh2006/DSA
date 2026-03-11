import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Projects {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int task[][] = new int[n][3];

    for(int i=0 ; i<n ; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      task[i][0] = Integer.parseInt(st.nextToken());
      task[i][1] = Integer.parseInt(st.nextToken());
      task[i][2] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(task,(a,b)->a[1]-b[1]);

    long dp[] = new long[n];
    dp[0] = task[0][2];

    for(int i=1 ; i<n ; i++){
      int t[] = task[i];
      int start = t[0];
      int reward = t[2];

      int lb = lower(task,start,i-1);

      long profit = reward + (lb != -1 ? dp[lb] : 0);

      dp[i] = Math.max(profit,dp[i-1]);

    }

    System.out.println(dp[n-1]);
  }

  public static int lower(int task[][] , int val , int high){
    int low = 0;

    int ans = -1;

    while(low <= high){
      int mid = low + (high-low)/2;

      if(task[mid][1] < val){
        ans = mid;
        low = mid+1;
      }
      else{
        high = mid-1;
      }
    }

    return ans;
  }
}
