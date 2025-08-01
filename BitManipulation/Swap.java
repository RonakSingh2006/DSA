package BitManipulation;

class Swap{
    public static void main(String[] args) {
        int a = 9;
        int b = 8;
        System.out.println(a+" "+b);

        a = a^b;
        b = a^b; // (a^b)^b = a^b^b = a^0 = a
        a = a^b; // (a^b)^a = a^a^b = 0^b = b


        System.out.println(a+" "+b);
    }
}