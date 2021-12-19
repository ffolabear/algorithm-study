package programmers.level03.brian;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Brian_ffbear {

    public String solution(String sentence) {

        StringBuilder answerList = new StringBuilder();

        //사용된 소문자들을 기록 - 입력 순서를 보장할 수 있음
        LinkedHashMap<Character, ArrayList<Integer>> lowercount = new LinkedHashMap<>();

        try {
            int size = sentence.length();

            for (int i = 0; i < size; i++) {

                char c = sentence.charAt(i);

                //만약 현재 문자가 기호라면
                if (Character.isLowerCase(c)) {
                    //만약 사용된 소문자(기호)가 목록에 없다면 추가해줌
                    if (!lowercount.containsKey(c)) {
                        lowercount.put(c, new ArrayList<Integer>());
                    }
                    //만약 이미 사용된 기호라면 가은 단어이므로 인덱스를 기록해줌
                    lowercount.get(c).add(i);
                }
            }

            int stringIdx = 0;

            //기호 시작, 끝 인덱스
            int startChar, endChar;

            //대문자 시작, 끝 인덱스
            int startWord = 0, endWord = 0;

            int lastStartChar = -1, lastEndChar = -1;

            int lastStartWord = -1, lastEndWord = -1;
            int count, distance;
            int rule = 0;

            ArrayList<Integer> temp;

            //사용한 기호들 순회
            for (char c : lowercount.keySet()) {
                temp = lowercount.get(c);
                //규칙을 적용한 단어의 길이
                count = temp.size();
                //해당 단어의 첫 인덱스
                startChar = temp.get(0);
                //해당 단어의 끝 인덱스
                endChar = temp.get(count - 1);

                //AaA, AaAaAaA...
                //사용한 기호가 2개가 아니라면 규칙 1인지 2인지 판단해봐야한다.
                if (count == 1 || count >= 3) {
                    for (int i = 1; i < count; i++) {

                        //규칙 1 이 적용되었다면 기호를 쓴 인덱스와 인덱스 사이의 거리가 2일수밖에 없음
                        if (temp.get(i) - temp.get(i - 1) != 2) {
                            return "invalid";
                        }

                        //그렇지 않다면 첫번째 규칙을 적용한것.

                    }
                    rule = 1;
                    //규칙 2인 경우
                } else if (count == 2) {
                    distance = endChar - startChar;

                    //기호를 2개만 썼음에도 규칙1일 경우가 있으므로 판별해줌
                    // -> 기호사이의 거리가 2이며, 기호의 시작과 끝이 정상인 경우
                    if (distance == 2 && (endChar < lastEndChar && startChar > lastStartChar)) {
                        rule = 1;

                        // 규칙2는 첫글자와 끝글자에만 기호를 넣으므로 거리가 2보타 클것이다.
                    } else if (distance >= 2) {
                        rule = 2;

                        //규칙에서 벗어남경우 - 기호가 연속으로 오는 경우
                    } else {
                        return "invalid";
                    }
                }

                //단어에 적용된 규칙을 찾았으므로 변수값을 업데이트한다.
                if (rule == 1) {

                    //정상 단어가 있는 위치
                    startWord = startChar - 1;
                    endWord = endChar + 1;

                    //이전 단어 안에 포함되어 있는 경우
                    if (lastStartWord < startWord && lastEndWord > endWord) {
                        //규칙 2 아니면 안됨
                        if (startChar - lastStartChar == 2 && lastEndChar - endChar == 2) {
                            continue;
                        } else {
                            return "invalid";
                        }
                    }
                } else if (rule == 2) {
                    //시작과 끝의 인덱스만 알면된다.
                    startWord = startChar;
                    endWord = endChar;
                    //규칙 2는 중복되면 안됨
                    if (lastStartWord < startWord && lastEndWord > endWord) {
                        return "invalid";
                    }

                }

                if (lastEndWord >= startWord) {
                    return "invalid";
                }

                //소문자 등장 이전에 존재하던 앞의 단어 추가
                if (stringIdx < startWord) {
                    answerList.append(makeWord(sentence, stringIdx, startWord - 1));
                    answerList.append(" ");
                }
                //변환한 단어넣어줌
                answerList.append(makeWord(sentence, startWord, endWord));
                answerList.append(" ");

                //단어검색한뒤에 다음 단어 검색을 위한 변수값 업데이트
                lastStartWord = startWord;
                lastEndWord = endWord;
                lastStartChar = startChar;
                lastEndChar = endChar;
                stringIdx = endWord + 1;



            }

            //뒤에 남는 단어들도 더하기
            if (stringIdx < size) {
                answerList.append(makeWord(sentence, stringIdx, size - 1));
            }

        } catch (Exception e) {
            return "invalid";
        }


        return answerList.toString().trim();
    }

    public String makeWord(String sentence, int start, int end) {
        String word = sentence.substring(start, end + 1);
        return word.replaceAll("[a-z]", "");
    }

    public static void main(String[] args) {

//        String sentence = "HaEaLaLaObWORLDb";
        String sentence = "HaEaLaLa";
        Brian_ffbear sol = new Brian_ffbear();
        sol.solution(sentence);

    }
}

