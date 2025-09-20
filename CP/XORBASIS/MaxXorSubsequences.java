package CP.XORBASIS;

class Solution {
    public int maxXorSubsequences(int[] nums) {
        // find max subseq XOR
        int bases[] = new int[32];
        for(int x : nums){
            for(int i=31 ; i>=0 ; i--){
                if((x & (1<<i)) != 0){
                    if(bases[i] != 0){
                        x ^= bases[i];
                    }
                    else{
                        bases[i] = x;
                        break;
                    }
                }
            }
        }

        // now we have all dominant terms

        int ans = 0;

        for(int i=31 ; i>=0 ; i--){
            if((bases[i] & (1<<i)) != 0){
                ans = Math.max(ans,ans^bases[i]);
            }
        }

        return ans;
    }
}
