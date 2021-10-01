package programmers.level02.OpenChatRoom;

import java.util.HashMap;

class OpenChatRoom_gytj2013 {
    public static String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> usermap = new HashMap<String, String>();
        int cnt = 0;
        
        for(int i=0; i<record.length; i++) {
        	String[] tmp = record[i].split(" ");
        	switch(tmp[0]) {
        	case "Leave" :
        		cnt ++;
        		break;
        	case "Enter" :
        		cnt++;
        	default : //case "Enter" & "Change"
        		usermap.put(tmp[1], tmp[2]);
        		break;
        	}
        }
        
        answer = new String[cnt];
        cnt = 0;
        
        for(int i=0; i<record.length; i++) {
        	String[] tmp = record[i].split(" ");
        	switch(tmp[0]) {
        	case "Enter" :
        		answer[cnt] = usermap.get(tmp[1])+"님이 들어왔습니다.";
        		cnt++;
        		break;
        	case "Leave" :
        		answer[cnt] = usermap.get(tmp[1])+"님이 나갔습니다.";
        		cnt++;
        		break;
        	default : //case "Change"
        		break;
        	}
        }
        return answer;
    }
}