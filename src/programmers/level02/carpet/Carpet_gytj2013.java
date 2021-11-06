package programmers.level02.carpet;

class Carpet_gytj2013 {
    public static int[] solution(int brown, int yellow) {
        int target = brown + yellow;
        int row = 3;
        int col = 3;

	    for(int i=1; i<yellow; i++) {
	    	if(yellow%i!=0) {continue;}
	        col = i+2;
	        row = yellow/i+2;
	        if(target == row*col) {break;}
	    }
     
        int[] answer = {row,col};
        
        return answer;
    }
}