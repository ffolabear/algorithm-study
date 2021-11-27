package programmers.level02.song;

class MusicInfo {
    String start, end, title;
    MusicInfo(String start, String end, String title) {
         this.start = start;
         this.end = end;
         this.title = title;
    }
    public int musicLen() {
    	int len = 0;
    	String[] st = start.split(":");
    	String[] en = end.split(":");
    	len = Integer.parseInt(en[0])*60+Integer.parseInt(en[1]);
    	len -= Integer.parseInt(st[0])*60+Integer.parseInt(st[1]);
    	return len;
    }
}

class Song_gytj2013 {
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int musicLen=0;
        int scoreLen=0;
        int max=0;
        
        if(m.contains("#")) {
    		m = change(m);
    	}
        int mLen = m.length();
        
        for(int i=0; i<musicinfos.length; i++) {
        	String[] arr = musicinfos[i].split(",");
        	String score = arr[3];
        	MusicInfo M = new MusicInfo(arr[0], arr[1], arr[2]);
        	musicLen = M.musicLen();
        	if(musicLen<mLen) {continue;}
        	if(max>=musicLen) {continue;}
        	if(score.contains("#")) {
        		score = change(score);
        	}
        	scoreLen = score.length();
        	if(scoreLen>musicLen) {
        		score = score.substring(0, musicLen);
        	}else if(scoreLen<musicLen) {
        		while(true) {
        			if(musicLen-scoreLen > scoreLen) {
        				score += score;
        				scoreLen *=2;
        			}else {
        				score += score.substring(0, musicLen-scoreLen);
        				break;
        			}
        		}
        	}
        	if(score.contains(m)) {
        		answer = arr[2];
        		max = musicLen;
        	}
        }
        return answer;
    }
    private static String change(String origin) {
    	String score = "";
    	int i;
		for(i=0; i<origin.length()-1; i++) {
			String s = origin.substring(i, i+1);
			if(origin.charAt(i+1)=='#') {
				score += s.toLowerCase();
				i++;
			}else {
				score += s;
			}
		}
		if(i==origin.length()-1) {
			score += origin.substring(i);
		}
		return score;
	}
}