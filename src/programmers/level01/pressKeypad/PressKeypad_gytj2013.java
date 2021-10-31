package programmers.level01.pressKeypad;

class PressKeypad_gytj2013{
	static class Point {
        int x;int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static String solution(int[] numbers, String hand) {
    	Point locL = new Point(3,0);
    	Point locR = new Point(3,2);
    	String answer = "";
    	 
    	for(int i=0; i<numbers.length;i++) {
    		int target = numbers[i];
    		int x = target/3;
    		if(target == 1 | target == 4 | target == 7) {
    			answer += "L";
    			locL.x = x;
    			locL.y=0;
    		}else if(target == 3 | target == 6 | target == 9) {
    			answer += "R";
    			locR.x = x-1;
    			locR.y=2;
    		}else {
    			if(target==0) {x=3;}
    			if(Math.abs(locL.x-x) + Math.abs(locL.y-1) < Math.abs(locR.x-x) + Math.abs(locR.y-1)) {
    				answer += "L";
    				locL.x = x;
        			locL.y=1;
    			}else if((Math.abs(locL.x-x) + Math.abs(locL.y-1) > Math.abs(locR.x-x) + Math.abs(locR.y-1))){
    				answer += "R";
    				locR.x = x;
        			locR.y=1;
    			}else {
    				if(hand.equals("right")) {
    					answer += "R";
    					locR.x = x;
    	    			locR.y=1;
    				}
    				else {
    					answer += "L";
    					locL.x = x;
            			locL.y=1;
    				}
    			}
    		}
    	}
   
        return answer;
    }
}