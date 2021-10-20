package programmers.level02.phoneNumList;

import java.util.HashMap;

public class PhoneNumberList_ffbear {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, 0);
        }

        System.out.println(map);
        boolean isValid = true;

        for (String key : map.keySet()) {

            for (int i = 0; i < phone_book.length; i++) {
                for (int j = 1; j < phone_book[i].length(); j++) {
                    if (map.containsKey(phone_book[i].substring(0, j))) {
                        isValid = false;
                    }
                }


            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = {"119", "97674223", "1195524421"};
        PhoneNumberList_ffbear sol = new PhoneNumberList_ffbear();
        sol.solution(phone_book);

    }
}
