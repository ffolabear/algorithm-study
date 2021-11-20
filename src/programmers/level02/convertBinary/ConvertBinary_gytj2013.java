package programmers.level02.convertBinary;

class ConvertBinary_gytj2013 {
    public static int[] solution(String s) {
        int numTrans = 0;
        int numZero = 0;
        int origin = s.length();
        int newLen;
     
        while(s.length()>1) {
        	s = s.replace("0", "");
        	newLen = s.length();
        	numZero += origin - newLen;
        	s = Integer.toBinaryString(newLen);
        	origin = s.length();
        	numTrans++;
        }
    	
    	int[] answer = {numTrans, numZero};
        return answer;
    }
}