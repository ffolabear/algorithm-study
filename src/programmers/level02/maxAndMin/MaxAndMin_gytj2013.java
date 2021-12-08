package programmers.level02.maxAndMin;

class MaxAndMin_gytj2013 {
    public static String solution(String s) {
    	String[] arr = s.split(" ");
    	int min=Integer.parseInt(arr[0]);
    	int max=Integer.parseInt(arr[0]);
    	
    	for(String n : arr) {
    		min = Math.min(min, Integer.parseInt(n));
    		max = Math.max(max, Integer.parseInt(n));
    	}
    	
        String answer = min+" "+max;
        return answer;
    }
}