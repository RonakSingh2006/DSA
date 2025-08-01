package BitManipulation;

public class GetSetClear {
    static void bitManipulation(int num, int i) {
        // code here
        int mask = 1<<(i-1);
        
        int get = (num&mask)==0?0:1;
        
        int set = (num | mask);
        
        // int clear = (get == 0)?num:(num^mask);
        int clear = num & (~mask);
        
        
        System.out.println(get +" "+set+" "+clear);
    }
    public static void main(String[] args) {
        bitManipulation(8, 1);
    }
}
