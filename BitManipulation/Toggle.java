package BitManipulation;

public class Toggle {
    public static void main(String[] args) {
        int n = 5; // 101
        int idx = 2;

        int mask = 1<<(idx-1);

        System.out.println(n^mask); // 111
    }
}
