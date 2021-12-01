package programmers.level02.sortFile;

import java.util.Arrays;
import java.util.Comparator;

public class SortingFile_ffbear {

    public String[] solution(String[] files) {

        String[][] divide = new String[files.length][3];


        for (int i = 0; i < files.length; i++) {

            divide(files[i]);

        }

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String[] str1 = divide(o1);
                String[] str2 = divide(o2);

                int headCompare = str1[0].compareTo(str2[0]);

                if (headCompare == 0) {
                    int numCompare = Integer.parseInt(str1[1]) - Integer.parseInt(str2[1]);
                    return numCompare;

                } else {
                    return headCompare;
                }
            }
        });


        return files;
    }

    static String[] divide(String file) {

        String head = "";
        String number = "";
        String remain = "";

        int index = 0;

        //substring 사용시 런타임 에러 발생함

        for (; index < file.length(); index++) {

            if (file.charAt(index) >= '0' && file.charAt(index) <= '9') {
                break;
            }
            head += file.charAt(index);

        }


        for (; index < file.length(); index++) {
            if (!(file.charAt(index) >= '0' && file.charAt(index) <= '9')) {
                break;
            }
            number += file.charAt(index);
        }


        for (; index < file.length(); index++) {

            remain += file.charAt(index);
        }


        System.out.println(head + " " + number + " " + remain);

        String[] res = {head.toLowerCase(), number, remain};

        return res;
    }

    public static void main(String[] args) {

//        String[] files = {
//
//                "img12.png",
//                "img10.png",
//                "img02.png",
//                "img1.png",
//                "IMG01.GIF",
//                "img2.JPG"
//
//        };

        String[] files = {

                "F-5 Freedom Fighter",
                "B-50 Superfortress",
                "A-10 Thunderbolt II",
                "F-14 Tomcat"

        };


        // 출력 예졔
        // {  "img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"}

        SortingFile_ffbear sol = new SortingFile_ffbear();
        sol.solution(files);

    }
}
