package BitManipulation;

public class PowerOfTwo {
    public static boolean power(int n){
        // prev logic set the right most bit to 0
        // as power of two have only 1 bit so it becomes 0

        return (n & (n-1))==0;
    }
    public static void main(String[] args) {
        System.out.println(power(7));
    }
}
