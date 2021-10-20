package programmers.level02.newsClustering;

import java.util.ArrayList;

public class NewsClustering_ffbear {

    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<String> str1Arr = new ArrayList<>();
        ArrayList<String> str2Arr = new ArrayList<>();

        ArrayList<String> union = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {

            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if (a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
                str1Arr.add(String.valueOf(a) + b);
            }

        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if (a >= 'a' && a <= 'z' && b >= 'a' && b <= 'z') {
                str2Arr.add(String.valueOf(a) + b);
            }

        }

        System.out.println(str1Arr);
        System.out.println(str2Arr);

        int intersection = 0;

        for (String s : str1Arr) {
            if (str2Arr.remove(s)) {
                intersection++;
            }
            union.add(s);
        }

        union.addAll(str2Arr);
        int answer = 0;

        if (union.size() == 0) {
            answer = 65536;
        } else {

            double j = (double) intersection / (double) union.size() * 65536;
            answer = (int) Math.floor(j);

        }


        return answer;
    }

    public static void main(String[] args) {

        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        String str11 = "handshake";
        String str22 = "shake hands";

        NewsClustering_ffbear sol = new NewsClustering_ffbear();
//        sol.solution(str1, str2);
        sol.solution(str11, str22);

    }

}
