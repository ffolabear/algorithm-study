package programmers.level02.skillTree;

import java.util.HashMap;

public class SkillTree_ffbear {

    public int solution(String skill, String[] skill_trees) {

        HashMap<Character, Integer> skillOrder = new HashMap<>();

        int order = 1;
        for (int i = 0; i < skill.length(); i++) {
            skillOrder.put(skill.charAt(i), order++);

        }

        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {

            if (isValid(skill_trees[i], skillOrder)) {
                answer++;
            }

        }

        System.out.println(answer);
        return answer;
    }

    static boolean isValid(String skill, HashMap<Character, Integer> skillOrder) {


        int last = 0;

        for (int i = 0; i < skill.length(); i++) {

            if (skillOrder.containsKey(skill.charAt(i))) {

                if (last > skillOrder.get(skill.charAt(i))) {
                    return false;
                }

                if (last == 0 && skillOrder.get(skill.charAt(i)) > 1) {
                    return false;
                }

                if (skillOrder.get(skill.charAt(i)) - last > 1) {
                    return false;
                }

                last = skillOrder.get(skill.charAt(i));

            }


        }
        return true;
    }

    public static void main(String[] args) {

//        String skill = "CBD";
//        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        String skill = "BDC";
        String[] skill_trees = {"AAAABACA"};

        SkillTree_ffbear sol = new SkillTree_ffbear();
        sol.solution(skill, skill_trees);

    }
}
