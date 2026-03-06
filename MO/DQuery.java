import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DQuery {
  static class Query{
    int l , r , i;
    Query(int l , int r , int i){
      this.l = l;
      this.r = r;
      this.i = i;
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

    int qn = Integer.parseInt(br.readLine());

    Query query[] = new Query[qn];
    for(int i=0 ; i<qn ; i++){

      String lr[] = br.readLine().split(" ");

      query[i] = new Query(Integer.parseInt(lr[0])-1, Integer.parseInt(lr[1])-1, i);
    }

    int sqrt = (int)Math.ceil(Math.sqrt(n));

    Arrays.sort(query,(a,b)->{
      int b1 = a.l/sqrt;
      int b2 = b.l/sqrt;

      if(b1 == b2) return b.r - a.r;

      return b1 - b2;
    });



    int freq[] = new int[(int)(1e6 + 1)];
    int cnt = 0;

    int start = 0;
    int end = -1;

    int ans[] = new int[qn];

    for(Query q : query){
      int l = q.l;
      int r = q.r;


      while(end < r){
        end++;

        if(freq[arr[end]] == 0) cnt++;
        freq[arr[end]]++;
      }

      while(start > l){
        start--;

        if(freq[arr[start]] == 0) cnt++;
        freq[arr[start]]++;
      }

      while(end > r){
        if(freq[arr[end]] == 1) cnt--;
        freq[arr[end]]--;
        end--;
      }

      while(start < l){
        if(freq[arr[start]] == 1) cnt--;
        freq[arr[start]]--;
        start++;
      }

      ans[q.i] = cnt;

    }

    StringBuilder sb = new StringBuilder();
    for(int a : ans){
        sb.append(a).append("\n");
    }
    System.out.print(sb);

  }
}
