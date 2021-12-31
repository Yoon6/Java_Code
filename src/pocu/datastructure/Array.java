package pocu.datastructure;

import java.util.Arrays;

public class Array {

    // 저장해놓을 배열
    private int[] arr;
    // 현재 배열에 들어있는 요소의 수
    private int size;

    // 생성자에서 배열의 크기를 초기화한다.
    public Array(int size) {
        arr = new int[size];
        size = 0;
    }

    // 값 조회
    // 값이 없으면 -1;
//    public int get(int index){
//        return index < size ? arr[index] : -1;
//    }

    // 배열 끝에 추가
    public boolean addToLast(int value) {
        if (isFull()) {
            return false;
        }

        arr[size++] = value;
        return true;
    }

    // 인덱스로 값 추가
    public boolean addToIndex(int index, int value) {
        if (isFull()) {
            return false;
        }

        // 한 칸 씩 뒤로 미루기
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = value;
        size++;
        return true;
    }

    // 인덱스 0에 추가
    public boolean addToFirst(int value) {
        if (isFull()) {
            return false;
        }

        for (int i = size; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        size++;
        return true;
    }

    // 배열 끝에서 삭제
    // 삭제한 값을 반환, 없으면 -1 반환
    public int removeToLast() {
        if (isEmpty()) {
            return -1;
        }

        int result = arr[size - 1];
        arr[--size] = 0;
        return result;
    }

    // 인덱스로 삭제
    public int removeToIndex(int index){
        if (isEmpty()) {
            return -1;
        }

        int result = arr[index];
        for (int i = index; i < size - 1; i++) {

            arr[i] = arr[i + 1];
        }

        arr[--size] = 0;
        return result;
    }

    // 인덱스 0 삭제
    public int removeToFirst() {
        if (isEmpty()) {
            return -1;
        }

        int result = arr[0];
        for (int i = 0; i < size - 1; i++) {

            arr[i] = arr[i + 1];
        }

        arr[--size] = 0;
        return result;
    }


    public int size(){
        return size;
    }

    public boolean isFull(){
        return size >= arr.length;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void print(){
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {

        Array ar = new Array(3);

        System.out.println(ar.addToLast(1));
        System.out.println(ar.addToIndex(1, 2));
        ar.print();
        System.out.println(ar.addToFirst(0));
        ar.print();

        System.out.println(ar.removeToLast());
        ar.print();

        System.out.println(ar.addToFirst(3));
        ar.print();
        System.out.println(ar.addToFirst(0));

        System.out.println(ar.removeToFirst());
        ar.print();

        System.out.println(ar.addToLast(2));
        ar.print();
        System.out.println(ar.removeToIndex(1));
        ar.print();
    }
}
