package BitManipulation;

public class RightSetBit {
    public static int rightSet(int n){
        return n&(n-1);
    }
    public static void main(String[] args) {
        System.out.println(rightSet(10));
        // 1010 n
        // 1001 n-1
        // 1000
    }
}
