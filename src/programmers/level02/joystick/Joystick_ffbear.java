package programmers.level02.joystick;

public class Joystick_ffbear {

    public int solution(String name) {

        int answer = 0;
        int forward = 0;

        for (int i = 0; i < name.length(); i++) {

            int a = 0;

            if (name.charAt(i) == 'A') {
                for (int j = i; j < name.length(); j++) {
                    while (name.charAt(j) == 'A') {
                        a++;
                    }
                }


            } else {
                if (name.charAt(i) > 'N') {
                    forward += 'Z' - name.charAt(i) + 1;
                    System.out.println('Z' - name.charAt(i) + 1);
                }  else{
                    forward += name.charAt(i) - 'A';
                    System.out.println(name.charAt(i) - 'A');
                }

            }

            System.out.println("a : " + a);
        }
        forward += name.length() - 1;



        return answer;
    }

    public static void main(String[] args) {

        String name = "JAAAAAN";

        Joystick_ffbear sol = new Joystick_ffbear();
        sol.solution(name);

    }
}
