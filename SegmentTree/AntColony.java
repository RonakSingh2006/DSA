import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class AntColony {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    
    StringTokenizer aS = new StringTokenizer(br.readLine());
    
    int arr[] = new int[n];
    
    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS.nextToken());
    }
    
    int q = Integer.parseInt(br.readLine());
    
    SegmentTree st = new SegmentTree(arr);
    
    while(q-- > 0){
      StringTokenizer lr = new StringTokenizer(br.readLine());
      
      int l = Integer.parseInt(lr.nextToken())-1;
      int r = Integer.parseInt(lr.nextToken())-1;
      
      int cnt = st.query(l, r);
      
      int len = r - l + 1;
      
      System.out.println(len - cnt);
    }
  }
}
// st -> gcd , cnt
class SegmentTree{
  int st[][] , n , arr[];
  SegmentTree(int arr[]){
    n = arr.length;
    this.arr = arr;
    st = new int[4*n][2];

    build(0,0,n-1);
  }

  private void build(int idx , int l , int r){
    if(l==r){
      st[idx] = new int[]{arr[l],1};
      return;
    }

    int mid = l + (r-l)/2;

    build(2*idx+1,l,mid);
    build(2*idx+2,mid+1,r);

    int left[] = st[2*idx + 1];
    int right[] = st[2*idx + 2];


    st[idx] = merge(left,right);
  }

  public int query(int l , int r){
    return query(0,0,n-1,l,r)[1];
  }

  private int[] query(int idx , int l , int r , int s , int e){
    // completely outside
    if(l > e || r < s){
      return new int[]{0,0};
    }

    // inside
    if(l >= s && r <= e){
      return st[idx];
    }

    int mid = l + (r-l)/2;

    int left[] = query(2*idx+1,l,mid,s,e);
    int right[] = query(2*idx+2,mid+1,r,s,e);

    return merge(left,right);

  }

  private int[] merge(int left[] , int right[]){
    int g = gcd(left[0],right[0]);

    if(left[0] == right[0]){
      return new int[]{g,left[1] + right[1]};
    }
    else if(g == left[0]){
      return new int[]{g,left[1]};
    }
    else if(g == right[0]){
      return new int[]{g,right[1]};
    }
    else{
      return new int[]{g,0};
    }
  }


  private int gcd(int a , int b){
    if(b==0) return a;

    if(a < b) return gcd(b,a);

    return gcd(b,a%b);
  }
}
