package programmers.level02.joystick;
import java.util.ArrayList;

class Joystick_gytj2013{
    public static int solution(String name) {
    	ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;
        int listSize = 0;

        for(int i=0; i<name.length(); i++) {
        	int dif = 0;
        	if(name.charAt(i)!='A') {
        		if(i!=0) {
        		list.add(i);
        		listSize++;}
        		dif = name.charAt(i) - 'A' < 'Z'-name.charAt(i)+1 ? name.charAt(i) - 'A' : 'Z'-name.charAt(i)+1;
        		answer += dif;
        	}
        }

		if (listSize != 0) {
			int forward = list.get(listSize - 1);
			int backward = name.length() - list.get(0);
			int min = forward < backward ? forward : backward;
			forward =0;
			backward =0;
			for (int i = 0; i < listSize; i++) {
				if (list.get(i) < name.length() / 2) {
					forward=list.get(i);
				} else {
					backward =name.length() - list.get(i);
					break;
				}
			}
			int forback = forward * 2 + backward < backward * 2 + forward ? forward * 2 + backward : backward * 2 + forward;
			min = min < forback ? min : forback;
			answer += min;
		}
        return answer;
    }
}
