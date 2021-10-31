package programmers.level01.secretMap;

class SecretMap_gytj2013{
    public static String[] solution(int n, int[] arr1, int[] arr2) {
    	String[][] map1 = new String[n][n];
    	String[][] map2 = new String[n][n];
    	String tmp1 ="";
		String tmp2 ="";
		int len;
    	for(int i=0 ; i<n; i++) {
    		tmp1 = Integer.toBinaryString(arr1[i]);
    		len = n-tmp1.length();
    		for(int j=0; j<len;j++) {
    			tmp1 = "0"+tmp1;
    		}		
    		map1[i] = tmp1.split("");
    		tmp2 = Integer.toBinaryString(arr2[i]);
    		len = n-tmp2.length();
    		for(int j=0; j<len;j++) {
    			tmp2 = "0"+tmp2;
    		}
    		map2[i] = tmp2.split("");
    	}
    	
    	for(int i=0 ; i<n; i++) {
    		for(int j=0 ; j<n; j++) {
    			System.out.print(map2[i][j]);
    		}
    		System.out.println();
    	}
    	
    	
    	String[][] ans = new String[n][n];
    	String answer[] = new String[n];
    	for(int i=0 ; i<n; i++) {
    		for(int j=0 ; j<n; j++) {
    			if(map1[i][j].equals("1") | map2[i][j].equals("1")) {
    				ans[i][j] = "#";
    			}
    			else {
    				ans[i][j] = " ";
				}
    		}
    		answer[i] =String.join("",ans[i]);
    	}
    
        return answer;
    }
}