package programmers.level03.thanksGivingTraffic;

public class ThanksGivingTraffic_ffbear {

    public int solution(String[] lines) {

        int answer = 0;
        int[] cnt = new int[lines.length];

        for (int i = 0; i < lines.length; i++) {

            lines[i] = lines[i].substring(11).replace(":", "").replace("s", "");

            int sec = Integer.parseInt(lines[i].substring(0, 2)) * 3600 +
                    Integer.parseInt(lines[i].substring(2, 4)) * 60 +
                    Integer.parseInt(lines[i].substring(4, 6));

            lines[i] = sec + lines[i].substring(6);

        }

        double end;

        for (int j = 0; j < lines.length; j++) {
            String[] time = lines[j].split(" ");

            end = Double.parseDouble(time[0]);
            double area = end + 1;

            for (int k = j; k < lines.length; k++) {
                String[] compare = lines[k].split(" ");

                double start = Double.parseDouble(compare[0]) - Double.parseDouble(compare[1]) + 0.001;
                if (start < area) {
                    cnt[j]++;
                }


            }


        }

        for (int i = 0; i < cnt.length; i++) {
            answer = Math.max(answer, cnt[i]);
        }


        return answer;
    }


    public static void main(String[] args) {

//        String[] lines = {
//                "2016-09-15 01:00:04.001 2.0s",
//                "2016-09-15 01:00:07.000 2s"
//        };

        String[] lines = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        ThanksGivingTraffic_ffbear sol = new ThanksGivingTraffic_ffbear();
        sol.solution(lines);


    }
}
