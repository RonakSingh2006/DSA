import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PowerfulArray {
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

    int MAX = (int)(1e6);

    int f[] = new int[MAX+1];

    long ans[] = new long[t];

    int s = 0 , e = -1;

    long val = 0;
    for(Query q : query){
      int l = q.l;
      int r = q.r;

      while(e < r){
        e++;
        int x = arr[e];

        val -= 1l*x*f[x]*f[x];

        f[x]++;

        val += 1l*x*f[x]*f[x];

      }

      while(e > r){
        int x = arr[e];

        val -= 1l*x*f[x]*f[x];

        f[x]--;

        val += 1l*x*f[x]*f[x];

        e--;
      }


      while(s > l){
        s--;

        int x = arr[s];
        
        val -= 1l*x*f[x]*f[x];

        f[x]++;

        val += 1l*x*f[x]*f[x];
      }

      while(s < l){
        int x = arr[s];

        val -= 1l*x*f[x]*f[x];

        f[x]--;

        val += 1l*x*f[x]*f[x];

        s++;
      }

      ans[q.i] = val;
    }


    StringBuilder sb = new StringBuilder();

    for(long x : ans){
      sb.append(x).append("\n");
    }

    System.out.println(sb);
  }
}
