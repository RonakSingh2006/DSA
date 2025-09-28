package FenwickTree;

public class Fenwick {
    int bit[];  // binary indexed tree
    int n;

    Fenwick(int arr[]) {
        this.n = arr.length;
        bit = new int[n + 1];  // 1-based indexing

        build(arr);
    }

    // add `val` at index `id`
    private void update(int id, int val) {
        while (id <= n) {
            bit[id] += val;
            id += (id & -id);
        }
    }

    // prefix sum from 1 to id
    private int query(int id) {
        int ans = 0;
        while (id > 0) {
            ans += bit[id];
            id -= (id & -id);
        }
        return ans;
    }

    // build tree from arr
    private void build(int arr[]) {
        for (int i = 1; i <= n; i++) {
            update(i, arr[i - 1]); 
        }
    }

    // get range sum [l, r]
    public int range(int l, int r) {
        return query(r) - query(l - 1);
    }

    // point update: set arr[idx-1] = val
    public void updateQuery(int idx, int val) {
        int prevVal = range(idx, idx);  // actual value at idx
        update(idx, -prevVal);
        update(idx, val);
    }
}
