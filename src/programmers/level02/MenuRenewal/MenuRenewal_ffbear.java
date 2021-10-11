package programmers.level02.MenuRenewal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MenuRenewal_ffbear {

    static HashMap<String, Integer> map;
    static int m;

    public String[] solution(String[] orders, int[] course) {

        String[] answer = {};
        PriorityQueue<String> queue = new PriorityQueue<>();

        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            m = 0;

            for (int j = 0; j < orders.length; j++) {
                find(0, "", course[i], 0, orders[j]);
                System.out.println(map);
            }

            for (String s : map.keySet()) {
                if (map.get(s) == m && m > 1) {
                    queue.offer(s);
                }
            }
        }

        String[] ans = new String[queue.size()];
        int k = 0;
        while (!queue.isEmpty()) {
            ans[k++] = queue.poll();
        }

        return ans;
    }

    static void find(int length, String str, int courseLen, int idx, String word) {

        if (length == courseLen) {
            char[] currentOrder = str.toCharArray();
            Arrays.sort(currentOrder);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < currentOrder.length; i++) {
                sb.append(currentOrder[i]);
            }


            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            m = Math.max(m, map.get(sb.toString()));
            return;
        }

        for (int i = idx; i < word.length(); i++) {
            char now = word.charAt(i);
            find(length + 1, str + now, courseLen, i + 1, word);
        }

    }


    public static void main(String[] args) {

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        MenuRenewal_ffbear sol = new MenuRenewal_ffbear();
        sol.solution(orders, course);

    }
}
