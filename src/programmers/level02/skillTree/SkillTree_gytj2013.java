package programmers.level02.skillTree;

class SkillTree_gytj2013 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String tree : skill_trees) {
        	if(chk(tree, skill)) {answer++;}
        }
        
        return answer;
    }
    private static Boolean chk(String tree, String skill) {
    	boolean find = false;
    	for(int i=skill.length()-1; i>=0; i--) {
	       	char target = skill.charAt(i);
	       	int idx = tree.indexOf(target);
	       	if(idx==-1) {
	       		if(find) { return false; }
	       		else {continue;}
	       	}
	       	else {
	       		find = true;
	       		tree=tree.substring(0,idx+1);
	       	}
    	}
    	return true;
	}
}
