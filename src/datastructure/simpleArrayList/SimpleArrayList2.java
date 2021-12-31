package datastructure.simpleArrayList;

class MyArrayList {
    private int[] list;
    private int count;

    MyArrayList(int length) {
        list = new int[length];
        count = 0;
    }

    public void add(int data) {
        if (count < list.length) {
            list[count] = data;
            count++;
        }
    }

    public void delete(int index) {
        if (count > 0 && index < count) {
            for (int i = index; i < count - 1; i++) {
                list[i] = list[i + 1];
            }
            count--;
        }
    }

    public int get(int index) {
        if (count > 0 && index < count) {
            return list[index];
        }
        return -1;
    }

    public int count() {
        return count;
    }
}

public class SimpleArrayList2 {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList(10);

        arrayList.add(2);
        arrayList.add(222);
        arrayList.add(3);
        arrayList.delete(1);

        for (int i = 0; i < arrayList.count(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
