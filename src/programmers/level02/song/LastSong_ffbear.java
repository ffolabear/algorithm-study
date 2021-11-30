package programmers.level02.song;

public class LastSong_ffbear {

    public String solution(String m, String[] musicinfos) {

        int maxTime = 0;
        m = convert(m);
        String answer = "(None)";

        for (int i = 0; i < musicinfos.length; i++) {

            String[] info = musicinfos[i].split(",");

            //노래제목
            String title = info[2];

            //악보
            String melody = convert(info[3]);

            //시작시간
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");

            int playHour = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60;
            int playMin = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
            int playTime = playHour + playMin;

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < playTime; j++) {
                sb.append(melody.charAt(j % melody.length()));
            }

            System.out.println(sb);
            System.out.println(sb.toString().contains(m));

            if (sb.toString().contains(m)) {


                if (maxTime < sb.length()) {
                    maxTime = sb.length();
                    answer = title;
                }
            }


        }


        return answer;
    }

    static String convert(String melody) {
        melody = melody.replaceAll("A#", "a");
        melody = melody.replaceAll("C#", "c");
        melody = melody.replaceAll("D#", "d");
        melody = melody.replaceAll("F#", "f");
        melody = melody.replaceAll("G#", "g");

        return melody;
    }


    public static void main(String[] args) {

//        String m = "ABCDEFG";
//        String[] musininfo = {
//                "12:00,12:14,HELLO,CDEFGAB",
//                "13:00,13:05,WORLD,ABCDEF"};

        String m = "ABC";
        String[] musininfo = {
                "12:00,12:02,HELLO,ABCDEF"};

//        String m = "CC#BCC#BCC#BCC#B";
//        String[] musininfo = {"03:00,03:30,FOO,CC#B",
//                              "04:00,04:08,BAR,CC#BCC#BCC#B"};

//        String m = "ABC";
//        String[] musininfo = {"12:00,12:14,HELLO,C#DEFGAB",
//                              "13:00,13:05,WORLD,ABCDEF"};


        LastSong_ffbear sol = new LastSong_ffbear();
        sol.solution(m, musininfo);

    }
}
