// Use to get the range query

public class SqrtDecomp{
  public static void main(String[] args) {
    int arr[] = {5,6,7,8,9,10,15};

    int n = arr.length;

    // we make a array of size Math.ceil(sqrt)

    int sqrt = (int)Math.ceil(Math.sqrt(n));

    int len = (int)Math.ceil(sqrt);

    int block[] = new int[len];

    // we store sum in range of sqrt
    for(int i=0 ; i<n ; i++){
      block[i/sqrt] += arr[i];
    }

    int queries[][] = {{1,2},{5,6},{1,6},{0,4},{2,5}};


    for(int q[] : queries){
      int l = q[0];
      int r = q[1];

      // first part until we dont reach at block edge

      int sum = 0;

      while(l<=r && l%sqrt != 0){
        sum += arr[l];
        l++;
      }

      // middle part we take blocks that come in range

      while(l + sqrt <= r){
        sum += block[l/sqrt];
        l+= sqrt;
      }

      // end part

      while(l<=r){
        sum += arr[l];
        l++;
      }


      System.out.println(sum);
    }
  }
}