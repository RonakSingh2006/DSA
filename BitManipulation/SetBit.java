package BitManipulation;

public class SetBit {
    public static boolean isSetBit(int n , int idx){

        // example
        /*
         * n = 10 --> 1010
         * let idx = 2
         * bitmask = 1<<(2-1) = 0010
         * 1010 & 0010  != 1 
         * hence 2 bit is set bit
         */ 


        int bitmask = 1<<(idx-1);  

        return (n & bitmask) != 0;
    }
    public static void main(String[] args) {
        System.out.println(isSetBit(10,1));
    }
}
