import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class SegmentTree{
  int n;
  long st[];
  int MOD;

  SegmentTree(int n){
    this.n = n;
    this.st = new long[4*n];
    this.MOD = (int)(1e9 + 7);
  }

  public long query(int l , int r){
    if(l > r) return 0;
    return query(l, r, 0, 0, n-1);
  }

  private long query(int l , int r , int idx , int s , int e){
    // Completely outside
    if(s > r || e < l) return 0;

    // completely inside
    if(s >= l && e <= r){
      return st[idx];
    }

    // overlap

    int mid = s + (e-s)/2;

    return (query(l,r,2*idx+1,s,mid) + query(l,r,2*idx+2,mid+1,e))%MOD;
  }

  public void update(int pos , long val){
    update(0,0,n-1,pos,val);
  } 

  private void update(int idx , int s , int e , int pos , long val){
    // found position
    if (s == e) {
        st[idx] = val;
        return;
    }

    int mid = s + (e - s) / 2;

    if (pos <= mid) {
      update(2 * idx + 1, s, mid, pos, val);
    } else {
      update(2 * idx + 2, mid + 1, e, pos, val);
    }

    st[idx] = (st[2 * idx + 1] + st[2 * idx + 2]) % MOD;
  }
}

public class LIS2 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String aS[] = br.readLine().split(" ");

    int arr[] = new int[n];

    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS[i]);
    }

    // First we have assign new val to each to make them in range 10^5
    int copy[] = Arrays.copyOf(arr,n);
    Arrays.sort(copy);

    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (i == 0 || copy[i] != copy[i - 1]) {
        copy[cnt++] = copy[i];
      }
    }

    // Now using segment tree get ans
    int MOD = (int)(1e9 + 7);

    SegmentTree st = new SegmentTree(n);
    long ans = 0;
    for(int x : arr){

      int nx = Arrays.binarySearch(copy, 0, cnt, x);

      long val = st.query(0, nx-1);

      long cur = st.query(nx,nx);

      st.update(nx,(cur + val + 1)%MOD);

      ans = (ans + val + 1) % MOD;
    }

    System.out.println(ans);
  }
}
