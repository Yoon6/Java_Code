package datastructure.simpleArrayList;

public class SimpleArrayListTest {
    public static void main(String[] args) {
        SimpleArrayList arrayList = new SimpleArrayList();

        arrayList.insert(11);
        arrayList.insert(12);
        arrayList.insert(13);
        arrayList.insert(14);
        arrayList.insert(15);
        arrayList.insert(15);
        arrayList.insert(15);
        arrayList.insert(18);
        arrayList.insert(15);
        arrayList.insert(15);
//
//        if (arrayList.first()) {
//            System.out.println(arrayList.get());
//        }

        while (arrayList.next()) {
            System.out.println(arrayList.get());
        }

        System.out.println("count="+arrayList.count());
    }
}
