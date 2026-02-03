class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int arr[] = new  int[1001];

        for(int t[] : trips ){
            arr[t[1]] += t[0];
            arr[t[2]] -= t[0];
        }

        int sum = 0;
        for(int x : arr){
            sum += x;

            if(sum > capacity) return false;
        }

        return true;

    }
}