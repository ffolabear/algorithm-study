package programmers.level02.convertingBracket;

public class ConvertingBracket_ffbear {

    public String solution(String p) {
        String answer = "";

        String[] covt = p.split("");

        int cnt = 0;

        if (p.equals("")) {
            answer = "";
        }

        int idx = split(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (isValid(u)) {
            answer += u;
        } else {
            answer += "(";
            if (!v.equals("")) {
                solution(v);
                v = "";
            }
        }


        answer += ")";
        answer += convert(u);

        if (!v.equals("")) {
            solution(v);
        }

        return answer;
    }


    static int split(String p) {

        String[] covt = p.split("");

        int cnt = 0;
        int idx = 0;


        for (int i = 0; i < covt.length; i++) {
            if (covt[i].equals("(")) {
                cnt++;
            } else {
                cnt--;
            }

            //균형잡힌 문자열
            if (cnt == 0) {
                idx = i + 1;
                break;
            }


        }
        return idx;
    }

    public boolean isValid(String p) {

        String[] covt = p.split("");

        int cnt = 0;

        for (int i = 0; i < covt.length; i++) {
            if (covt[i].equals("(")) {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt < 0) {
                return false;
            }
        }
        return true;
    }

    static String convert(String p) {

        String[] covt = p.split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < covt.length; i++) {
            if (covt[i] == "(") {
                sb.append(")");
            } else {
                sb.append("(");
            }


        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String p = "(()())()";
        ConvertingBracket_ffbear sol = new ConvertingBracket_ffbear();
        sol.solution(p);


    }


}
