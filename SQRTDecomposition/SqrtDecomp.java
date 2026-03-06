// Use to get the range query

public class SqrtDecomp{

  int arr[];
  int sqrt , n;
  int blocks[];

  SqrtDecomp(int arr[]){
    this.arr = arr;
    this.n = arr.length;
    this.sqrt = (int)Math.ceil(Math.sqrt(n));
    int len = sqrt + 1;
    this.blocks = new int[len];

    fill();
  }

  private void fill(){
    for(int i=0 ; i<n ; i++){
      blocks[i/sqrt] += arr[i];
    }
  }

  public int query(int l , int r){
    int sum = 0;
    // first part until we dont reach at block edge


    while(l<=r && l%sqrt != 0){
      sum += arr[l];
      l++;
    }

    // middle part we take blocks that come in range

    while(l + sqrt <= r){
      sum += blocks[l/sqrt];
      l+= sqrt;
    }

    // end part

    while(l<=r){
      sum += arr[l];
      l++;
    }

    return sum;

  }

  public void update(int i , int val){
    // update block

    blocks[i/sqrt] += (val - arr[i]);

    arr[i] = val;

  }
}