import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LIS {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    String aS[] = br.readLine().split(" ");

    int arr[] = new int[n];

    for(int i=0 ; i<n ; i++){
      arr[i] = Integer.parseInt(aS[i]);
    }

    ArrayList<Integer> list = new ArrayList<>();
    int ans = 0;

    for(int x : arr){
      if(list.isEmpty() || x > list.get(list.size()-1)){
        ans++;
        list.add(x);
      }
      else{
        int ub = upperBound(list, x);
        list.set(ub,x);
      }
    }

    System.out.println(ans);
  }

  public static int upperBound(ArrayList<Integer> list , int val){
    int low = 0;
    int high = list.size()-1;

    int ans = -1;

    while(low <= high){
      int mid = low + (high-low)/2;

      if(list.get(mid) >= val){
        ans = mid;
        high = mid-1;
      }
      else{
        low = mid+1;
      }
    }

    return ans;
  }
}
