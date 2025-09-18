package BinaryLifting;

class TreeAncestor {

    // par in 2 pow 
    // for eg 1
    // 2^i  0  1  2 3 4 5 6
    // 1   -1  0  0 1 1 2 2
    // 2   -1 -1 -1 0 0 0 0
    // .....
    int par[][];

    public TreeAncestor(int n, int[] parent) {
        par = new int[32][n];
        for(int i=0 ; i<n ; i++){
            par[0][i] = parent[i];
        }

        for(int bit=1 ; bit<32 ; bit++){
            for(int i=0 ; i<n ; i++){
                int p = par[bit-1][i];

                if(p == -1) par[bit][i] = -1;

                else par[bit][i] = par[bit-1][p];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=31 ; i>=0 ; i--){
            if((k & (1<<i)) != 0){
                node = par[i][node];

                if(node == -1) return -1;
            }
        }

        return node;
    }

    public int noOfBits(int n){
        int d = 0;
        while(n > 0){
            d++;
            n = n << 1;
        }

        return d;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */