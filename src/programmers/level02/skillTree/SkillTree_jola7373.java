package programmers.level02.skillTree;

import java.util.HashMap;
import java.util.Map;

public class SkillTree_jola7373 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        boolean check = true;
        for(int i =0; i < skill.length(); i++){
            map.put(skill.charAt(i),i);
        }
        for(int i=0; i < skill_trees.length; i++){
            int idx=0;
            int temp=0;
            while(true){
                if(idx >= skill_trees[i].length()){
                    break;
                }
                if(map.containsKey(skill_trees[i].charAt(idx))){
                    if(temp != map.get(skill_trees[i].charAt(idx))){
                        check = false;
                        break;
                    }
                    temp++;
                }
                idx++;
            }
            if(check == true){
                answer++;
            }check = true;
        }
        return answer;
    }
}
