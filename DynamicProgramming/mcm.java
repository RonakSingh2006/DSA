package DynamicProgramming;
class MatrixChainMultiplication {
    static int matrixMultiplication(int arr[]) {
        // code here
        
        return mcm(arr,1,arr.length-1);
           
    }
    static int mcm(int arr[] , int i , int j) {
        // code here
        
        if(i==j) return 0;
        
        int min = Integer.MAX_VALUE;
        
        for(int k=i ; k<j ; k++){
            int steps = mcm(arr,i,k) + mcm(arr,k+1,j) + (arr[i-1]*arr[k]*arr[j]);
            
            min = Math.min(min,steps);
        }
        
        return min;
           
    }
    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 4};
        System.out.println(matrixMultiplication(arr));
    }
}