package programmers.level02.distanceCheck;

class DistanceCheck_gytj2013 {
    public static int[] solution(String[][] places) {
    	String[][] room = new String[5][5];
    	int[] answer = new int[5];

    	for(int i=0; i<5; i++){
    		for(int j=0; j<5; j++) {
    			room[j] = places[i][j].split("");
    		}
    		answer[i] = check(room);
    	}
 
        return answer;
    }
    private static Integer check(String[][] room) {
    	for(int a=0; a<5; a++) {
			for(int b=0; b<5; b++) {
				//System.out.println(room[a][b]);
				if(room[a][b].equals("P")) {
					//System.out.println(room[a][b]);
					if(b<4) {
						if(room[a][b+1].equals("P")) {System.out.print("(1)");return 0;}
					}
					if(b<3) {
						if(!room[a][b+1].equals("X") & room[a][b+2].equals("P")) {System.out.print("(2)");return 0;}
					}
					if(a<4) {
						if(room[a+1][b].equals("P")) {System.out.print(a+b);return 0;}
						if(b>0) {
							if(room[a+1][b-1].equals("P")) {
								if(!room[a+1][b].equals("X") || !room[a][b-1].equals("X")) {System.out.print("(3)");return 0;}
							}
						}
						if(b<4) {
							if(room[a+1][b+1].equals("P")) {
								if(!room[a+1][b].equals("X") || !room[a][b+1].equals("X")) {System.out.print("(4)");return 0;}
							}
						}
					}
					if(a<3) {
						if(!room[a+1][b].equals("X") & room[a+2][b].equals("P")) {System.out.print("(5)");return 0;}
					}
				}
			}
		}
		return 1;
	}
}
