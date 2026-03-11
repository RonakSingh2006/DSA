import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ElevatorRides {

  static class Pair{
    int ride;
    long lastW;

    Pair(int r , long w){
      this.ride = r;
      this.lastW = w;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nx[] = br.readLine().split(" ");

    int n = Integer.parseInt(nx[0]);
    int x = Integer.parseInt(nx[1]);

    String aS[] = br.readLine().split(" ");

    int arr[] = new int[n];

    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS[i]);
    }

    int N = (1<<n)-1;

    int INF = (int)(1e9);
    
    Pair dp[] = new Pair[N+1];
    Arrays.fill(dp,new Pair(INF,INF));

    dp[0] = new Pair(1,0);



    // elements already taken
    for(int mask=0 ; mask <= N ; mask++){

      for(int i=0 ; i<n ; i++){
        if((mask & (1<<i)) != 0) continue;

        int newMask = mask | (1<<i);

        Pair m = dp[mask];

        Pair p;

        if(dp[mask].lastW + arr[i] <= x){
          p = new Pair(m.ride, m.lastW + arr[i]);
        }
        else{
          p = new Pair(m.ride+1,arr[i]);
        }

        if(dp[newMask].ride > p.ride){
          dp[newMask] = p;
        }
        else if(dp[newMask].ride == p.ride && dp[newMask].lastW > p.lastW){
          dp[newMask] = p;
        }
      }
    }

    System.out.println(dp[N].ride);
  
  }
}
