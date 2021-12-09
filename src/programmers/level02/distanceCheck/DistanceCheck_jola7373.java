package programmers.level02.distanceCheck;

import java.util.Arrays;

public class DistanceCheck_jola7373 {
    public static void main(String[] args) {
        String [][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int [] a = solution(places);
        System.out.println(Arrays.toString(a));
    }
    public static int[] solution(String[][] places) {
        //체크해야되는 반경
        int[] answer = new int [5];
        for(int i=0; i < 5; i++){
            answer[i] =(distanceCheck(places[i])) ? 1 : 0;
        }
        return answer;
    }
    public static boolean distanceCheck(String[] place){
        String[][] map = new String[5][5];
        int x=0;
        int y=0;
        //map 초기화
        for(int i=0; i< place.length; i++){
            map[i] = place[i].split("");
        }
        for(int i=0; i < 5; i++){
            for(int j=0;j < 5; j++){//map에 있는 값 하나씩
                x = i;
                y = j;
                if(map[x][y].equals("P")){//만약 사람이라면 매너턴 확인
                    int nx = x;
                    int ny = y;

                    //상하좌우 확인
                    int dx[] = {0,0,-1,1};
                    int dy[] = {-1,1,0,0};
                    for(int s=0; s< dx.length;s++){
                        nx = x + dx[s];
                        ny = y + dy[s];
                        //nx와 ny가 시험장의 범위를 넘지 않았는지 확인
                        if(nx >= 0 && nx < 5 && ny >=0 && ny < 5){
                            if(map[nx][ny].equals("P")){
                                return false;
                            }
                        }
                    }

                    //2칸씩 떨어진곳 확인
                    int dx1 []= {0,0,2,-2};
                    int dy2 []= {2,-2,0,0};
                    for(int s=0; s< dx.length; s++){
                        nx = x + dx1[s];
                        ny = y + dy2[s];
                        //nx와 ny가 시험장의 범위를 넘지 않았는지 확인
                        if(nx >= 0 && nx < 5 && ny >=0 && ny < 5){
                            if(map[nx][ny].equals("P")){//2칸씩 떨어진 곳에 사람이 존재하면
                                if(nx+dx[s] >= 0 && nx+dx[s] < 5 && ny+dy[s] >=0 && ny+dy[s] < 5){
                                    if(map[nx+dx[s]][ny+dy[s]].equals("O")){
                                        //nx+dx[i] = 2칸 떨어진 곳과 x의 사이를 확인
                                        return false;
                                    }
                                }
                            }
                        }
                    }

                    //대각선
                    int dx3 []= {1,1,-1,-1};
                    int dy4 []= {-1,1,1,-1};
                    for(int s=0; s< dx.length;s++){
                        nx = x + dx3[s];
                        ny = y + dy4[s];
                        //nx와 ny가 시험장의 범위를 넘지 않았는지 확인
                        if(nx >= 0 && nx < 5 && ny >=0 && ny < 5){
                            if(map[nx][ny].equals("P")){//대각선에 사람이 존재하면
                                if(map[nx][y].equals("O") || map[x][ny].equals("O")){
                                    //그 사이에 있는 좌석들이 둘다 패티션이여야함
                                    return false;
                                }

                            }
                        }
                    }

                }
            }
        }
        return true;
    }
}
