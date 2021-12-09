package programmers.level02.maxAndMin;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import static java.util.stream.Collectors.toList;

public class MaxAndMin_jola7373 {
    public String solution(String s) {

        List<Integer> ints = Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        String answer = "";
        answer+= Collections.min(ints);
        answer+= " " + Collections.max(ints);

        return answer;
    }
}
