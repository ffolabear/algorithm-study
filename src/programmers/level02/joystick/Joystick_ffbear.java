package programmers.level02.joystick;

public class Joystick_ffbear {

    public int solution(String name) {

        int answer = 0;
        int length = name.length();
        int move = length - 1;

        for (int i = 0; i < length; i++) {

            if (name.charAt(i) > 'N') {
                answer += 'Z' - name.charAt(i) + 1;
            } else {
                answer += name.charAt(i) - 'A';
            }

            int numA = i + 1;
            while (numA < length && name.charAt(numA) == 'A') {
                numA++;
            }
            move = Math.min(move, i + length - numA + i);

        }
        answer += move;


        return answer;
    }

    public static void main(String[] args) {

        String name = "JAAAAAN";

        Joystick_ffbear sol = new Joystick_ffbear();
        sol.solution(name);

    }
}
