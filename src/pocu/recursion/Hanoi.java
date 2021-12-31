package pocu.recursion;

public class Hanoi {

    public static void main(String[] args) {

        hanoiRecursion(4, 0, 1, 2);
    }

    public static void hanoiRecursion(int num, int from, int to, int other) {
        if (num == 0) {
            return;
        }

        hanoiRecursion(num - 1, from, other, to);
        System.out.println(from + "에서 " + to + "로 옮긴다.");
        hanoiRecursion(num - 1, other, to, from);
    }
}
