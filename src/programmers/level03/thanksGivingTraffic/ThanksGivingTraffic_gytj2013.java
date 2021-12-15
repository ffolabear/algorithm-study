package programmers.level03.thanksGivingTraffic;

class ThanksGivingTraffic_gytj2013 {
    public static int solution(String[] lines) {
    	int len = lines.length;
    	double[][] calc = new double[len][2];
    	
        int answer = 0;
        
        for(int i=0; i<len; i++) {
        	String[] tmp = lines[i].split(" ");
        	String[] time = tmp[1].split(":");
        	double end = Double.parseDouble(time[2]);
        	end += Integer.parseInt(time[1])*60;
        	end += Integer.parseInt(time[0])*60*60;
 
        	double t = Double.parseDouble((tmp[2].substring(0,tmp[2].length()-1)));
        	
        	calc[i][0] = end - t;
        	calc[i][1] = end;
        }
        
        for(int i=0; i<len; i++) {
        	int cnt = 1;
        	double target = calc[i][1]-0.001;
        	for(int j=i+1; j<len; j++) {
        		if(target+1 <= calc[j][0]) {continue;}
        		if(target >= calc[j][1]) {continue;}
        		cnt++;
        	}
        	//System.out.println(cnt);
        	answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}