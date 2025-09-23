package SegmentTree;

public class LazzyPropogation {
  int st[];
  int arr[];
  int lazzy[];
  int n;

  LazzyPropogation(int arr[]){
    this.n = arr.length;
    this.arr = arr;

    st = new int[4*n];
    lazzy = new int[4*n];

    build(0,0,n-1);
  }

  public void build(int idx , int left , int right){
    if(left == right){
      st[idx] = arr[left];
      return;
    }

    int mid = left + (right - left)/2;

    build(2*idx + 1 , left , mid);
    build(2*idx + 2 , mid+1 , right);

    st[idx] = st[2*idx + 1] + st[2*idx + 2];
  }

  // update in range
  public void update(int left , int right , int val){
      updateHelper(0, 0, n-1, left, right, val);
  }

  private void updateHelper(int idx , int left , int right , int l , int r , int val){
    // Update prev value left
    if(lazzy[idx] != 0){
      st[idx] += (right - left + 1)*lazzy[idx];

      // if have children
      if(left != right){
        lazzy[2*idx + 1] += lazzy[idx];
        lazzy[2*idx + 2] += lazzy[idx];
      }

      lazzy[idx] = 0;
    }


    // out of range
    if(left > r || right < l) return;

    // completely overlapping
    if(left >= l && right <= r){
      st[idx] += (right - left + 1)*val;

      if(left != right){
        lazzy[2*idx + 1] += val;
        lazzy[2*idx + 2] += val;
      }

      return;
    }

    int mid = left + (right - left)/2;

    updateHelper(2*idx + 1, left, mid, l, r, val);
    updateHelper(2*idx + 2, mid+1, right, l, r, val);

    st[idx] = st[2*idx + 1] + st[2*idx + 2];
  }


  // range query

  public int range(int left , int right){
    return rangeHelper(0, 0, n-1, left, right);
  }


  private int rangeHelper(int idx , int left , int right , int l , int r){
    // update if remaning
    if(lazzy[idx] != 0){
      st[idx] += (right - left + 1)*lazzy[idx];

      if(left != right){
        lazzy[2*idx + 1] += lazzy[idx];
        lazzy[2*idx + 2] += lazzy[idx];
      }
      lazzy[idx] = 0;
    }


    // out of range
    if(left > r || right < l) return 0;


    // completely inside
    if(left >= l && right <= r) return st[idx];

    int mid = left + (right - left)/2;

    return rangeHelper(2*idx + 1, left, mid, l, r) + rangeHelper(2*idx + 2, mid+1, right, l, r);

  }
}

// Test

// class LazzyPropogationMain{
//   public static void main(String[] args) {
//     int arr[] = {1,2,3,4,5};

//     LazzyPropogation st = new LazzyPropogation(arr);
//     System.out.println(st.range(0, 4));
//     st.update(1, 3, 2);
//     System.out.println(st.range(0, 4));
//   }
// }

// For mimum/max


// package SegmentTree;

// public class LazzyPropogation {
//   int st[];
//   int arr[];
//   int lazzy[];
//   int n;

//   LazzyPropogation(int arr[]){
//     this.n = arr.length;
//     this.arr = arr;

//     st = new int[4*n];
//     lazzy = new int[4*n];

//     build(0,0,n-1);
//   }

//   public void build(int idx , int left , int right){
//     if(left == right){
//       st[idx] = arr[left];
//       return;
//     }

//     int mid = left + (right - left)/2;

//     build(2*idx + 1 , left , mid);
//     build(2*idx + 2 , mid+1 , right);

//     st[idx] = Math.min(st[2*idx + 1] , st[2*idx + 2]);
//   }

//   // update in range
//   public void update(int left , int right , int val){
//       updateHelper(0, 0, n-1, left, right, val);
//   }

//   private void updateHelper(int idx , int left , int right , int l , int r , int val){
//     // Update prev value left
//     if(lazzy[idx] != 0){
//       st[idx] += lazzy[idx];

//       // if have children
//       if(left != right){
//         lazzy[2*idx + 1] += lazzy[idx];
//         lazzy[2*idx + 2] += lazzy[idx];
//       }

//       lazzy[idx] = 0;
//     }


//     // out of range
//     if(left > r || right < l) return;

//     // completely overlapping
//     if(left >= l && right <= r){
//       st[idx] += val;

//       if(left != right){
//         lazzy[2*idx + 1] += val;
//         lazzy[2*idx + 2] += val;
//       }

//       return;
//     }

//     int mid = left + (right - left)/2;

//     updateHelper(2*idx + 1, left, mid, l, r, val);
//     updateHelper(2*idx + 2, mid+1, right, l, r, val);

//     st[idx] = Math.min(st[2*idx + 1] , st[2*idx + 2]);
//   }


//   // range query

//   public int range(int left , int right){
//     return rangeHelper(0, 0, n-1, left, right);
//   }


//   private int rangeHelper(int idx , int left , int right , int l , int r){
//     // update if remaning
//     if(lazzy[idx] != 0){
//       st[idx] += lazzy[idx];

//       if(left != right){
//         lazzy[2*idx + 1] += lazzy[idx];
//         lazzy[2*idx + 2] += lazzy[idx];
//       }
//       lazzy[idx] = 0;
//     }


//     // out of range
//     if(left > r || right < l) return Integer.MAX_VALUE;


//     // completely inside
//     if(left >= l && right <= r) return st[idx];

//     int mid = left + (right - left)/2;

//     return Math.min(rangeHelper(2*idx + 1, left, mid, l, r) , rangeHelper(2*idx + 2, mid+1, right, l, r));

//   }
// }

// // Test

// class LazzyPropogationMain{
//   public static void main(String[] args) {
//     int arr[] = {1,2,3,4,5};

//     LazzyPropogation st = new LazzyPropogation(arr);
//     System.out.println(st.range(0, 4));
//     st.update(0, 3, 2);
//     System.out.println(st.range(0, 4));
//   }
// }

