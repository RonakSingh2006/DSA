package recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsequence {
    private static List<String> subString(String s , String r){
        List<String> list = new ArrayList<>();
        if(s.isEmpty()){
            list.add(r);
            return list;
        }
        char ch = s.charAt(0);
        list.addAll(subString(s.substring(1), r+ch));
        list.addAll(subString(s.substring(1), r));
        return list;
    }
    public static List<String> subString(String str){
        return subString(str,"");
    }

    private static List<List<Integer>> subSequence(int arr[] , ArrayList<Integer> res){
        List<List<Integer>> list = new ArrayList<>();
        if(arr.length ==0){
            list.add(new ArrayList<>(res));
            return list;
        }
        int x = arr[0];
        int copy[] = Arrays.copyOfRange(arr,1,arr.length);

        // take value
        res.add(x);
        list.addAll(subSequence(copy, res));

        // not take
        res.remove(res.size()-1);
        list.addAll(subSequence(copy, res));

        return list;
    }
    public static List<List<Integer>> subSequence(int arr[]){
        return subSequence(arr, new ArrayList<>());
    }

    // generate binary string
    public static void binaryString(String s , int n){
        if(s.length() == n){
            System.out.println(s);
            return;
        }
        binaryString(s+"0", n);
        if(s.isEmpty() || s.charAt(s.length()-1)!='1'){
            binaryString(s+"1", n);
        }
    }

    // parenthisis generator
    public static List<String> generateParenthesis(int n) {
        return generateParenthesis("",n);
    }
    public static List<String> generateParenthesis(String str , int n) {
        List<String> list = new ArrayList<>();
        if(str.length()==n){
            if(isBalanced(str)) list.add(str);
            return list;
        }

        list.addAll(generateParenthesis(str+"(",n));
        list.addAll(generateParenthesis(str+")",n));

        return list;
    }

    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if(ch=='(') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp != '(') return false;
            }
        }

        return stack.isEmpty();
    }

    // sum
    private static boolean subSequenceSumSingle(int arr[] , int i , int sum , int givenSum , ArrayList<Integer> list){

        if(i==arr.length){
            if(sum == givenSum){
                System.out.println(list);
                return true;
            }
            return false;
        }
        int x = arr[i];
        list.add(x);
        if(subSequenceSumSingle(arr,i+1,sum+x,givenSum,list)) return true;

        list.remove(list.size()-1);
        if(subSequenceSumSingle(arr,i+1,sum,givenSum,list)) return true;

        return false;

    }

    public static void subSequenceSumSingle(int arr[], int sum){
        subSequenceSumSingle(arr,0, 0,sum, new ArrayList<>());
    }

    private static void subSequenceSum(int arr[] , int i , int sum , int givenSum , ArrayList<Integer> list){

        if(i==arr.length){
            if(sum == givenSum){
                System.out.println(list);
            }
            return;
        }
        int x = arr[i];
        list.add(x);
        subSequenceSum(arr,i+1,sum+x,givenSum,list);

        list.remove(list.size()-1);
        subSequenceSum(arr,i+1,sum,givenSum,list);


    }

    public static void subSequenceSum(int arr[], int sum){
        subSequenceSum(arr,0, 0,sum, new ArrayList<>());
    }

    public static int countSubsequenceWithSumK(int arr[] , int sum){
        return countSubsequenceWithSumK(arr, sum, 0, 0);
    }
    private static int countSubsequenceWithSumK(int arr[] , int sum , int index , int currSum){
        if(index == arr.length){
            if(sum == currSum) return 1;
            return 0;
        }
        int x = arr[index];
        int l = countSubsequenceWithSumK(arr,sum,index+1,currSum+x);
        int r = countSubsequenceWithSumK(arr,sum,index+1,currSum);

        return l+r;
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5};
        // subSequenceSumSingle(arr,7);
        int sum = 0;
        subSequenceSum(arr,sum);
        System.out.println(countSubsequenceWithSumK(arr,sum));

    }
}
