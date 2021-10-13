package programmers.level02.openChatRoom;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatRoom_jola7373 {
    class Solution {
        public String[] solution(String[] record) {
            ArrayList<String>ans = new ArrayList<>();
            HashMap<String, String> map = new HashMap();

            for(int i=0; i<record.length; i++){
                String[] oneRecord = record[i].split(" ");
                if(oneRecord[0]=="Enter"){
                    ans.add(oneRecord[1]+"님이 들어왔습니다.");
                    map.put(oneRecord[1], oneRecord[2]);
                }else if(oneRecord[0] == "Leave"){
                    ans.add(oneRecord[1]+"님이 나갔습니다.");
                }else{
                    map.put(oneRecord[1],oneRecord[2]);
                }
            }
            String[] answer = new String[ans.size()];
            for(int i=0; i<ans.size(); i++){
                int name = ans.get(i).indexOf("님");
                String uid = ans.get(i).substring(0,name);
                ans.set(i,ans.get(i).replace(uid, map.get(uid)));
                answer[i] = ans.get(i);
            }
            return answer;
        }

    }
}
