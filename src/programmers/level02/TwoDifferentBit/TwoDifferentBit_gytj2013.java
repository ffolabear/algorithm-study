package programmers.level02.TwoDifferentBit;

class TwoDifferentBit_gytj2013{
    public static long[] solution(long[] numbers) {
    	int len = numbers.length;
        long[] answer = new long[len];
        
        for(int i=0; i<len; i++) {
        	answer[i] = func(numbers[i]);
		}
        return answer;
    }
    private static long func(long num) {
		String tmp = Long.toBinaryString(num);
		tmp = "0"+tmp;
    	
    	int idx = tmp.length()-1;
    	if(tmp.charAt(idx)=='0') {return num+1;}
    	idx--;
    	while(tmp.charAt(idx)!='0') {
    		idx--;
    	}
    	if(tmp.length() > 2) {
    		tmp = tmp.substring(0,idx)+"10"+tmp.substring(idx+2);
    	}else {return 2;}
   
		return Long.parseLong(tmp, 2);
	}
}