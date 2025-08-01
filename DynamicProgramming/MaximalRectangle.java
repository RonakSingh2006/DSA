package DynamicProgramming;
import java.util.Stack;

public class MaximalRectangle {

    public static int prevSmaller(int arr[]  , int idx){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for(int i=0 ; i<n ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans[idx];

    }

    public static int nextSmaller(int arr[]  , int idx){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for(int i=n-1 ; i>=0 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = n;
            }
            else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans[idx];

    }
    
    public static int histogram(int arr[]){
        int n = arr.length;
        int maxArea = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++){

            int ns = nextSmaller(arr, i);
            int ps = prevSmaller(arr, i);
            int area = (ns-ps-1)*arr[i];

            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }

    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[] = new int[m];

        int maxArea = Integer.MIN_VALUE;

        for(int i=0 ; i<n ; i++){
            // modify array
            for(int j=0 ; j<m ; j++){
                if(matrix[i][j] == '0') arr[j] = 0;
                else arr[j]++;
            }

            int area = histogram(arr);

            maxArea = Math.max(area,maxArea);

        }

        return maxArea;                       

    }                                         //  1   1
    public static void main(String[] args) {  //  1   1 1 1
        char arr[][] = {{'1'}};

        System.out.println(maximalRectangle(arr));
       
       
    }
}