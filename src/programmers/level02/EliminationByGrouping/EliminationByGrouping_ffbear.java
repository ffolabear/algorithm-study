package programmers.level02.EliminationByGrouping;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EliminationByGrouping_ffbear {

    public int solution(String s) {

        int answer = -1;
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            if (queue.isEmpty()) {
                queue.offer(s.charAt(i));
                System.out.println("queue : " + s.charAt(i));

            } else{
                if (queue.peek() == s.charAt(i)) {
                    System.out.println("같음");
                    System.out.println("queue : " + queue + " | 제거  - " + queue.peek());
                    queue.poll();
                }
                queue.offer(s.charAt(i));
                System.out.println("queqe : " + queue + " | 추가 : " + s.charAt(i));

            }
        }

        System.out.println();

        for (int i = 0; i < s.length(); i++) {

            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                System.out.println("stack : " + s.charAt(i));

            } else{
                if (stack.peek() == s.charAt(i)) {
                    System.out.println("같음");
                    System.out.println("stack : " + stack + " | 제거  - " + stack.peek());
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                    System.out.println("stack : " + stack + " | 추가 : " + s.charAt(i));
                }
            }
        }


        if (queue.isEmpty()) {
            answer = 1;
        } else {
            answer =  0;
        }

        return answer;
    }


    public static void main(String[] args) {
        String s = "baabaa";
        EliminationByGrouping_ffbear sol = new EliminationByGrouping_ffbear();
        sol.solution(s);


    }

}
