package Tricks;

// It is used to update array in O(n)

// if we have too many range query to do like add 2 in range 2,4 and many more 
// we can do this and get the range sum

public class DifferenceArray {
  public int[] darr(int a[] , int queries[][]){
    for(int q[] : queries){
      int l = q[0];
      int h = a[1];
      int v = q[2];

      a[l] += v;
      if(h+1 < a.length) a[h+1] -= v;
    }

    for(int i=1 ; i<a.length ; i++){
      a[i] += a[i-1];
    }

    return a;
  }
}
