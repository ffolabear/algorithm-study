package programmers.level02.phoneNumList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class PhoneNumList_gytj2013 {
    public static boolean solution(String[] phone_book) {
    	Arrays.sort(phone_book, new Comparator<String>() {
    	    @Override
    	    public int compare(String s1, String s2) {
    	        return s2.length() - s1.length();
    	    }
    	});

    	ArrayList<String> list0 = new ArrayList<>();
    	ArrayList<String> list1 = new ArrayList<>();
    	ArrayList<String> list3 = new ArrayList<>();
    	ArrayList<String> list4 = new ArrayList<>();
    	ArrayList<String> list2 = new ArrayList<>();
    	ArrayList<String> list5 = new ArrayList<>();
    	ArrayList<String> list6 = new ArrayList<>();
    	ArrayList<String> list7 = new ArrayList<>();
    	ArrayList<String> list8 = new ArrayList<>();
    	ArrayList<String> list9 = new ArrayList<>();
    	ArrayList<String> listTmp = new ArrayList<>(Arrays.asList(phone_book));
    	
    	int cnt = 0;
    	
    	while(listTmp.size()>1) {
	    	for(String i : listTmp) {
	    		char tmp = i.charAt(cnt);
	    		switch(tmp) {
		    		case '0': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list0.size()>0){
		    					for(String j : list0) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else {list0.add(i);}
		    			break;
		    		case '1': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list1.size()>0) {
		    					for(String j : list1) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list1.add(i);}
		    			break;
		    		case '2': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list2.size()>0) {
		    					for(String j : list2) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list2.add(i);}
		    			break;
		    		case '3': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list3.size()>0) {
		    					for(String j : list3) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list3.add(i);}
		    			break;
		    		case '4': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list4.size()>0) {
		    					for(String j : list4) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list4.add(i);}
		    			break;
		    		case '5':
		    			if(i.substring(cnt).length()==1) {
		    				if(list5.size()>0) {
		    					for(String j : list5) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list5.add(i);}
		    			break;
		    		case '6': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list6.size()>0) {
		    					for(String j : list6) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list6.add(i);}
		    			break;
		    		case '7': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list7.size()>0) {
		    					for(String j : list7) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list7.add(i);}
		    			break;
		    		case '8': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list8.size()>0) {
		    					for(String j : list8) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list8.add(i);}
		    			break;
		    		case '9': 
		    			if(i.substring(cnt).length()==1) {
		    				if(list9.size()>0) {
		    					for(String j : list9) {
		    						if(i.equals(j.substring(0,cnt+1))) {return false;}
		    					}
		    				}
		    			}
		    			else{list9.add(i);}
		    			break;
	    		}
	    	}
	    	listTmp.clear();
	    	if(list0.size()>1)listTmp.addAll(list0);
	    	list0.clear();	    
	    	if(list1.size()>1)listTmp.addAll(list1);
	    	list1.clear();
	    	if(list2.size()>1)listTmp.addAll(list2);
	    	list2.clear();	    	
	    	if(list3.size()>1)listTmp.addAll(list3);
	    	list3.clear();	    	
	    	if(list4.size()>1)listTmp.addAll(list4);
	    	list4.clear();
	    	if(list5.size()>1)listTmp.addAll(list5);
	    	list5.clear();
	    	if(list6.size()>1)listTmp.addAll(list6);
	    	list6.clear();	    	
	    	if(list7.size()>1)listTmp.addAll(list7);
	    	list7.clear();	    	
	    	if(list8.size()>1)listTmp.addAll(list8);
	    	list8.clear();	    	
	    	if(list9.size()>1)listTmp.addAll(list9);
	    	list9.clear();
	    	cnt++;
    	}
        return true;
    }
}
