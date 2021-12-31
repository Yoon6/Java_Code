import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Prize {

    static int[][] score = {
            {7, 7, 9, 6, 10},
            {12, 15, 14, 13, 11},
            {17, 19, 18, 16, 20}
    };


    public static void main(String[] args) {

        Member[] members = {
//                new Member("남우진", new int[]{1, 0, 0}),
                new Member("김덕화", new int[]{1, 3, 2}),
                new Member("김주현", new int[]{1, 2, 4}),
                new Member("서정원", new int[]{1, 5, 5}),
                new Member("이상엽", new int[]{1, 1, 1}),
                new Member("차지원", new int[]{2, 2, 2}),
                new Member("김지원", new int[]{2, 4, 4}),
                new Member("황준승", new int[]{2, 1, 1}),
                new Member("김경택", new int[]{2, 1, 5}),
                new Member("최윤실", new int[]{3, 3, 3}),
                new Member("백도훈", new int[]{3, 4, 1}),
                new Member("뱅둔", new int[]{3, 2, 2}),
                new Member("임우창", new int[]{3, 5, 1}),
                new Member("홍준표", new int[]{3, 5, 4}),
                new Member("소원", new int[]{4, 3, 5}),
                new Member("김지훈", new int[]{4, 5, 3}),
                new Member("최정은", new int[]{4, 5, 2}),
                new Member("윤정하", new int[]{4, 1, 5}),
                new Member("신세환", new int[]{5, 4, 4}),
                new Member("이아현", new int[]{5, 3, 3}),
                new Member("이선우", new int[]{5, 2, 3}),
                new Member("강민교", new int[]{5, 4, 4}),
        };


//        for (int i = 0; i < score.length; i++) {
//            for (int j = 0; j < score[i].length; j++) {
//
//                // 전체 순회
//                for (int k = 0; k < members.length; k++) {
//                    Member tmpMember = members[k];
//                    // j = 회차별 팀 점수의 인덱스
//                    // j + 1 = 팀 번호
//                    // i 회차에서 멤버의 팀이 j + 1 과 같으면
//                    // 멤버의 스코어에 점수 합산
//                    if (j + 1 == tmpMember.team[i]) {
////                        tmpMember.score += score[i][j];
////                        tmpMember.addScore(score[i][j]);
//                    }
//                }
//
//            }
//        }
//
//        Arrays.sort(members);
//        for (Member member : members) {
//            System.out.println(member);
//        }

//        for (Member member : members) {
//            member.getTotalScore();
//        }
        Arrays.stream(members).sorted().forEach(System.out::println);

    }

    static class Member implements Comparable<Member> {
        private String name;
        private int[] team;
        private int total;

        public Member(String name, int[] team) {
            this.name = name;
            this.team = team;
            getTotalScore();
        }

        public void getTotalScore() {
            int[] iter = {0, 1, 2};

            IntStream.of(iter).forEach((i) -> total += (score[i][team[i] - 1]));
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", total=" + total +
                    '}';
        }
        // score 기준 내림차순 정렬

        @Override
        public int compareTo(Member o) {
            return o.total - this.total;
        }
    }
}
