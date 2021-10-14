package programmers.level02.maxFormula;

import java.util.ArrayList;
import java.util.List;

class MaxFormula_gytj2013 {
    public long solution(String expression) {
    	List<String> list = new ArrayList<String>();
  
    	int cnt = 0;
    	for(int i=0; i<expression.length(); i++) {
    		if("+-*".contains(expression.substring(i,i+1))) {
    			list.add(expression.substring(i-cnt,i));
    			cnt=0;
    			list.add(expression.substring(i,i+1));
    		}
    		else {cnt++;}   		
    	}
    	list.add(expression.substring(expression.length()-cnt));
    	
    	List<String> tmplist = new ArrayList<String>();
    	
    	tmplist.addAll(list);
    	
    	calc(tmplist, "+");
    	calc(tmplist, "-");
    	calc(tmplist, "*");
    	
    	long answer = Math.abs(Long.parseLong(tmplist.get(0)));
    
    	tmplist.clear();
    	tmplist.addAll(list);
    	
    	calc(tmplist, "+");
    	calc(tmplist, "*");
    	calc(tmplist, "-");
    	
    	answer = answer > Math.abs(Long.parseLong(tmplist.get(0))) ? answer : Math.abs(Long.parseLong(tmplist.get(0)));
    	
    	tmplist.clear();
    	tmplist.addAll(list);
    	
    	calc(tmplist, "-");
    	calc(tmplist, "+");
    	calc(tmplist, "*");
   	
    	answer = answer > Math.abs(Long.parseLong(tmplist.get(0))) ? answer : Math.abs(Long.parseLong(tmplist.get(0)));
   
    	tmplist.clear();
    	tmplist.addAll(list);
    	
    	calc(tmplist, "-");
    	calc(tmplist, "*");
    	calc(tmplist, "+");
  
    	answer = answer > Math.abs(Long.parseLong(tmplist.get(0))) ? answer : Math.abs(Long.parseLong(tmplist.get(0)));

    	tmplist.clear();
    	tmplist.addAll(list);
    	
    	calc(tmplist, "*");
    	calc(tmplist, "-");    	
    	calc(tmplist, "+");
  
    	answer = answer > Math.abs(Long.parseLong(tmplist.get(0))) ? answer : Math.abs(Long.parseLong(tmplist.get(0)));
    	
    	tmplist.clear();
    	tmplist.addAll(list);
    	
    	calc(tmplist, "*");
    	calc(tmplist, "+");
    	calc(tmplist, "-");    	
 
    	answer = answer > Math.abs(Long.parseLong(tmplist.get(0))) ? answer : Math.abs(Long.parseLong(tmplist.get(0)));
    	
        return answer;
    }
    private void calc(List<String> list, String operator) {
    	int idx = list.indexOf(operator);
    	while(idx!=-1) {
    		long tmp = Long.parseLong(list.get(idx-1));
    		if(operator=="+") {tmp += Long.parseLong(list.get(idx+1));}
    		else if(operator=="-") {tmp -= Long.parseLong(list.get(idx+1));}
    		else {tmp *= Long.parseLong(list.get(idx+1));}
    		for(int i=0; i<3; i++) {list.remove(idx-1);}
    		
    		list.add(idx-1, Long.toString(tmp));
    		idx = list.indexOf(operator);
    	}
	}
}