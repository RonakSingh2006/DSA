import java.util.Arrays;

public class MOAlgorithm{

  static class Query{
    int l , r , idx;

    Query(int l , int r , int idx){
      this.l = l;
      this.r = r;
      this.idx = idx;
    }
  }
  public static void main(String[] args) {
    
    int arr[] = {5,7,8,9,10,12,5,6,15,21};

    int sqrt = (int)Math.ceil(Math.sqrt(arr.length));


    int query[][] = {{1,3},{5,6},{7,8},{0,5},{8,9}};
    Query q[] = new Query[query.length];
    for(int i=0 ; i<query.length ; i++){
      q[i] = new Query(query[i][0], query[i][1], i);
    }

    // Arranging query
    Arrays.sort(q,(a,b)->{
      if((a.l/sqrt) == (b.l/sqrt)) return b.r - a.r;

      return (a.l/sqrt) - (b.l/sqrt);
    });

    int start = 0;
    int end = -1;

    int ans[] = new int[query.length];
    int sum = 0;

    for(Query qr : q){
      int l = qr.l;
      int r = qr.r;
      int idx = qr.idx;


      while(start < l){
        sum -= arr[start];
        start++;
      }

      while(start > l){
        start--;
        sum += arr[start];
      }

      while(end < r){
        end++;
        sum += arr[end];
      }

      while(end > r){
        sum -= arr[end];
        end--;
      }

      ans[idx] = sum;
    }

    System.out.println(Arrays.toString(ans));

  }
}

// It uses sqrt decomposition

// We all query simultaneously

// Sort query according min block first if block are same then max r