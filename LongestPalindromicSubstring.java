class LongestPalindromicSubstring {
    private int low, high;
    public String longestPalindrome(String s) {
       if(s.length()<2){
           return s;
       } 
       for(int i =0; i<s.length()-1; i++){
           extendSearch(s,i,i);
           extendSearch(s,i,i+1);
       }
       return s.substring(low,low+high);
    }
    
    private void extendSearch(String s, int j, int k){
        while(j>=0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(high < k - j - 1){
            low = j+1;
            high = k-j-1;
        }
    }
    
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        boolean onlyOne = true;
        char[] chars = s.toCharArray();
        for(int i =0;i<chars.length; i++){
            count[chars[i]]++;
        }
		StringBuilder beg = new StringBuilder();
		StringBuilder mid = new StringBuilder();
		StringBuilder end = new StringBuilder();

		for (char ch = 'A'; ch <= 'z'; ch++) {
			// if current character frequency in odd
			if ((count[ch] % 2 != 0) && onlyOne) {
				mid.append(Character.toString(ch));
				count[ch--]--;
                onlyOne = false;
			}
			// if frequency of even
			else {
				for (int i = 0; i < count[ch] / 2; i++) {
					beg.append(Character.toString(ch));
				}
			}
		}
		
		return mid.length() + (2*beg.length());
    }
}
