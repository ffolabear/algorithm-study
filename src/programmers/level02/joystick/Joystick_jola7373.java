package programmers.level02.joystick;

public class Joystick_jola7373 {
    class Solution {
        public int solution(String name) {
            int answer = 0;
            //가장짧은 거리는 좌우로 한쪽으로 이동할때
            int min_move = name.length()-1;
            for( int i=0; i< name.length(); i++){
                //A부터 차근차근 접근하는게 가까운지 아님 뒤에서 접근하면 더 빨리 도달할지
                answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
                int next = i+1;
                //다음이 A이면 이동이 없으니 계속 다음 글자로
                while(next<name.length() && name.charAt(next) =='A'){
                    next++;
                }
                min_move = Math.min(min_move, i+name.length()-next+i);
            }
            answer+=min_move;
            return answer;
        }
    }
}
