package programmers.level02.countryOf124;

class CountryOf124_gytj2013 {
    public static String solution(int n) {
    	String answer = "";
        String[] arr = {"4", "1", "2"};
       
        while(n > 0) {
        	answer = arr[n%3] + answer;
        	n = (n-1)/3;
        }
        return answer;
    }
}