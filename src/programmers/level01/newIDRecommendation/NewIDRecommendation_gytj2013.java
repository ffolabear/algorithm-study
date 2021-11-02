package programmers.level01.newIDRecommendation;

class NewIDRecommendation_gytj2013 {
    public static String solution(String new_id) { 	
    	for(int i=0; i<new_id.length(); i++) {
    		if(65<=new_id.charAt(i) & new_id.charAt(i)<=90) {
    			new_id = new_id.substring(0, i)+ (char)(new_id.charAt(i)+32) + new_id.substring(i+1);
    		}
    	}
    	
    	for(int i=0; i<new_id.length(); i++) {
    		if("~!@#$%^&*()=+[{]}:?,<>/".contains(new_id.substring(i,i+1))) {  			
    			new_id = new_id.substring(0, i) + new_id.substring(i+1);
    			i--;
    		}
    	}
    	
    	int cnt = 0;
    	for(int i=0; i<new_id.length(); i++) {
    		if(new_id.charAt(i)=='.') { cnt++; }
    		else {cnt=0;}
    		if(cnt>1) {
    			new_id = new_id.substring(0, i) + new_id.substring(i+1);
    			i--; 
    		}
    	}
    	
    	if(new_id.length()!=0) {
	    	if(new_id.charAt(0)=='.') { new_id = new_id.substring(1);}
    	}
    	if(new_id.length()!=0) {
	    	if(new_id.charAt(new_id.length()-1)=='.') { 
	    		new_id = new_id.substring(0, new_id.length()-1);
	    	}
    	}
    	
    	if(new_id.length()==0) { 
    		return "aaa";
    	}
    	
    	if(new_id.length()>=16) { 
    		new_id = new_id.substring(0, 15);
    		if(new_id.charAt(14)=='.') { 
        		new_id = new_id.substring(0, 14);
        	}
    	}
    	
    	while(new_id.length()<3) { 
    		new_id = new_id + new_id.charAt(new_id.length()-1);
		}
    
        return new_id;
    }
}