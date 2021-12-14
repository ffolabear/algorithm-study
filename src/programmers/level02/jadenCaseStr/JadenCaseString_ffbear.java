package programmers.level02.jadenCaseStr;

public class JadenCaseString_ffbear {

    public String solution(String s) {

        String answer = "";
        s = s.toLowerCase();;


        answer += String.valueOf(Character.toUpperCase(s.charAt(0)));

        for (int i = 1; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i - 1)).equals(" ") && !String.valueOf(s.charAt(i)).equals(" ")) {
                answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
            } else {
                answer += String.valueOf(s.charAt(i));
            }
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {

//        String s = "3people unFollowed me";
        String s = "3people unFollowed   me";
//        String s = "for the last week";
//        String s = " ";



        JadenCaseString_ffbear sol = new JadenCaseString_ffbear();
        sol.solution(s);

    }
}
