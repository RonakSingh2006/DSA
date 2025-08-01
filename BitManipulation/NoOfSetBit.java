package BitManipulation;

public class NoOfSetBit {
    public static int setBits(int n) {
        // code here
        int mask = 1;
        int count = 0;
        
        for(int i=1 ; n >= mask ; i++){
            if((mask & n) != 0) count++;
            
            mask = (1<<i);
        }
        
        return count;
    }
    public static int setBits2(int n) {
        // code here
        int count = 0;
        
        while(n!=0){
            if((n&1) == 1) count++;

            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(setBits2(14));
    }
}