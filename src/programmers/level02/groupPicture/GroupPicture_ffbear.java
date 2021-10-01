package programmers.level02.groupPicture;

import java.util.HashMap;

public class GroupPicture_ffbear {

    static String[] condition;
    static HashMap<Character, Integer> friend;
    static boolean[] visited;
    static int[] test;
    static int answer;

    public int solution(int n, String[] data) {

        condition = data;
        visited = new boolean[8];
        test = new int[8];
        answer = 0;
        friend = new HashMap<Character, Integer>();

        friend.put('A', 0);
        friend.put('C', 1);
        friend.put('F', 2);
        friend.put('J', 3);
        friend.put('M', 4);
        friend.put('N', 5);
        friend.put('R', 6);
        friend.put('T', 7);

        //0번에 사람을 넣으면서 시작
        dfs(0);


        return answer;
    }

    static void dfs(int idx) {

        if (idx == 8) {
            if (isValid()) {
                answer++;
            }
        } else if (idx < 8) {

            for (int i = 0; i < 8; i++) {
                //방문하지 않았따면 방문 처리
                if (!visited[i]) {
                    visited[i] = true;
                    //테스트 케이스에 전달받은 사람에 순서 값을 넣음
                    test[idx] = i;


                    dfs(idx + i);

                    //탐색이 끝났으면 미방문 처리
                    visited[i] = false;
                }


            }
        }


    }

    static boolean isValid() {

        //test[사람 순서] = friend 배열의 사람 인덱스 번호
        int a, b, distance;
        char compare;

        for (String s : condition) {
            a = test[friend.get(s.charAt(0))];
            b = test[friend.get(s.charAt(2))];
            compare = s.charAt(3);
            distance = s.charAt(4) - '0' + 1;

            if(compare == '='){
                if(Math.abs(a-b)!=distance){
                    return false;
                }
            } else if(compare == '>'){
                if(Math.abs(a-b) <= distance) {
                    return false;
                }

            } else {
                if(Math.abs(a-b) >= distance){
                    return false;
                }
            }
        }

        return true;

    }


    public static void main(String[] args) {

        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
//        String[] data = {"M~C<2", "C~M>1"};

        GroupPicture_ffbear sol = new GroupPicture_ffbear();
        sol.solution(n, data);


    }
}
