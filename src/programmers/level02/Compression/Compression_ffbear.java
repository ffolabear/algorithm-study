package programmers.level02.Compression;

import java.util.ArrayList;
import java.util.HashMap;

public class Compression_ffbear {

    public ArrayList<Integer> solution(String msg) {

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>();
        int idx = 1;

        for (int i = 65; i <= 90; i++) {
            dict.put(String.valueOf((char) i), idx);
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < msg.length(); i++) {
            sb.append(msg.charAt(i));

            //dict에 키가 있을때
            if (dict.containsKey(sb.toString())) {
                index = dict.get(sb.toString());

                //dict에 키가 없을때
            } else {
                dict.put(sb.toString(), idx++);
                answer.add(index);
                sb.setLength(0);
                i--;
            }

        }
        if (index != 0) {
            answer.add(index);
        }

        return answer;
    }

    public static void main(String[] args) {
        Compression_ffbear sol = new Compression_ffbear();
        String msg = "KAKAO";
//        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        sol.solution(msg);
    }
}
