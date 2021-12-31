package pocu.finalterm;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciRecursive(8));
        int[] cache = new int[9];
        System.out.println(fibonacciRecursive(8, cache));

    }
    public static int fibonacciRecursive(int num, int[] cache) {
        if (num <= 1) {
            return num;
        }

        if (cache[num] > 0) {
            return cache[num];
        }

        int ret = fibonacciRecursive(num - 2, cache) + fibonacciRecursive(num - 1, cache);

        cache[num] = ret;

        return ret;
    }

    public static int fibonacciRecursive(int num) {
        if (num <= 1) {
            return num;
        }

        return fibonacciRecursive(num - 2) + fibonacciRecursive(num - 1);
    }
}
