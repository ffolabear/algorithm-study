package programmers.level02.NewsClustering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewsClustering_ffbear {
    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> str1Arr = new ArrayList<>();
        ArrayList<String> str2Arr = new ArrayList<>();

        String regex = "[a-z]";


        System.out.println(str1);
        System.out.println(str2);

//        ArrayList<String> union = new ArrayList<>();
        Map<String, Integer> union = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if (a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
                union.put(String.valueOf(a) + b, 0);
                str1Arr.add(String.valueOf(a) + b);
            }

        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if (a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
                union.put(String.valueOf(a) + b, 0);
                str2Arr.add(String.valueOf(a) + b);
            }

        }


        int intersection = 0;

        for (int i = 0; i < str1Arr.size(); i++) {
            for (int j = 0; j < str2Arr.size(); j++) {
                if (str1Arr.get(i).equals(str2Arr.get(j))) {
                    intersection++;
                }
            }

        }

        if (intersection > str1Arr.size() || intersection > str2Arr.size()) {
            intersection = Math.min(str1Arr.size(), str2Arr.size());
        }

        System.out.println("str1 : " + str1Arr);
        System.out.println("str2 : " + str2Arr);
        System.out.println("합집합 : " + union + " / " + union.size());
        System.out.println("교집합의 수 : " + intersection);


        double f = (float) intersection / union.size() * 65536;
        int answer = (int) Math.floor(f);

        System.out.println(answer);


        System.out.println();
        return answer;
    }

    public static void main(String[] args) {

        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        String str11 = "handshake";
        String str22 = "shake hands";

        NewsClustering_ffbear sol = new NewsClustering_ffbear();
        sol.solution(str1, str2);
        sol.solution(str11, str22);

    }

}
