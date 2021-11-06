package programmers.level01.pressKeypad;
import java.util.*;

class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class PressKeypad_carnival77 {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        Point left = new Point(3, 0);
        Point right = new Point(3, 2);

        for (int n : numbers) {
            int x = n / 3;
            if (n == 1 || n == 4 || n == 7) {
                left = new Point(x, 0);
                answer += "L";
            } else if (n == 3 || n == 6 || n == 9) {
                right = new Point(x - 1, 2);
                answer += "R";
            } else {
                if (n == 0) x = 3;
                int left_dist = Math.abs(left.x - x) + Math.abs(left.y - 1);
                int right_dist = Math.abs(right.x - x) + Math.abs(right.y - 1);
                if (left_dist > right_dist) {
                    right = new Point(x, 1);
                    answer += "R";
                } else if (left_dist < right_dist) {
                    left = new Point(x, 1);
                    answer += "L";
                } else {
                    if (hand.equals("left")) {
                        left = new Point(x, 1);
                        answer += "L";
                    } else {
                        right = new Point(x, 1);
                        answer += "R";
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        PressKeypad_carnival77 sol = new PressKeypad_carnival77();
        System.out.println(sol.solution(numbers,hand));
    }
}

// solution 2 : 0부터 9까지 좌표를 초기에 설정한 뒤 왼손과 오른손 위치를 업데이트하며 풀이
class Solution {
    //        0부터 9까지 좌표 {y,x}
    int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    //초기 위치
    int[] leftPos = {3,0};
    int[] rightPos = {3,2};
    String hand;
    public String solution(int[] numbers, String hand) {
        this.hand = (hand.equals("right")) ? "R" : "L";

        String answer = "";
        for (int num : numbers) {
            String Umji = pushNumber(num);
            answer += Umji;

            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
        }
        return answer;
    }

    //num버튼을 누를 때 어디 손을 사용하는가
    private String pushNumber(int num) {
        if(num==1 || num==4 || num==7) return "L";
        if(num==3 || num==6 || num==9) return "R";

        // 2,5,8,0 일때 어디 손가락이 가까운가
        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";

        //같으면 손잡이
        return this.hand;
    }

    //해당 위치와 번호 위치의 거리
    private int getDist(int[] pos, int num) {
        return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
    }
}