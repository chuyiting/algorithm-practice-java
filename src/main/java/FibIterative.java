import java.time.Instant;

public class FibIterative {
    synchronized private static int fib(int n) {
        int fib = 1;
        int prevFib = 0;
        for (int i = 2; i <= n; i ++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        if (n < 0) {
            throw new IllegalArgumentException("Argument for the fibonacci cannot be smaller than 0");
        }

        if (n == 0) {
            return prevFib;
        }

        return fib;
    }

    public static void main(String[] arg){
        long startTime = System.nanoTime(); 
        int ans = fib(Integer.valueOf(arg[0]));
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration); 
    } 
}
