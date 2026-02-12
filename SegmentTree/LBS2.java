// we store left most 0

import java.util.HashMap;

class SegmentTree{
    int max[] , min[] , lazzy[] , n;

    SegmentTree(int n){
        this.n = n;

        this.max = new int[4*n];
        this.min = new int[4*n];
        this.lazzy = new int[4*n];
    }

    private void propogate(int l , int r , int idx){
        if(lazzy[idx] != 0){
            max[idx] += lazzy[idx];
            min[idx] += lazzy[idx];

            if(l != r){
                lazzy[2*idx + 1] += lazzy[idx];
                lazzy[2*idx + 2] += lazzy[idx];
            }

            lazzy[idx] = 0;
        }
    }

    public int findLeftMostIdx(int j){
        if(j==0) return -1;
        return findLeftMostIdx(0,n-1,0,0,j-1);
    }

    private int findLeftMostIdx(int l , int r , int idx , int s , int e){

        propogate(l,r,idx);

        // out of range 
        if(s > r || e < l) return -1;

        // fully inside

        if(l >= s && r <= e){

           int maxVal = max[idx];
           int minVal = min[idx];

           if(minVal <= 0 && maxVal >= 0){
                if(l == r) return l;

                int mid = l + (r-l)/2;

                int left = findLeftMostIdx(l,mid,2*idx+1,s,e);

                if(left != -1) return left;

                return findLeftMostIdx(mid+1,r,2*idx+2,s,e);
           }

           return -1;
        }


        int mid = l + (r-l)/2;
        int left = findLeftMostIdx(l,mid,2*idx+1,s,e);

        if(left != -1) return left;

        return findLeftMostIdx(mid+1,r,2*idx+1,s,e);
    }

    public void rangeUpdate(int s , int e , int val){
        rangeUpdate(0,n-1,0,s,e,val);

        // System.out.println(Arrays.toString(max) + Arrays.toString(min));
    }

    private void rangeUpdate(int l , int r , int idx , int s  , int e , int val){

        propogate(l,r,idx);

        // Out of Range 
        if(l > e || r < s) return;

        // Completely In Range

        if(l >= s && r <= e){
            lazzy[idx] += val;
            propogate(l,r,idx);
            return;
        }

        int mid = l + (r-l)/2;

        rangeUpdate(l,mid,2*idx+1,s,e,val);
        rangeUpdate(mid+1,r,2*idx+2,s,e,val);

        max[idx] = Math.max(max[2*idx + 1] , max[2*idx + 2]);
        min[idx] = Math.min(min[2*idx + 1] , min[2*idx + 2]);
    }
}
class Solution {
    public int longestBalanced(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        SegmentTree st = new SegmentTree(nums.length);

        int ans = 0;

        for(int i=0 ; i<nums.length ; i++){
            int prev = 0;
            if(map.containsKey(nums[i])){
                prev = map.get(nums[i]) + 1;
            }

            if(nums[i] % 2 == 0){
                st.rangeUpdate(prev,i,1);
            }
            else{
                st.rangeUpdate(prev,i,-1);
            }   

            int idx = st.findLeftMostIdx(i);

            if(idx != -1){
                ans = Math.max(ans,i-idx+1);
            }

            map.put(nums[i],i);
        }

        return ans;
    }
}