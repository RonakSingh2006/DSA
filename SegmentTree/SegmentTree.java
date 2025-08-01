package SegmentTree;

import java.util.Arrays;

public class SegmentTree {
    int segmenttree[];
    int arr[];
    int lazzy[];
    
    SegmentTree(int arr[]){
        int n = arr.length;
        segmenttree = new int[4*n];
        lazzy = new int[4*n];
        this.arr = arr;
        
        buildTree(0, 0, n-1);
    }

    private void buildTree(int idx , int left , int right){
        if(left == right){
            segmenttree[idx] = arr[left];
            return;
        }

        int mid =  left + (right-left)/2;
        buildTree(2*idx + 1 , left, mid);
        buildTree(2*idx + 2, mid+1, right);

        segmenttree[idx] =  segmenttree[2*idx+1] + segmenttree[2*idx + 2];
    }


    // update query
    private void updateHelp(int idx , int left , int right , int value , int changeIdx){
        if(left == right){
            segmenttree[idx] = value;
            return;
        }

        int mid = left + (right-left)/2;

        if(changeIdx > mid){
            updateHelp(2*idx + 2, mid+1, right, value, changeIdx);
        }
        else{
            updateHelp(2*idx + 1,left, mid, value, changeIdx);
        }

        segmenttree[idx] = segmenttree[2*idx + 1] + segmenttree[2*idx + 2];
    }
    public void update(int idx , int value){
        updateHelp(0,0,arr.length-1,value,idx);
    }

    // Update in Range 
    private void updateHelp(int idx , int left , int right , int start , int end , int val){
        // out of range
        int noOfChild = right - left + 1;
        if(lazzy[idx] != 0){

            segmenttree[idx] += noOfChild*lazzy[idx];
            
            if(noOfChild > 1){
                lazzy[2*idx + 1] += lazzy[idx];
                lazzy[2*idx + 2] += lazzy[idx];
            }

            lazzy[idx] = 0;

        }
        if(left > end || start > right){
            return;
        }

        // inside range
        if(left >= start && right <= end){
            segmenttree[idx] += noOfChild*val;

            if(noOfChild > 1){
                lazzy[2*idx + 1] += val;
                lazzy[2*idx + 2] += val;
            }

            return;
        }

        int mid = left + (right - left)/2;

        updateHelp(2*idx + 1, left, mid, start, end, val);
        updateHelp(2*idx + 2, mid+1, right, start, end, val);

        segmenttree[idx] = segmenttree[2*idx + 1] + segmenttree[2*idx + 2];


    }
    public void update(int start , int end , int val){
        updateHelp(0, 0, arr.length-1, start, end, val);
    }


    // range query  
    public int rangeQuery(int left , int right){
        return rangeQueryHelper(0, 0, arr.length-1, left, right);
    }

    private int rangeQueryHelper(int idx , int left , int right , int l , int r){
        if(lazzy[idx] != 0){
            int noOfChild = right - left + 1;
            segmenttree[idx] += lazzy[idx] * noOfChild;
            if(noOfChild > 1){
                lazzy[2*idx + 1] += lazzy[idx];
                lazzy[2*idx + 2] += lazzy[idx];
            }
            lazzy[idx] = 0;
        }

        // the current range is outside the requide range
        if(right < l || left > r) return 0;

        // curr range is inside req
        if(left >= l && right <= r) return segmenttree[idx];
        
        // required range is inside the curr range

        int mid = left + (right - left)/2;

        int ans1 = rangeQueryHelper(2*idx + 1 ,left, mid, l, r);
        int ans2 = rangeQueryHelper(2*idx + 2, mid +1 , right, l, r);


        return ans1 + ans2;
    }
}

class Main{
    public static void main(String[] args) {
        int arr[] = {3,1,2,7};
        SegmentTree st = new SegmentTree(arr);
        // st.update(0, 0);
        System.out.println(Arrays.toString(st.segmenttree));
        
        System.out.println(st.rangeQuery(1, 3));
    }
}