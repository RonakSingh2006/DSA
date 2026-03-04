import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookShop {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String nk[] = br.readLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);

    String priceS[] = br.readLine().split(" ");
    String pageS[] = br.readLine().split(" ");

    int price[] = new int[n];
    int page[] = new int[n];

    for(int i=0 ; i<n ; i++){
      price[i] = Integer.parseInt(priceS[i]);
      page[i] = Integer.parseInt(pageS[i]);
    }

    long prev[] = new long[k+1];

    for(int idx=n-1 ; idx>=0 ; idx--){
      long curr[] = new long[k+1];

      for(int p=0 ; p<=k ; p++){
        if(price[idx] <= p){
          curr[p] = Math.max(prev[p-price[idx]] + page[idx], curr[p]);
        }

        curr[p] = Math.max(curr[p],prev[p]);
      }
      prev = curr;
    }
    

    System.out.println(prev[k]);
    
  }
}
