package SegmentTree;

class RMIQ {
    int st[];
    
    public void build(int idx , int left , int right , int arr[]){
        if(left == right){
            st[idx] = left; // store index
            return;
        }

        int mid = left + (right - left)/2;

        // build left and right

        int l = 2*idx + 1;
        int r = 2*idx + 2;
        build(l, left, mid, arr);
        build(r, mid+1, right, arr);

        st[idx] = (arr[st[l]] > arr[st[r]]) ? st[l] : st[r];
    }

    RMIQ(int arr[]){
        int n = arr.length;
        st = new int[4*n];
        build(0, 0, n-1, arr);
    }

    public int helper(int idx , int left , int right , int start , int end , int arr[]){
        // out of bound
        if(left > end || right < start) return -1;

        // in range
        if(left >= start && right <= end) return st[idx];

        int mid = left + (right - left)/2;
        int l = 2*idx + 1 , r = 2*idx + 2;

        int x = helper(l, left, mid, start, end,arr);
        int y = helper(r, mid+1, right, start, end,arr);

        if(x == -1) return y;
        else if(y == -1) return x;
        else{
            return arr[x] > arr[y] ? x : y;
        }
    }

    public int getIdx(int left , int right , int arr[]){
        int n = arr.length;
        return helper(0, 0, n-1, left, right, arr);
    }




    
}

class MainRMIQ{
    public static void main(String[] args) {
        int arr[] = {4,5,6,8,9,2,0};
        RMIQ rq = new RMIQ(arr);

        System.out.println(rq.getIdx(0, 6, arr));
    }
}
