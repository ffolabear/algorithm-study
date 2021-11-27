package programmers.level02.lengthOfVisit;

public class LenghOfVisit_jola7373 {
    boolean [][][][] visit;
    int answer;

    public static void main(String[] args) {
        LenghOfVisit_jola7373 prob = new LenghOfVisit_jola7373();
        String dirs = "ULURRDLLU";
        System.out.println(prob.solution(dirs));
    }
    public int solution(String dirs) {
        answer = 0;
        visit= new boolean[11][11][11][11];
        int r_start=5,c_start=5, r_finish=5, c_finish=5;
        for(int i=0;i < dirs.length();i++){
            if(dirs.charAt(i) == 'U'){
                if(r_start+1 <= 10){
                    r_finish +=1;
                    change(r_start,c_start,r_finish,c_finish);
                    r_start = r_finish;
                }
            }
            if(dirs.charAt(i) == 'D'){
                if(r_start-1 >= 0){
                    r_finish -=1;
                    change(r_start,c_start,r_finish,c_finish);
                    r_start = r_finish;
                }
            }
            if(dirs.charAt(i) == 'R'){
                if(c_start+1 <= 10){
                    c_finish +=1;
                    change(r_start,c_start,r_finish,c_finish);
                    c_start = c_finish;
                }
            }
            if(dirs.charAt(i) == 'L'){
                if(c_start-1 >= 0){
                    c_finish -= 1;
                    change(r_start,c_start,r_finish,c_finish);
                    c_start = c_finish;
                }

            }
        }
        return answer;
    }
    public void change(int r_start,int c_start,int r_finish, int c_finish){
        if(!visit[r_start][c_start][r_finish][c_finish] && !visit[r_finish][c_finish][r_start][c_start]){
            visit[r_start][c_start][r_finish][c_finish] = true;
            visit[r_finish][c_finish][r_start][c_start] = true;
            answer++;
        }
    }
}
