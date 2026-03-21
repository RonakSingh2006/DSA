import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittleElephant {
  static class Query{
    int l,r,i;

    Query(int l , int r , int idx){
      this.l = l;
      this.r = r;
      this.i = idx;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer nt = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(nt.nextToken());
    int t = Integer.parseInt(nt.nextToken());

    StringTokenizer aS = new StringTokenizer(br.readLine());
    int arr[] = new int[n];
    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS.nextToken());
    }

    int sqrt = (int)Math.ceil(Math.sqrt(n));

    Query query[] = new Query[t];

    for(int i=0 ; i<t ; i++){
      StringTokenizer lr = new StringTokenizer(br.readLine());
      query[i] = new Query(Integer.parseInt(lr.nextToken())-1, Integer.parseInt(lr.nextToken())-1,i);
    }


    Arrays.sort(query,(a,b)->{
      if((a.l/sqrt) == (b.l/sqrt)){
        return a.r - b.r;
      }

      return (a.l/sqrt) - (b.l/sqrt);
    });

    // we can take 1e5 as it is size of array as we have to make the elemnt freq == x so any elemnt > n is invalid
    int MAX = (int)(1e5);

    int f[] = new int[MAX+1];

    long ans[] = new long[t];

    int s = 0 , e = -1;

    long cnt = 0;
    for(Query q : query){
      int l = q.l;
      int r = q.r;

      while(e < r){
        e++;
        int x = arr[e];

        if(x <= n){
          if(f[x] == x) cnt--;
          f[x]++;
          if(f[x] == x) cnt++;
        } 
      }

      while(e > r){
        int x = arr[e];


        if(x <= n){
          if(f[x] == x) cnt--;
          f[x]--;
          if(f[x] == x) cnt++;
        }

        e--;
      }


      while(s > l){
        s--;

        int x = arr[s];
        
        if(x <= n){
          if(f[x] == x) cnt--;
          f[x]++;
          if(f[x] == x) cnt++;
        } 
      }

      while(s < l){
        int x = arr[s];

        if(x <= n){
          if(f[x] == x) cnt--;
          f[x]--;
          if(f[x] == x) cnt++;
        }

        s++;
      }

      ans[q.i] = cnt;
    }


    StringBuilder sb = new StringBuilder();

    for(long x : ans){
      sb.append(x).append("\n");
    }

    System.out.println(sb);
  }
}
