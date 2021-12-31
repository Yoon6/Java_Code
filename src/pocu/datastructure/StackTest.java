package pocu.datastructure;

public class StackTest {
    private int[] arr;
    private int pointer;

    public StackTest(int size) {
        arr = new int[size];
        pointer = -1;
    }

    public boolean push(int val) {
        if (isFull()) {
            return false;
        }

        arr[++pointer] = val;

        return true;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        return arr[pointer--];
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[pointer];
    }


    public boolean isFull() {
        return pointer >= arr.length;
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public int size() {
        return pointer + 1;
    }

    public static void main(String[] args) {
        StackTest st = new StackTest(5);

        System.out.println(st.push(10));
        System.out.println(st.peek());
        System.out.println(st.push(20));
        System.out.println(st.peek());
        System.out.println(st.push(30));
        System.out.println(st.push(40));
        System.out.println(st.push(50));
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }

}
