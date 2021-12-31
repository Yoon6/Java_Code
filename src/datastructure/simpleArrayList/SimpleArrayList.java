package datastructure.simpleArrayList;

/**
 * https://code-overflow.tistory.com/entry/%EC%9C%A4%EC%84%B1%EC%9A%B0%EC%9D%98-%EC%97%B4%ED%98%88-%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0%EC%88%9C%EC%B0%A8%EB%A6%AC%EC%8A%A4%ED%8A%B8Sequential-List-%EC%9E%90%EB%B0%94Java-%EA%B5%AC%ED%98%84
 * Pseudo Code
 *
 * class SimpleArrayList {
 *     T[] list; // 데이터 저장용 배열
 *     int count; // 저장된 데이터 개수
 *     int cur; // 커서
 *
 *     생성자 {
 *         배열 초기화 & 크기설정;
 *         count = 0;
 *         cur = -1;
 *     }
 *
 *     public void LInsert(T data) {
 *         if ( count >= list.length ) return;
 *         list[count] = data;
 *         count++;
 *     }
 *
 *     public boolean LFirst() {
 *         if (count == 0) return false; // 비어있으면 false;
 *         cur = 0;
 *         return true;
 *     }
 *
 *     public boolean LNext() {
 *         if ( cur >= count - 1 ) return false;
 *         cur++;
 *         return true;
 *     }
 *
 *     public T LRemove() {
 *         T data = list[cur];
 *         for(int i = cur; i < count - 1; i++) {
 *             list[i] = list[i+1];
 *         }
 *         count--;
 *         cur--;
 *         return data;
 *     }
 *
 *     public T get() {
 *         return list[cur];
 *     }
 *
 *     public int LCount() {
 *         return count;
 *     }
 * }
 *
 */


// 기본형 정수 데이터를 저장하는 순차리스트
public class SimpleArrayList {

    int[] list;
    int count;
    int cur;

    SimpleArrayList(int size) {
        list = new int[size];
        count = 0;
        cur = -1;
    }
    SimpleArrayList() {
        this(10);
    }
    public void insert(int data) {
        if (count >= list.length) {
            System.out.println("삽입할 수 없습니다.");
            return;
        }

        list[count] = data;
        count++;
    }

    public boolean first() { // 굳이 필요 없음.
        if (count == 0) return false;
        cur = 0;
        return true;
    }
    public boolean next() {
        if (cur >= count - 1) return false;
        cur++;
        return true;
    }

    public int remove() {
        int data = list[cur];
        for (int i = cur; i < count - 1; i++) {
            list[i] = list[i + 1];
        }
        return data;
    }

    public int get() {
        return list[cur];
    }
    public int count() {
        return count;
    }
}
