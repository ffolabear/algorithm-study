package programmers.level02.fatigue;

public class Fatigue_jola7373 {
    static boolean [] isVisit;
    static int max = 0;
    class Solution {

        public static int solution(int k, int[][] dungeons) {
            isVisit = new boolean[dungeons.length];
            dungeonCount(dungeons, k, 1);
            return max;
        }
        public static void dungeonCount(int[][] dungeons, int k, int depth){
            for(int i=0; i < dungeons.length; i++){
                if(!isVisit[i]){
                    isVisit[i] = true;
                    if(k >= dungeons[i][0]){
                        max = Math.max(max, depth);
                        dungeonCount(dungeons, k-dungeons[i][1],depth+1);
                    }
                    isVisit[i] = false;
                }
            }
        }
    }
}
