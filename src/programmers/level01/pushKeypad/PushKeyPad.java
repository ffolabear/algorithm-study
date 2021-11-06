package programmers.level01.pushKeypad;

import programmers.level02.findPrimeNum.FindPrimeNum_carnival77;

import javax.swing.*;
import java.util.*;

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class PushKeyPad {

    public static int[][] phone = new int[4][3];

    public String solution(int[] numbers, String hand) {
        String answer = "";

        int num=1;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                phone[i][j] = num;
                num += 1;
            }
        }
        phone[3][0] = -1;
        phone[3][1] = 0;
        phone[3][2] = -2;

        int left=0;
        int right=0;

        for(int n : numbers){
            if (n == 1 || n == 4 || n == 7){
                answer+='L';
                left=n;
            }
            if(n==3 || n==6 || n==9){
                answer+='R';
                right=n;
            }
            if(n==2 || n==5 || n==8|| n==0){
                int res = check(left,right,n,hand);
                if(res==2) {
                    answer += 'R';
                    right = n;
                }
                else{
                    answer += 'L';
                    left=n;
                }
            }
//            System.out.println(answer);
        }


        return answer;
    }

    public int check(int left, int right, int n,String hand){
        int result=0;
        Pair left_point = null;
        Pair right_point= null;
        Pair num_point = null;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(phone[i][j] == left){
                    left_point = new Pair(i,j);
                }
                if(phone[i][j] == right){
                    right_point = new Pair(i,j);
                }
                if(phone[i][j] == n){
                    num_point = new Pair(i,j);
                }
            }
        }

//        System.out.println(left);
//        System.out.println(right);
//        System.out.println(n);

        int l_n = Math.abs(left_point.x - num_point.x) + Math.abs(left_point.y - num_point.y);
        int r_n = Math.abs(right_point.x - num_point.x) + Math.abs(right_point.y - num_point.y);
        if(l_n > r_n){
            result  = 2;
        }
        if(l_n < r_n){
            result = 1;
        }
        if(l_n == r_n){
            if(hand.equals("right")) result = 2;
            if(hand.equals("left")) result=1;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        PushKeyPad sol = new PushKeyPad();
        System.out.println(sol.solution(numbers,hand));
    }
}
