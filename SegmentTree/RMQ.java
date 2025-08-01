package SegmentTree;

/* The functions which
builds the segment tree */
class GfG {
    static int st[];
    
    private static void build(int idx , int left , int right , int arr[]){
        if(left == right){
            st[idx] = arr[left];
            return;
        }
        
        int mid = left + (right - left)/2;
        
        build(2*idx + 1 , left , mid , arr);
        build(2*idx + 2 , mid+1 , right , arr);
        
        st[idx] = Math.min(st[2*idx + 1] , st[2*idx + 2]);
    }

    public static int[] constructST(int arr[], int n) {
        // Add your code here
        st = new int[4*n];
        build(0,0,n-1,arr);
        
        return st;
        
    }

    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int idx , int left , int right , int start , int end){
        if(left > end || start > right) return Integer.MAX_VALUE;
        
        if(left>= start && right <= end) return st[idx];
        
        int mid = left + (right - left)/2;

        int val1 = RMQ(2*idx + 1,left,mid,start,end);
        int val2 = RMQ(2*idx + 2,mid+1,right,start,end);
        
        return Math.min( val1, val2);
    }
    public static int RMQ(int st[], int n, int l, int r) {
        // Add your code here
        
        return RMQ(0,0,n-1,l,r);
    }
}
class MainRMQ{
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int st[] = GfG.constructST(arr,4);
        System.out.println(GfG.RMQ(st, 4, 0, 2));
    }
}