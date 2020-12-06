import java.lang.IllegalArgumentException;

public class FibRecursive {
    private static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument for fibonacci cannot be smaller than 1");
        }

        return n <= 1 ? n : fib(n-1) + fib(n-2);
    }

    public static void main(String[] arg){
        System.out.println(fib(Integer.valueOf(arg[0])));
    }
}
