package level02;

public class StringComp_ffbear {

    public int solution(String s) {

        int answer = 0;
        String temp = "";

        if (s.length() == 1) {
            answer = 1;

        } else {

            //문자열의 절반보다 큰 단위는 존재할수없음
            int middle = s.length() / 2;

            //문자열 단위
            String unit = "";

            //단위를 제거하고 남은 문자
            String left = "";

            //남은문자에서 단위와 같은지 검증
            String valid = "";

            //같은 문자 반복 횟수 카운트
            int cnt = 0;

            for (int i = middle; i >= 0; i--) {

                unit = s.substring(0, i);
                left = s.substring(i);
                valid = left.substring(0, unit.length());
                int count = 1;

//                System.out.println(unit + " / " + left + " / " + valid);

            }

        }

        return answer;
    }

    public static void main(String[] args) {

        String s = "aabbaccc";
//        String s = "ababcdcdababcdcd";
//        String s = "abcabcdede";
//        String s = "abcabcabcabcdededededede";
//        String s = "xababcdcdababcdcd";

        StringComp_ffbear stringComp = new StringComp_ffbear();
        stringComp.solution(s);

    }

}
