package programmers.level02.NormalSquare;

public class NormalSquare_jola7373 {
    class Solution {
        public long solution(int w, int h) {
            long gcp = findGcp(w,h);
            long answer = (long)w*h -((w/gcp + h/gcp)-1)*gcp;
            return answer;
        }

        public long findGcp(int w, int h){
            int lim = 0;
            int gcp=1;
            if(w>h){lim = h;}
            else{lim=w;}
            for(int i = 2; i<= lim; i++){
                if(w%i==0 & h%i==0){
                    gcp = i;
                }
            }
            return gcp;
        }
    }
}
