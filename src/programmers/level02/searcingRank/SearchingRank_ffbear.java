package programmers.level02.searcingRank;

import java.util.*;

public class SearchingRank_ffbear {

    static List<Map.Entry<Integer, ArrayList<String>>> covt;
    static String[][] questions;

    public int[] solution(String[] info, String[] query) {

        questions = new String[query.length][];
        int[] answer = new int[query.length];

        Map<Integer, ArrayList<String>> init = new HashMap<>();

        for (int i = 0; i < info.length; i++) {
            String[] temp = info[i].split(" ");

            ArrayList<String> list = new ArrayList<>();
            list.add(temp[0]);
            list.add(temp[1]);
            list.add(temp[2]);
            list.add(temp[3]);

            init.put(Integer.parseInt(temp[4]), list);

        }

        covt = new ArrayList<Map.Entry<Integer, ArrayList<String>>>(init.entrySet());
        covt.sort(new Comparator<Map.Entry<Integer, ArrayList<String>>>() {

            @Override
            public int compare(Map.Entry<Integer, ArrayList<String>> o1, Map.Entry<Integer, ArrayList<String>> o2) {

                return o1.getKey().compareTo(o2.getKey());
            }
        });


        for (int i = 0; i < query.length; i++) {
            String temp = query[i].replaceAll(" and ", " ");
            questions[i] = temp.split(" ");
        }

        //---------------------------------------------------------------

        for (int i = 0; i < questions.length; i++) {
            for (int j = 0; j < questions[i].length; j++) {
                System.out.print(questions[i][j] + " ");
            }
            System.out.println();
        }

        //---------------------------------------------------------------

        binsearch();

        return answer;
    }

    static int binsearch() {

        System.out.println(covt);

        System.out.println(questions[0][0]);

        return 0;
    }

    public static void main(String[] args) {


        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};


        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        SearchingRank_ffbear sol = new SearchingRank_ffbear();
        sol.solution(info, query);

    }
}
