package pocu.recursion;

public class Fibonacci {
    public static void main(String[] args) {

        System.out.println(fibonacciRecursion(5));
    }

    public static int fibonacciRecursion(int number) {

        if (number <= 1) {
            return number;
        }
        return fibonacciRecursion(number - 1) + fibonacciRecursion(number - 2);
    }
}
