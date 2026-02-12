class SegmentTree {
    int st[];
    int arr[];
    int n;

    SegmentTree(int arr[]) {
        this.n = arr.length;
        st = new int[4 * n];
        this.arr = arr;

        build(0, 0, n - 1);
    }

    private void build(int idx, int left, int right) {
        if (left == right) {
            st[idx] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;
        build(2 * idx + 1, left, mid);
        build(2 * idx + 2, mid + 1, right);

        st[idx] = st[2 * idx + 1] + st[2 * idx + 2];
    }

    // update query
    private void updateHelp(int idx, int left, int right, int value, int changeIdx) {
        if (left == right) {
            st[idx] = value;
            return;
        }

        int mid = left + (right - left) / 2;

        if (changeIdx > mid) {
            updateHelp(2 * idx + 2, mid + 1, right, value, changeIdx);
        } else {
            updateHelp(2 * idx + 1, left, mid, value, changeIdx);
        }

        st[idx] = st[2 * idx + 1] + st[2 * idx + 2];
    }

    public void update(int idx, int val) {
        updateHelp(0, 0, n - 1, val, idx);
    }

    // range query
    public int range(int left, int right) {
        return rangeHelper(0, 0, n - 1, left, right);
    }

    private int rangeHelper(int idx, int left, int right, int l, int r) {

        // the current range is outside the requide range
        if (right < l || left > r)
            return 0;

        // curr range is inside req
        if (left >= l && right <= r)
            return st[idx];

        // required range is inside the curr range

        int mid = left + (right - left) / 2;

        int ans1 = rangeHelper(2 * idx + 1, left, mid, l, r);
        int ans2 = rangeHelper(2 * idx + 2, mid + 1, right, l, r);

        return ans1 + ans2;
    }
}