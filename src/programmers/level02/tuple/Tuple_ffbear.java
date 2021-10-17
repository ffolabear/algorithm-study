package programmers.level02.tuple;

public class Tuple_ffbear {

    public String[] solution(String s) {

        String[] answer = {};

        String regex = "[{]";
        String covt = s.replaceAll(regex, "");
        String[] nums = covt.split("}");

        String[][] strArr = new String[nums.length][];

        int maxLength = nums[0].length();


        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, nums[i].length());
        }

        String longest = "";

        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length() == maxLength) {
                longest = nums[i];

            }
        }

        longest = longest.substring(1, longest.length());
        System.out.println(longest);

        answer = longest.split(",");


        return answer;
    }

    public static void main(String[] args) {

        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        Tuple_ffbear sol = new Tuple_ffbear();
        sol.solution(s);

    }
}
