package programmers.level02.conquestGround;

class ConquestGround_gytj2013 {
    static int solution(int[][] land) {
    	int len = land.length;
    	
        for(int i=1; i<len; i++) {
        	land[i][0] = land[i][0] + Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
        	land[i][1] = land[i][1] + Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
        	land[i][2] = land[i][2] + Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
        	land[i][3] = land[i][3] + Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        len--;
        
        int answer = Math.max(Math.max(land[len][0], land[len][1]), Math.max(land[len][2], land[len][3]));
        
        return answer;
    }
}