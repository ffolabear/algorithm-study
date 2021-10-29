package programmers.level02.searcingRank;

import java.util.*;

class SearchingRank_gytj2013 {
    static HashMap<String,ArrayList<Integer>>map = new HashMap<>();
    public static int[] solution(String[] info, String[] query) {
        int[] answer;
        answer = new int[query.length];
 
        for(String in : info) {
            String[] tmp = in.split(" ");
            int score = Integer.parseInt(tmp[4]);
            dfs(0,"",tmp,score);
        }
        
     
        for(String key: map.keySet()) {
            ArrayList<Integer>tmp = map.get(key);
            Collections.sort(tmp);
        }
        
        for(int i=0; i<query.length; i++) {
            String str = "";
            String[] tmp = query[i].replace(" and ", " ").split(" ");
 
            str = tmp[0]+tmp[1]+tmp[2]+tmp[3];
     
            int score = Integer.parseInt(tmp[4]);
            if(map.containsKey(str)) {
                ArrayList<Integer> list= map.get(str);
                answer[i] = lower_bound(list,score);
            }
        }
  
        return answer;
    }
    public static int lower_bound(ArrayList<Integer>list, int score) {
        int start = 0;
        int end = list.size();
    
        while(start<end) {
            int mid = (start+end)/2;
            if(list.get(mid)>=score) {
                end = mid;
            }
            else {
                start = mid+1;
            }
        }
        return list.size()-end;
    }
    public static void dfs(int level, String str,String[] tmp, int score) {
        if(level==4) {
            ArrayList<Integer>list = new ArrayList<>();
            if(map.containsKey(str)) {
                list = map.get(str);
            }
            list.add(score);
            map.put(str, list);
            return ;
        }
        dfs(level+1,str+tmp[level],tmp,score);
        dfs(level+1,str+"-",tmp,score);
    }
}