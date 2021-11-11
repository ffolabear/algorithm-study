package programmers.level02.TwoDifferentBit;

public class TwoDifferentBit_ffbear {

    public long[] solution(long[] numbers) {

        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {



            if (numbers[i] % 2 == 0) {

                answer[i] = numbers[i] + 1;

            } else {

                String str = Long.toBinaryString(numbers[i]);
                StringBuilder sb = new StringBuilder();
                System.out.println(str);

                if (!str.contains("0")) {

                    sb.append("10");
                    sb.append(str.substring(1));


                } else {

                    //마지막 0을 1로 바꿔주기
                    int lastZero = str.lastIndexOf("0");
                    int firstOne = str.indexOf("1", lastZero);

                    //처음 ~ 첫 0 전까지 + 1
                    sb.append(str, 0, lastZero).append("1");

                    //0 붙혀주기
                    sb.append("0");

                    //나머지 인덱스 ~ 끝까지 붙여주기
                    sb.append(str.substring(firstOne + 1));


                }

                System.out.println(sb);
                answer[i] = Long.parseLong(sb.toString(), 2);


            }

        }




        return answer;
    }

    public static void main(String[] args) {

        long[] numbers = {2, 7};
        TwoDifferentBit_ffbear sol = new TwoDifferentBit_ffbear();
        sol.solution(numbers);

    }
}
