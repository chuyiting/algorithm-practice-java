public class FibRecursiveMemo {
    private static int[] fibMemo;

    private static int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Argument for fibonacci cannot be smaller than 0");
        }

        int ans;
        if (isValueMemoized(n)) {
            ans = fibMemo[n];
            return ans;
        }

        ans = n <= 1 ? n : fib(n-1) + fib(n-2);
        fibMemo[n] = ans;
        return ans;
    }

    private static boolean isValueMemoized(int n) {
        if (n == 0) {
            //Default integer array has value 0
            return true;
        }

        return fibMemo[n] == 0 ? false : true;

    }

    public static void main(String[] arg){
        int input = Integer.valueOf(arg[0]);
        fibMemo = new int[input + 1];
        long startTime = System.nanoTime();
        System.out.println(fib(input)); 
        long endTime = System.nanoTime();
        System.out.println("Duration: " + (endTime - startTime));
    } 
}
